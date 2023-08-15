package Chess.Move.MoveGenerator.impl;

import Chess.Move.MoveGenerator.MoveGeneratorAPI;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Piece.PieceManager;
import Chess.Position;

import java.util.HashSet;
import java.util.Set;

public class MGKill extends MoveGeneratorAPI {

    private static MoveGeneratorAPI instance;


    public synchronized static MoveGeneratorAPI getInstance() {
        if (instance == null) {
            instance = new MGKill();
        }
        return instance;
    }

    private MGKill() {}

    @Override
    public Set<PlayableMove> getDirectMoves(Position position) {
        HashSet<PlayableMove> playableMoves = new HashSet<>();

        int xIndex = position.getX() + xAndyMagnitude[0];
        int yIndex = position.getY() + xAndyMagnitude[1];

        if (isInBound(xIndex, yIndex)) {
            PieceManager pieceManager = getGrid().getGridCell(xIndex, yIndex).getCurrentPiece();
            if (pieceManager != null
                    && pieceManager.getPiece().getPieceType().isBlack() != this.pieceType.isBlack()) {
                playableMoves.add(new PlayableMove(xIndex, yIndex, MoveType.kill));
            }
        }
        return playableMoves;
    }
}
