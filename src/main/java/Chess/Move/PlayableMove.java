package Chess.Move;

import Chess.Position;

public class PlayableMove extends Position {
    MoveType moveType;

    public PlayableMove(int x, int y, MoveType moveType) {
        super(x, y);
        this.moveType = moveType;
    }
}
