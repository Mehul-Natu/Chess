package Chess.Game.States;

import Chess.Game.CurrentStateConfiguration;
import Chess.Game.StateAPI;

public class GameStart implements StateAPI {

    CurrentStateConfiguration currentState;

    public GameStart(CurrentStateConfiguration currentState) {
        this.currentState = currentState;
    }

    @Override
    public void operate() {
        // here take player names and initalize the grid for starting and
        //change the state to firstplayer move

    }

}
