package Chess.Game.States;

import Chess.Game.StateAPI;
import Chess.Game.CurrentStateConfiguration;

public class ResultsState implements StateAPI {

    CurrentStateConfiguration currentState;

    public ResultsState(CurrentStateConfiguration currentState) {
        this.currentState = currentState;
    }

    @Override
    public void operate() {
        // tell who the winner is and  also show stats
        // and ask they wants to play another game
        // if yes then change the state in the state configuration to start game

        //
        // if not the go to result state
    }

}
