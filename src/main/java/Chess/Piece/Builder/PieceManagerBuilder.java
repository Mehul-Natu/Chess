package Chess.Piece.Builder;

import Chess.Piece.Piece;
import Chess.Piece.PieceType;

public class PieceManagerBuilder implements PieceManagerBuilderAPI{

    @Override
    public PieceManagerBuilder setPiece(Piece piece) {
        this.piece.setMoveRuleList(moveRuleList);
        return this;
    }

}
