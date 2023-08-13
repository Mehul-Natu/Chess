package Chess.Move.MoveGenerator;

import Chess.Grid.Grid;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.Set;

public abstract class MoveGeneratorBasedAPI {

    private static Grid grid;
    protected static MoveGeneratorBasedAPI instance;

    protected int[] xAndyMagnitude;

    public abstract void setGrid(Grid grid);

    public abstract void setxAndyMagnitude(int[] xAndyMagnitude);
    public abstract Set<PlayableMove> getMoves(Position position);



}
