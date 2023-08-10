package Piece;

import Grid.Observer;

import java.util.List;
import java.util.Set;

public class PieceManager implements Observable {

    Piece piece;

    List<CurrentMoves> currentPlayableMoves;

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
