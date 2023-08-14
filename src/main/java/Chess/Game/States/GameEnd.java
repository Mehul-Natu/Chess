package Chess.Game.States;

import Chess.Game.StateAPI;
import Chess.Game.CurrentStateConfiguration;

public class GameEnd implements StateAPI {

    private CurrentStateConfiguration currentState;

    public GameEnd(CurrentStateConfiguration currentState) {
        this.currentState = currentState;
    }

    @Override
    public void operate() {
        // the game has ended
        //

    }

    public StateAPI nextState() {
        System.out.println("GAME OVER");
        return null;
    }
}
