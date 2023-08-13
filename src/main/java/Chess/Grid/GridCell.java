package Chess.Grid;

import Chess.Piece.Observable;
import Chess.Piece.PieceManager;
import Chess.Position;
import java.util.Set;

public class GridCell implements Observer {

    private final Position position;

    PieceManager currentPiece;

    Set<Observable> listOfPublisher;

    public GridCell(Position position) {
        this.position = position;
    }

    @Override
    public void update(Observable observable) {
        //if (observable)
    }

    public void setCurrentPiece(PieceManager currentPiece) {
        this.currentPiece = currentPiece;
    }

    public void setListOfObserver(Set<Observable> listOfPublisher) {
        this.listOfPublisher = listOfPublisher;
    }
}
