package Chess.Piece.AttackBlocker;

import Chess.Position;

import java.util.Set;

public class AttackBlockerManager {

    AttackBlockerStrategy attackBlockerStrategy;

    Position startingPos;

    Position endingPos;


    public AttackBlockerStrategy configureStrategy(Position startingPos, Position endingPos) {

        this.startingPos = startingPos;
        this.endingPos = endingPos;

        int xDiff = endingPos.getX() - startingPos.getX();
        int yDiff = endingPos.getY() - startingPos.getY();

        if (xDiff == 0 || yDiff == 0) {
            return AttackBlockerStrategy.StraightLine;
        } else {
            return AttackBlockerStrategy.InclinedLine;
        }
    }

    public Set<Position> getPositionBetweenAttackerAndVictim() {
        if (attackBlockerStrategy != null) {
            return null;
        }
        return attackBlockerStrategy.getAlgo().getPositions(this.startingPos, this.endingPos);
    }
}
