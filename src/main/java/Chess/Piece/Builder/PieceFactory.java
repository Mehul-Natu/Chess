package Chess.Piece.Builder;

import Chess.Piece.Piece;

public class PieceFactory implements PieceFactoryAPI {

    public static PieceFactory instance;
    public PieceFactory() {
    }
    public synchronized static PieceFactory getInstance() {
        if (instance == null) {
            instance = new PieceFactory();
        }
        return instance;
    }
    @Override
    public Piece createPiece(PieceBuilder pieceBuilder) {
        return pieceBuilder.build();
    }
}
