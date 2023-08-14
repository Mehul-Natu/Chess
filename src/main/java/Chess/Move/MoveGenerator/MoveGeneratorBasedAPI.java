package Chess.Move.MoveGenerator;

import Chess.Grid.Grid;
import Chess.Move.PlayableMove;
import Chess.Piece.Piece;
import Chess.Piece.PieceType;
import Chess.Position;

import java.util.Set;

import static Chess.Move.MoveConstants.GRID_LOWER_LIMIT;
import static Chess.Move.MoveConstants.GRID_UPPER_LIMIT;

public abstract class MoveGeneratorBasedAPI {

    protected static Grid grid;
    protected int[] xAndyMagnitude;

    protected PieceType pieceType;

    public static void setGrid(Grid newGrid) {
        if (grid == null) {
            grid = newGrid;
        }
    }

    public void setxAndyMagnitude(int[] xAndyMagnitude) {
        this.xAndyMagnitude = xAndyMagnitude;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public abstract Set<PlayableMove> getMoves(Position position);

    public static Grid getGrid() {
        return grid;
    }

    public int[] getxAndyMagnitude() {
        return xAndyMagnitude;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isInBound(int xIndex, int yIndex) {
        return xIndex >= GRID_LOWER_LIMIT && xIndex <= GRID_UPPER_LIMIT
                && yIndex >= GRID_LOWER_LIMIT && yIndex <= GRID_UPPER_LIMIT;
    }
}
