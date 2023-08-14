package Chess.Move;

import Chess.Piece.PieceManager;
import Chess.Position;

public class IndirectMove extends Position {

    PieceManager saviour;

    MoveType moveType;

    public IndirectMove(int x, int y, PieceManager saviour, MoveType moveType) {
        super(x, y);
        this.saviour = saviour;
        this.moveType = moveType;
    }

    public PieceManager getSaviour() {
        return saviour;
    }
}
