package Chess.Piece.Builder;

import Chess.Piece.Piece;

public interface PieceFactoryAPI {

    Piece createPiece(PieceBuilder pieceBuilder);

}
