package Chess.Move.MoveGenerator;

import Chess.Grid.Grid;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.Set;

public abstract class MoveGeneratorBasedAPI {

    private static Grid grid;

    protected static MoveGeneratorBasedAPI instance;


    public abstract void setGrid(Grid grid);
    public abstract Set<PlayableMove> getMoves(Position position);

}
