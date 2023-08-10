package Move;

public class MoveRule {

    final MoveType moveType;

    final int[] xAndyMagnitude;

    private MoveRule(MoveType moveType, int[] xAndyMagnitude) {
        this.moveType = moveType;
        this.xAndyMagnitude = xAndyMagnitude;
    }
}
