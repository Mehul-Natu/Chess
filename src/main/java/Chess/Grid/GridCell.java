package Chess.Grid;

import Chess.Piece.Piece;
import Chess.Piece.PieceManager;
import Chess.Position;

import java.util.List;

public class GridCell implements Observer {

    private final Position position;

    PieceManager currentPiece;

    List<Observer> listOfObserver;

    public GridCell(Position position) {
        this.position = position;
    }

    @Override
    public void update() {

    }

    public void setCurrentPiece(PieceManager currentPiece) {
        this.currentPiece = currentPiece;
    }

    public void setListOfObserver(List<Observer> listOfObserver) {
        this.listOfObserver = listOfObserver;
    }
}
