package Chess.Piece;

import Chess.Grid.Observer;
import Chess.Move.IndirectMove;
import Chess.Position;

public interface Observable {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObserver();

    boolean containsPlayableMove(Position position);

    boolean containsIndirectMove(Position position);

    Piece getPiece();

    IndirectMove getIndirectMove(Position position);




}
