package Chess.Move.GridToMovementBridge;

import Chess.Game.CurrentStateConfiguration;
import Chess.Game.Player;
import Chess.Grid.Grid;
import Chess.Grid.GridCell;
import Chess.Move.MovementResponse;
import Chess.Move.PlayableMove;
import Chess.Piece.AttackBlocker.AttackBlocker;
import Chess.Piece.AttackBlocker.AttackBlockerManager;
import Chess.Piece.Observable;
import Chess.Piece.PieceManager;
import Chess.Position;

import java.util.List;
import java.util.Set;

import static Chess.Move.MovementResponse.MovementResponseType.*;

public class MovementEncapsulator implements MovementImplementor {

    private final Grid grid;

    private final AttackBlockerManager attackBlockerManager;

    public MovementEncapsulator(Grid grid) {
        this.grid = grid;
        attackBlockerManager = new AttackBlockerManager();
    }

/*
    public void refreshObserverAndMovements(PieceManager pieceManager, Grid grid) {
        pieceManager.refreshMoves();
        Set<IndirectMove> indirectMoves = pieceManager.getIndirectMoves();
        Set<PlayableMove> directMoves = pieceManager.getCurrentPlayableMoves();

        // use this method as an Adapter
        for (PlayableMove playableMove : directMoves) {
            GridCell cell = grid.getGridCell(playableMove);
            pieceManager.subscribe(cell);
            cell.addDirectMover(pieceManager);
        }

        for (IndirectMove indirectMove : indirectMoves) {
            GridCell cell = grid.getGridCell(indirectMove);
            pieceManager.subscribe(cell);
            cell.addInDirectMover(pieceManager);
        }
    }
 */

    @Override
    public MovementResponse makeMove(Position startingPos, Position endingPos, Player player) {

        GridCell gridCell = grid.getGridCell(startingPos);
        if (!gridCell.hasPiece()) {
            System.out.println("Empty Position selected");
            return new MovementResponse(EMPTY_GRID_CELL);
        }

        if (gridCell.getCurrentPiece().isBlack() != player.isBlack()) {
            System.out.println("Wrong Piece selected");
            return new MovementResponse(WRONG_PIECE_SELECTED);
        }

        PieceManager currentPiece = gridCell.getCurrentPiece();
        currentPiece.refreshMoves();
        AttackBlocker attackBlockerKing = currentPiece.getAttackBlockerIfKingSaver();


        if (attackBlockerKing != null) {
            Set<PlayableMove> playableMoves = currentPiece.getCurrentPlayableMoves();
            attackBlockerManager.configureStrategy(attackBlockerKing.getAttackedBy().getPosition(),
                    attackBlockerKing.getSaving().getPosition());
            Set<Position> playablePosWhileSavingKing = attackBlockerManager.getPositionBetweenAttackerAndVictim();

            playablePosWhileSavingKing.retainAll(playableMoves);
            if (!playablePosWhileSavingKing.contains(endingPos)) {
                return new MovementResponse(CANNOT_MOVE_WITHOUT_DEFENDING_KING);
            }
        } else if (!currentPiece.containsPlayableMove(endingPos)) {
            System.out.println("Cannot play this move");
            return new MovementResponse(CANNOT_MOVE_THERE);
        }
        // everything is checked now
        //to check everything after this
        grid.getGridCell(startingPos).setCurrentPiece(null);
        grid.setPiece(currentPiece, endingPos);
        //currentPiece.setCurrentPosition(endingPos);
        return new MovementResponse(MOVED_SUCCESSFULLY);
    }

    @Override
    public MovementResponse checkOrCheckMate(CurrentStateConfiguration stateConfiguration) {

        Position kingPos;
        boolean opponentColorIsBlack;

        if (stateConfiguration.getLastMoveByPlayerOne()) {
            kingPos = GridCell.getBlackKingPos();
            opponentColorIsBlack = false;
        } else {
            kingPos = GridCell.getWhiteKingPos();
            opponentColorIsBlack = true;
        }

        GridCell gridCell = grid.getGridCell(kingPos);
        List<Observable> attackerList = gridCell.getDirectMovers(opponentColorIsBlack);

        if (attackerList.size() > 0) {

            PieceManager kingPiece = gridCell.getCurrentPiece();
            kingPiece.refreshMoves();
            List<PlayableMove> playableMove = kingPiece.getCurrentPlayableMovesList();

            if (playableMove.size() == 0) {

                Position attackerPos = attackerList.get(0).getPosition();
                attackBlockerManager.configureStrategy(kingPos, attackerPos);
                Set<Position> positions = attackBlockerManager.getPositionBetweenAttackerAndVictim();

                for (Position pos : positions) {
                    GridCell gridCellInBetween = grid.getGridCell(pos);
                    List<Observable> listOfSaviour = gridCellInBetween.getDirectMovers(!opponentColorIsBlack);
                    if (listOfSaviour.size() > 0) {
                        MovementResponse<Player> response = new MovementResponse<>(CHECK);
                        response.setExtraField(!opponentColorIsBlack ? stateConfiguration.getPlayerOne() : stateConfiguration.getPlayerTwo());
                        return response;
                    }
                }

                MovementResponse<Player> response = new MovementResponse<Player>(CHECK);
                response.setExtraField(!opponentColorIsBlack ? stateConfiguration.getPlayerOne() : stateConfiguration.getPlayerTwo());
                return response;

            } else {

                MovementResponse<Player> response = new MovementResponse<Player>(CHECK);
                response.setExtraField(!opponentColorIsBlack ? stateConfiguration.getPlayerOne() : stateConfiguration.getPlayerTwo());
                return response;
            }
        }
        return new MovementResponse(NO_CHECK);
    }
}
