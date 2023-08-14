package Chess.Game.States;

import Chess.Game.*;

public class CheckOrCheckmate implements StateAPI {

    CurrentStateConfiguration currentState;

    public CheckOrCheckmate(CurrentStateConfiguration currentState) {
        this.currentState = currentState;
    }

    @Override
    public void operate() {

        // here check for check or check mate and if check then move to next player state based
        // on the move by last player
        // now go to result state

    }
}
