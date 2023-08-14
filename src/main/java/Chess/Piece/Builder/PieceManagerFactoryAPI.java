package Chess.Piece.Builder;

import Chess.Piece.PieceManager;

public interface PieceManagerFactoryAPI {

    PieceManager createPieceManager(PieceManagerBuilder pieceManagerBuilder);

}
