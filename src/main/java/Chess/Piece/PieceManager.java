package Chess.Piece;

import Chess.Grid.Observer;
import Chess.Move.PlayableMove;

import java.util.List;
import java.util.Set;

public class PieceManager implements Observable {


    Piece piece;

    List<PlayableMove> currentPlayableMoves;

    Set<Observer> gridObservers;


    @Override
    public void subscribe(Observer observer) {

    }

    @Override
    public void unsubscribe(Observer observer) {

    }

    @Override
    public void notifyObserver() {

    }
}
