package Chess.Piece.Builder;

import Chess.Move.IndirectMove;
import Chess.Move.PlayableMove;
import Chess.Piece.Piece;
import Chess.Piece.PieceManager;
import Chess.Piece.PieceType;
import Chess.Position;

import java.util.Set;

public class PieceManagerBuilder implements PieceManagerBuilderAPI{

    PieceManager pieceManager;

    @Override
    public PieceManagerBuilder setPiece(Piece piece) {
        pieceManager.setPiece(piece);
        return this;
    }

    @Override
    public PieceManagerBuilder setCurrentPosition(Position currentPosition) {
        pieceManager.setCurrentPosition(currentPosition);
        return this;
    }

    @Override
    public PieceManager build() {
        return pieceManager;
    }


}
