package Chess.Move.MoveGenerator.impl;

import Chess.Grid.Grid;
import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.Set;

public class MGKill extends MoveGeneratorBasedAPI {

    public synchronized static MoveGeneratorBasedAPI getInstance() {
        if (instance == null) {
            instance = new MGKill();
        }
        return instance;
    }

    private MGKill() {}

    @Override
    public void setGrid(Grid grid) {
        this.setGrid(grid);
    }

    @Override
    public Set<PlayableMove> getMoves(Position position) {
        return null;
    }
}
