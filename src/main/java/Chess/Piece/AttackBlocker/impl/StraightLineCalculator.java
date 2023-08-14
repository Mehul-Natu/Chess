package Chess.Piece.AttackBlocker.impl;

import Chess.Piece.AttackBlocker.AttackerBlockerPositionCalculatorAPI;
import Chess.Position;

import java.util.HashSet;
import java.util.Set;

public class StraightLineCalculator implements AttackerBlockerPositionCalculatorAPI {

    private static AttackerBlockerPositionCalculatorAPI instance;

    public static AttackerBlockerPositionCalculatorAPI getInstance() {
        if (instance == null) {
            instance = new StraightLineCalculator();
        }
        return instance;
    }
    private StraightLineCalculator() {
    }

    @Override
    public Set<Position> getPositions(Position attacker, Position victim) {
        Set<Position> set = new HashSet<>();

        return null;
    }
}
