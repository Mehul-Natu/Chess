package Chess.Game.States;

import Chess.Game.GridResponse;
import Chess.Game.StateAPI;
import Chess.Game.CurrentStateConfiguration;
import Chess.Position;

import static Chess.Game.GridResponse.StatusEnum.ERROR_MOVING;

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

        Position startingPosition = new Position(7, 1);
        Position endingPosition = new Position(5, 2);

        GridResponse response = currentState.getGrid().makeMove(startingPosition, endingPosition, currentState.getPlayerOne());

        if (ERROR_MOVING.equals(response.getStatusEnum())) {
            System.out.println(response.getMessage());
            System.out.println("Try inputing again");
        } else {
            System.out.println("SuccessfullyMoved");
            //todo mehul do everything for killing a piece
            currentState.setStateAPI(currentState.getCheckOrCheckMate());
            currentState.setLastMoveByPlayerOne(true);
            currentState.getGrid().printBoard();
        }


    }


}
