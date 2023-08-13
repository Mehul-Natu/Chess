package Chess.Piece;

import Chess.Grid.Observer;

public interface Observable {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObserver();
}
