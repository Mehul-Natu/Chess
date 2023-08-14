package Chess.Piece.Builder;

import Chess.Grid.Builder.GridCellBuilder;
import Chess.Grid.GridCell;
import Chess.Move.MoveRule;
import Chess.Piece.Piece;
import Chess.Piece.PieceType;
import Chess.Position;

import java.util.List;

public class PieceBuilder implements PieceBuilderAPI{

    Piece piece;

    @Override
    public PieceBuilder setPieceType(PieceType pieceType) {
        this.piece = new Piece(pieceType);
        return this;
    }

    @Override
    public PieceBuilder setMoveRuleList(List<MoveRule> moveRuleList) {
        this.piece.setMoveRuleList(moveRuleList);
        return this;
    }

    @Override
    public Piece build() {
        return piece;
    }

}
