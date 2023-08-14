package Chess.Piece.AttackBlocker;

import Chess.Position;

import java.util.Set;

public class AttackBlockerManager {

    AttackBlockerStrategy attackBlockerStrategy;


    public AttackBlockerStrategy configureStrategy(Position startingPos, Position endingPos) {

        int xDiff = endingPos.getX() - startingPos.getX();
        int yDiff = endingPos.getY() - startingPos.getY();

        if (xDiff == 0 || yDiff == 0) {
            return AttackBlockerStrategy.StraightLine;
        } else {
            return AttackBlockerStrategy.InclinedLine;
        }
    }

    public Set<Position> getPositionBetweenAttackerAndVictim(Position startingPos, Position endingPos) {
        if (attackBlockerStrategy != null) {
            return null;
        }
        return attackBlockerStrategy.getAlgo().getPositions(startingPos, endingPos);
    }


    public AttackBlockerStrategy getAttackBlockerStrategy() {
        return attackBlockerStrategy;
    }

    public void setAttackBlockerStrategy(AttackBlockerStrategy attackBlockerStrategy) {
        this.attackBlockerStrategy = attackBlockerStrategy;
    }
}
