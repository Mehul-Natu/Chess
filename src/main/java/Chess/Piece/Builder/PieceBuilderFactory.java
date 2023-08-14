package Chess.Piece.Builder;

import Chess.Grid.Builder.GridCellFactory;
import Chess.Piece.Piece;

public class PieceBuilderFactory implements PieceBuilderFactoryAPI{

    public static PieceBuilderFactory instance;
    public PieceBuilderFactory() {
    }
    public synchronized static PieceBuilderFactory getInstance() {
        if (instance == null) {
            instance = new PieceBuilderFactory();
        }
        return instance;
    }
    @Override
    public Piece createPiece(PieceBuilder pieceBuilder) {
        return pieceBuilder.build();
    }
}
