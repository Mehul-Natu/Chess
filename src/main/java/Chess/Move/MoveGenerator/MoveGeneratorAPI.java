package Chess.Move.MoveGenerator;

import Chess.Grid.GameToGridAdapter;
import Chess.Move.IndirectMove;
import Chess.Move.PlayableMove;
import Chess.Piece.PieceType;
import Chess.Position;

import java.util.HashSet;
import java.util.Set;

import static Chess.Move.MoveConstants.GRID_LOWER_LIMIT;
import static Chess.Move.MoveConstants.GRID_UPPER_LIMIT;

public abstract class MoveGeneratorAPI {

    protected static GameToGridAdapter grid;
    protected int[] xAndyMagnitude;

    protected PieceType pieceType;

    public static void setGrid(GameToGridAdapter newGrid) {
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

    public abstract Set<PlayableMove> getDirectMoves(Position position);

    public Set<IndirectMove> getInDirectMoves(Position position) {
        return new HashSet<>();
    }

    public static GameToGridAdapter getGrid() {
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
