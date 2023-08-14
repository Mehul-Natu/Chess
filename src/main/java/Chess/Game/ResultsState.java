package Chess.Game;

public class ResultsState implements StateAPI{

    CurrentState currentState;

    @Override
    public void operate(CurrentState currentState) {
        this.currentState = currentState;
    }

    @Override
    public StateAPI nextState() {
        if(currentState.getState() == "newgame"){
            return new GameStart();
        }else{
            return new GameEnd();
        }
    }
}
