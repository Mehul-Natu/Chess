package Chess.Game;

public class CheckForCheckmate implements StateAPI{

    CurrentState currentState;

    @Override
    public void operate(CurrentState currentState) {
        this.currentState = currentState;

//        currentState.setState("checkmate");

    }

    @Override
    public StateAPI nextState() {
        if (currentState.getState() == "playerone"){
            return new PlayerTwoMoves();
        } else if (currentState.getState() == "checkmate") {
            return new ResultsState();
        } else{
            return new PlayerOneMoves();
        }

    }
}
