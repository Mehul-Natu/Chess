package Piece;

import Grid.Observer;

public interface Observable {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObserver();
}
