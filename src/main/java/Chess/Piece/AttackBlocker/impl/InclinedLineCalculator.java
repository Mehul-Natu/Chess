package Chess.Piece.AttackBlocker.impl;

import Chess.Piece.AttackBlocker.AttackerBlockerPositionCalculatorAPI;
import Chess.Position;

import java.util.HashSet;
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
        Set<Position> set = new HashSet<>();

        int xattacker = attacker.getX();
        int yattacker = attacker.getY();

        int xvictim = victim.getX();
        int yvictim = victim.getY();

        int xcalc = xattacker-xvictim;
        int ycalc = yattacker-yvictim;



        return set;
    }
}
