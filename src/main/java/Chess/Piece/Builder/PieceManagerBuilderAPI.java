package Chess.Piece.Builder;

import Chess.Move.PlayableMove;
import Chess.Piece.Piece;
import Chess.Piece.PieceManager;
import Chess.Position;

import java.util.Set;

public interface PieceManagerBuilderAPI {

    PieceManagerBuilder setPiece(Piece piece);

    PieceManagerBuilder setCurrentPosition(Position currentPosition);

    PieceManagerBuilder reset();

    PieceManager build();

}
