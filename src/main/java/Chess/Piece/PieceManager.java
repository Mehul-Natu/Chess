package Chess.Piece;

import Chess.Grid.Observer;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.Set;

public class PieceManager implements Observable {


    Piece piece;
    Set<PlayableMove> currentPlayableMoves;
    Set<Observer> gridObservers;


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
    public boolean containsPlaybleMove(Position position) {
        return currentPlayableMoves.contains(position);
    }

    public PieceManager(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
