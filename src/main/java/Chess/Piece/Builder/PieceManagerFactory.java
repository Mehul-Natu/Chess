package Chess.Piece.Builder;

import Chess.Piece.PieceManager;

public class PieceManagerFactory implements PieceManagerFactoryAPI {

    public static PieceManagerFactory instance;
    private PieceManagerFactory() {
    }
    public synchronized static PieceManagerFactory getInstance() {
        if (instance == null) {
            instance = new PieceManagerFactory();
        }
        return instance;
    }


    @Override
    public PieceManager createPieceManager(PieceManagerBuilder pieceManagerBuilder) {
        return pieceManagerBuilder.build();
    }
}
