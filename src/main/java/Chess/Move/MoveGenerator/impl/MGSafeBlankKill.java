package Chess.Move.MoveGenerator.impl;

import Chess.Grid.Grid;
import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Piece.Observable;
import Chess.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MGSafeBlankKill extends MoveGeneratorBasedAPI {

    private static MoveGeneratorBasedAPI instance;


    public synchronized static MoveGeneratorBasedAPI getInstance() {
        if (instance == null) {
            instance = new MGSafeBlankKill();
        }
        return instance;
    }

    private MGSafeBlankKill() {}

    @Override
    public Set<PlayableMove> getMoves(Position position) {
        HashSet<PlayableMove> playableMoves = new HashSet<>();

        int xIndex = position.getX() + xAndyMagnitude[0];
        int yIndex = position.getY() + xAndyMagnitude[1];

        if (isInBound(xIndex, yIndex)) {
            List<Observable> listOfAttackers = getGrid().getGridCell(xIndex, yIndex)
                    .getObservers(getPieceType().isBlack());
            if (listOfAttackers.size() == 0) {
                playableMoves.add(new PlayableMove(xIndex, yIndex, MoveType.safe_blank_kill));
            }
        }
        return playableMoves;

    }
}
