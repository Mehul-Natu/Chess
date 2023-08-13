package Chess.Grid.Builder;

import Chess.Grid.Observer;
import Chess.Grid.GridCell;
import Chess.Piece.Piece;
import Chess.Position;

import java.util.List;

public interface GridCellBuilderAPI {

    GridCellBuilder setPosition(Position position);
    GridCellBuilder setCurrentPiece(Piece currentPiece);
    GridCellBuilder setListOfObservable(List<Observer> listOfObservable);
    GridCell build();

}