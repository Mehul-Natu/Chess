package Chess.Game.States;

import Chess.Game.StateAPI;
import Chess.Game.CurrentStateConfiguration;

public class PlayerOneMoves implements StateAPI {

    CurrentStateConfiguration currentState;

    public PlayerOneMoves(CurrentStateConfiguration currentState) {
        this.currentState = currentState;
    }

    @Override
    public void operate() {

        // take input from player one check if it is correct if not
        // then do not make any changes in state configurations
        //if correct move then move onto check or checkmate state
    }


}
