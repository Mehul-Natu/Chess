package Chess.Piece.AttackBlocker;

import Chess.Piece.AttackBlocker.impl.InclinedLineCalculator;
import Chess.Piece.AttackBlocker.impl.StraightLineCalculator;

public enum AttackBlockerStrategy {

    StraightLine(StraightLineCalculator.getInstance()),
    InclinedLine(InclinedLineCalculator.getInstance());


    private final AttackerBlockerPositionCalculatorAPI algo;

    AttackBlockerStrategy(AttackerBlockerPositionCalculatorAPI algo) {
        this.algo = algo;
    }

    public AttackerBlockerPositionCalculatorAPI getAlgo() {
        return algo;
    }
}
