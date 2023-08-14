package Chess.Piece.AttackBlocker.impl;

import Chess.Piece.AttackBlocker.AttackerBlockerPositionCalculatorAPI;
import Chess.Position;

import java.util.Set;

public class InclinedLineCalculator implements AttackerBlockerPositionCalculatorAPI {

    private static AttackerBlockerPositionCalculatorAPI instance;

    public static AttackerBlockerPositionCalculatorAPI getInstance() {
        if (instance == null) {
            instance = new InclinedLineCalculator();
        }
        return instance;
    }
    private InclinedLineCalculator() {
    }

    @Override
    public Set<Position> getPositions(Position attacker, Position victim) {
        return null;
    }
}
