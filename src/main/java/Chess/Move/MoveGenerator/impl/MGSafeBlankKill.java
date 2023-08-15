package Chess.Move.MoveGenerator.impl;

import Chess.Move.MoveGenerator.MoveGeneratorAPI;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Piece.Observable;
import Chess.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MGSafeBlankKill extends MoveGeneratorAPI {

    private static MoveGeneratorAPI instance;


    public synchronized static MoveGeneratorAPI getInstance() {
        if (instance == null) {
            instance = new MGSafeBlankKill();
        }
        return instance;
    }

    private MGSafeBlankKill() {}

    @Override
    public Set<PlayableMove> getDirectMoves(Position position) {
        HashSet<PlayableMove> playableMoves = new HashSet<>();

        int xIndex = position.getX() + xAndyMagnitude[0];
        int yIndex = position.getY() + xAndyMagnitude[1];

        if (isInBound(xIndex, yIndex) && getGrid().getGridCell(xIndex, yIndex).getCurrentPiece() == null) {
            List<Observable> listOfAttackers = getGrid().getGridCell(xIndex, yIndex)
                    .getDirectMovers(!getPieceType().isBlack());
            if (listOfAttackers.size() == 0) {
                playableMoves.add(new PlayableMove(xIndex, yIndex, MoveType.safe_blank_kill));
            }
        }
        return playableMoves;

    }
}
