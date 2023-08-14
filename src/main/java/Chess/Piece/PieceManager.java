package Chess.Piece;

import Chess.Grid.Observer;
import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.MoveRule;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.HashSet;
import java.util.Set;

public class PieceManager implements Observable {


    Piece piece;
    Set<PlayableMove> currentPlayableMoves;
    Set<Observer> gridObservers;
    Position currentPosition;

    public PieceManager(Piece piece, Position currentPosition) {
        this.piece = piece;
        this.currentPosition = currentPosition;
        currentPlayableMoves = new HashSet<>();
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

    }

    @Override
    public boolean containsPlayableMove(Position position) {
        return currentPlayableMoves.contains(position);
    }

    @Override
    public Piece getPiece() {
        return this.piece;
    }

    public boolean isBlack() {
        return this.piece.getPieceType().isBlack();
    }

    public void refreshCurrentPlayableMoves() {
        Set<PlayableMove> set = new HashSet<>();
        for (MoveRule rule : piece.getMoveRuleList()) {
            MoveType moveType = rule.getMoveType();
            MoveGeneratorBasedAPI moveGenerator = moveType.getMoveGeneratorBasedAPI();
            moveGenerator.setPieceType(this.piece.pieceType);
            moveGenerator.setxAndyMagnitude(rule.getxAndyMagnitude());
            set.addAll(moveGenerator.getMoves(this.currentPosition));
        }
        this.currentPlayableMoves.addAll(set);
    }
}
