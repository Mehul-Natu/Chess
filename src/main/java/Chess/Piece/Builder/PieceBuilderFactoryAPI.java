package Chess.Piece.Builder;

import Chess.Grid.Builder.GridCellBuilder;
import Chess.Grid.GridCell;
import Chess.Piece.Piece;
import Chess.Position;

public interface PieceBuilderFactoryAPI {

    Piece createPiece(PieceBuilder pieceBuilder);

}
