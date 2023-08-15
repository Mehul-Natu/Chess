package Chess.Piece;

import Chess.Grid.Observer;
import Chess.Move.IndirectMove;
import Chess.Move.MoveGenerator.MoveGeneratorAPI;
import Chess.Move.MoveRule;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Piece.AttackBlocker.AttackBlocker;
import Chess.Position;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static Chess.Piece.PieceType.*;

public class PieceManager implements Observable {

    Piece piece;
    Set<PlayableMove> currentPlayableMoves;
    Set<IndirectMove> indirectMoves;
    Set<Observer> gridObservers;
    Position currentPosition;

    HashMap<PieceManager, AttackBlocker> hostageToAttackBlockerMap;

    public PieceManager(Piece piece, Position currentPosition) {
        this.piece = piece;
        this.currentPosition = currentPosition;
        this.currentPlayableMoves = new HashSet<>();
        this.indirectMoves = new HashSet<>();
        this.hostageToAttackBlockerMap = new HashMap<>();
        this.gridObservers = new HashSet<>();
    }

    public PieceManager() {
        this.currentPlayableMoves = new HashSet<>();
        this.indirectMoves = new HashSet<>();
        this.hostageToAttackBlockerMap = new HashMap<>();
        this.gridObservers = new HashSet<>();
    }

    @Override
    public void subscribe(Observer observer) {
        gridObservers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        gridObservers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        //before calling this check if the move can be made or not and also change to new position before calling this
        //also refresh the playable move
        for (Observer observer : gridObservers) {
            observer.update(this);
        }

    }

    @Override
    public boolean containsPlayableMove(Position position) {
        return currentPlayableMoves.contains(position);
    }

    @Override
    public boolean containsIndirectMove(Position position) {
        return indirectMoves.contains(position);
    }

    @Override
    public Piece getPiece() {
        return this.piece;
    }

    @Override
    public IndirectMove getIndirectMove(Position position) {
        for (IndirectMove indirectMove : indirectMoves) {
            if (indirectMove.equals(position)) {
                return indirectMove;
            }
        }
        return null;
    }

    @Override
    public Position getPosition() {
        return this.currentPosition;
    }

    public boolean isBlack() {
        return this.piece.getPieceType().isBlack();
    }

    public void refreshMoves() {
        Set<PlayableMove> playableMoves = new HashSet<>();
        Set<IndirectMove> indirectMoves = new HashSet<>();
        for (MoveRule rule : piece.getMoveRuleList()) {
            MoveType moveType = rule.getMoveType();
            MoveGeneratorAPI moveGenerator = moveType.getMoveGeneratorBasedAPI();
            moveGenerator.setPieceType(this.piece.pieceType);
            moveGenerator.setxAndyMagnitude(rule.getxAndyMagnitude());
            playableMoves.addAll(moveGenerator.getDirectMoves(this.currentPosition));
            indirectMoves.addAll(moveGenerator.getInDirectMoves(this.currentPosition));
        }
        this.indirectMoves.addAll(indirectMoves);
        this.currentPlayableMoves.addAll(playableMoves);
        this.notifyObserver();
    }

    public Set<PlayableMove> getCurrentPlayableMoves() {
        return currentPlayableMoves;
    }

    public Set<IndirectMove> getIndirectMoves() {
        return indirectMoves;
    }

    public HashMap<PieceManager, AttackBlocker> getHostageToAttackBlockerMap() {
        return hostageToAttackBlockerMap;
    }

    public void addAttackBlockerDetails(PieceManager saviourOf, AttackBlocker attackBlockerDetails) {
        this.hostageToAttackBlockerMap.put(saviourOf, attackBlockerDetails);
    }

    public void removeAttackBlockerDetails(PieceManager saviourOf) {
        this.hostageToAttackBlockerMap.remove(saviourOf);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
        this.refreshMoves();
    }

    @Override
    public PieceManager clone() {
        return new PieceManager();
    }


    public AttackBlocker getAttackBlockerIfKingSaver() {
        for (PieceManager pieceManager : this.hostageToAttackBlockerMap.keySet()) {
            if (isBlack()) {
                if (BlackKing.equals(pieceManager.getPiece().getPieceType())) {
                    return this.hostageToAttackBlockerMap.get(pieceManager);
                }
            } else {
                if (WhiteKing.equals(pieceManager.getPiece().getPieceType())) {
                    return this.hostageToAttackBlockerMap.get(pieceManager);
                }
            }
        }
        return null;
    }


}
