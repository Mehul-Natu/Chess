package Chess.Move.MoveGenerator.impl;

import Chess.Grid.Grid;
import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.HashSet;
import java.util.Set;

import static Chess.Move.MoveConstants.GRID_LOWER_LIMIT;
import static Chess.Move.MoveConstants.GRID_UPPER_LIMIT;

public class MGKill extends MoveGeneratorBasedAPI {

    private static MoveGeneratorBasedAPI instance;


    public synchronized static MoveGeneratorBasedAPI getInstance() {
        if (instance == null) {
            instance = new MGKill();
        }
        return instance;
    }

    private MGKill() {}

    @Override
    public Set<PlayableMove> getMoves(Position position) {
        HashSet<PlayableMove> playableMoves = new HashSet<>();

        int xIndex = position.getX() + xAndyMagnitude[0];
        int yIndex = position.getY() + xAndyMagnitude[1];

        if (isInBound(xIndex, yIndex)) {
            if (getGrid().getGridCell(xIndex, yIndex).getCurrentPiece() != null) {
                playableMoves.add(new PlayableMove(xIndex, yIndex, MoveType.jump_blank_kill));
            }
        }
        return playableMoves;
    }
}
