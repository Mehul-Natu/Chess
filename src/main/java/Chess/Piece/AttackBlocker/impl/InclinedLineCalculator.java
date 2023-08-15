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

        int xcalc = attacker.getX() - victim.getX();
        int ycalc = attacker.getY() - victim.getY();

        int xAdder = xcalc > 0 ? 1 : -1;
        int yAdder = ycalc > 0 ? 1 : -1;
        int x = victim.getX() + xAdder;
        int y = victim.getY() + yAdder;

        while (x != attacker.getX() && y != attacker.getY()) {
            set.add(new Position(x, y));
            x += xAdder;
            y += yAdder;
        }

        set.add(attacker);

        return set;
    }
}
