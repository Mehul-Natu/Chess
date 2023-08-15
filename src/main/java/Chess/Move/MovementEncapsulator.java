package Chess.Move;

import Chess.Game.Player;
import Chess.Grid.Grid;
import Chess.Grid.GridCell;
import Chess.Piece.AttackBlocker.AttackBlocker;
import Chess.Piece.AttackBlocker.AttackBlockerManager;
import Chess.Piece.PieceManager;
import Chess.Position;

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
        grid.setPiece(currentPiece, endingPos);
        //currentPiece.setCurrentPosition(endingPos);
        return new MovementResponse(MOVED_SUCCESSFULLY);
    }
}
