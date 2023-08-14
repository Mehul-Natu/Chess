package Chess.Piece.Builder;

import Chess.Piece.PieceManager;

public class PieceManagerBuilderFactory implements PieceManagerBuilderFactoryAPI {

    public static PieceManagerBuilderFactory instance;
    public PieceManagerBuilderFactory() {
    }
    public synchronized static PieceManagerBuilderFactory getInstance() {
        if (instance == null) {
            instance = new PieceManagerBuilderFactory();
        }
        return instance;
    }


    @Override
    public PieceManager createPiece(PieceManagerBuilder pieceManagerBuilder) {
        return pieceManagerBuilder.build();
    }
}
