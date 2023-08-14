package Chess.Piece.Builder;

import Chess.Piece.PieceManager;

public interface PieceManagerBuilderFactoryAPI {

    PieceManager createPiece(PieceManagerBuilder pieceManagerBuilder);

}
