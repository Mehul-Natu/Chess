package Chess.Move.MoveGenerator.impl;

import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.Set;

public class MGKill implements MoveGeneratorBasedAPI {




    public static MoveGeneratorBasedAPI getInstance() {
        if (instance == null) {
            instance = new MGKill();
        }
        return instance;
    }



    private MGKill() {}

    @Override
    public Set<PlayableMove> getMoves(Position position) {
        return null;
    }
}
