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

        Player player = currentState.getLastMoveByPlayerOne()
                ? currentState.getPlayerOne() : currentState.getPlayerTwo();
        GridResponse response = currentState.getGrid().checkForCheckMate(player);

        if (GridResponse.StatusEnum.CHECK.equals(response.getStatusEnum())) {
            System.out.println(player.getName() + " You have check on you");
        } else if (GridResponse.StatusEnum.CHECKMATED.equals(response.getStatusEnum())) {
            System.out.println(player.getName() + " Loses");
            currentState.setStateAPI(currentState.getResultState());
        } else {
            if (currentState.getLastMoveByPlayerOne()) {
                currentState.setStateAPI(currentState.getPlayerTwoMoves());
            } else {
                currentState.setStateAPI(currentState.getPlayerOneMoves());
            }
        }


    }
}
