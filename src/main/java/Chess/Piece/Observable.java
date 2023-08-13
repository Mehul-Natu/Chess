package Chess.Piece;

import Chess.Grid.Observer;
import Chess.Position;

public interface Observable {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObserver();

    boolean containsPlaybleMove(Position position);
}
