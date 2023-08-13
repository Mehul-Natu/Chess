package Chess.Move.MoveGenerator.impl;

import Chess.Grid.Grid;
import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.Set;

public class MGBlank extends MoveGeneratorBasedAPI {

    public synchronized static MoveGeneratorBasedAPI getInstance() {
        if (instance == null) {
            instance = new MGBlank();
        }
        return instance;
    }

    private MGBlank() {}

    @Override
    public void setGrid(Grid grid) {
        this.setGrid(grid);
    }

    @Override
    public void setxAndyMagnitude(int[] xAndyMagnitude) {
        setxAndyMagnitude(xAndyMagnitude);
    }

    @Override
    public Set<PlayableMove> getMoves(Position position) {
        return null;
    }
}
