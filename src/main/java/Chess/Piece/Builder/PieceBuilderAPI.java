package Chess.Piece.Builder;

import Chess.Move.MoveRule;
import Chess.Piece.Piece;
import Chess.Piece.PieceType;

import java.util.List;

public interface PieceBuilderAPI {

    PieceBuilder setPieceType(PieceType pieceType);

    PieceBuilder setMoveRuleList(List<MoveRule> moveRuleList);

    Piece build();
}
