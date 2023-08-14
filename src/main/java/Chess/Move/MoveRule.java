package Chess.Move;

public class MoveRule {

    final MoveType moveType;

    final int[] xAndyMagnitude;

    public MoveRule(MoveType moveType, int[] xAndyMagnitude) {
        this.moveType = moveType;
        this.xAndyMagnitude = xAndyMagnitude;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public int[] getxAndyMagnitude() {
        return xAndyMagnitude;
    }
}
