package Chess.Piece;

import Chess.Move.MoveRule;
import java.util.List;

public class Piece {

    final PieceType pieceType;

    final List<MoveRule> moveRuleList;

    public Piece(PieceType pieceType, List<MoveRule> moveRuleList) {
        this.pieceType = pieceType;
        this.moveRuleList = moveRuleList;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public List<MoveRule> getMoveRuleList() {
        return moveRuleList;
    }
}
