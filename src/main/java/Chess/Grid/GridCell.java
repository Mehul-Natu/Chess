package Chess.Grid;

import Chess.Piece.Piece;
import Chess.Position;

import java.util.List;

public class GridCell implements Observer {

    private final Position position;

    Piece currentPiece;

    List<Observer> listOfObserver;

    public GridCell(Position position) {
        this.position = position;
    }

    @Override
    public void update() {

    }
}
