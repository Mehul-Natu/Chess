package Chess.Piece.Builder;

import Chess.Piece.Piece;

public class PieceBuilderFactory implements PieceBuilderFactoryAPI{


    @Override
    public Piece createPiece(PieceBuilder pieceBuilder) {
        return pieceBuilder.build();
    }
}
