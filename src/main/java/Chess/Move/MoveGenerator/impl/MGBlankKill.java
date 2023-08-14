package Chess.Move.MoveGenerator.impl;

import Chess.Grid.Grid;
import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.HashSet;
import java.util.Set;

import static Chess.Move.MoveConstants.*;
import static Chess.Move.MoveConstants.GRID_UPPER_LIMIT;

public class MGBlankKill extends MoveGeneratorBasedAPI {

    private static MoveGeneratorBasedAPI instance;

    public synchronized static MoveGeneratorBasedAPI getInstance() {
        if (instance == null) {
            instance = new MGBlankKill();
        }
        return instance;
    }

    private MGBlankKill() {}

    @Override
    public Set<PlayableMove> getMoves(Position position) {
        int[] xAndyMagnitude = instance.getxAndyMagnitude();
        HashSet<PlayableMove> playableMoves = new HashSet<>();
        int xIndex = position.getX();
        int yIndex = position.getY();

        if ((xAndyMagnitude[0] == INFINITE_ADD || xAndyMagnitude[0] == INFINITE_SUBTRACT)
                || (xAndyMagnitude[1] != INFINITE_ADD || xAndyMagnitude[1] != INFINITE_SUBTRACT)) {

            int xAdder;
            int yAdder;
            int xLimit;
            int yLimit;

            if (xAndyMagnitude[0] != 0) {
                if (xAndyMagnitude[0] == INFINITE_ADD) {
                    xAdder = 1;
                    xLimit = 8;
                } else {
                    xAdder = -1;
                    xLimit = -1;
                }
            } else {
                xAdder = 0;
                xLimit = 8;
            }

            if (xAndyMagnitude[1] != 0) {
                if (xAndyMagnitude[1] == INFINITE_ADD) {
                    yAdder = 1;
                    yLimit = 8;
                } else {
                    yAdder = -1;
                    yLimit = -1;
                }
            } else {
                yAdder = 0;
                yLimit = 8;
            }

            xIndex += xAdder;
            yIndex += yAdder;

            while (xIndex != xLimit && yIndex != yLimit) {

                if (getGrid().getGridCell(xIndex, yIndex).getCurrentPiece() == null) {
                    playableMoves.add(new PlayableMove(xIndex, yIndex, MoveType.blank_kill));
                } else {
                    playableMoves.add(new PlayableMove(xIndex, yIndex, MoveType.blank_kill));
                    break;
                }
                xIndex += xAdder;
                yIndex += yAdder;
            }

        } else {
            xIndex += xAndyMagnitude[0];
            yIndex += xAndyMagnitude[1];

            if (isInBound(xIndex, yIndex)) {
                playableMoves.add(new PlayableMove(xIndex, yIndex, MoveType.blank_kill));
            }

        }

        return playableMoves;
    }
}
