package Chess.Piece;

import Chess.Move.MoveRule;
import java.util.List;
import java.util.Objects;

public class Piece implements Cloneable{

    final PieceType pieceType;

    List<MoveRule> moveRuleList;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

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

    public void setMoveRuleList(List<MoveRule> moveRuleList) {
        this.moveRuleList = moveRuleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece piece)) return false;
        return getPieceType() == piece.getPieceType() && getMoveRuleList().equals(piece.getMoveRuleList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPieceType(), getMoveRuleList());
    }


    @Override
    public Piece clone() {
        return new Piece(this.pieceType);
    }

}
