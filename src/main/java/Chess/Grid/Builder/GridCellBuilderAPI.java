package Chess.Grid.Builder;

import Chess.Grid.GridCell;
import Chess.Grid.Observer;
import Chess.Piece.Observable;
import Chess.Piece.PieceManager;
import Chess.Position;

import java.util.Set;

public interface GridCellBuilderAPI {

    GridCellBuilder setPosition(Position position);

    GridCellBuilder setCurrentPiece(PieceManager currentPiece);
    GridCellBuilder setListOfObservable(Set<Observable> listOfObservable);
    GridCell build();

}
