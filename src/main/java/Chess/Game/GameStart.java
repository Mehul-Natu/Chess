package Chess.Game;

public class GameStart implements StateAPI {

    CurrentState currentState;

    @Override
    public void operate(CurrentState currentState) {
        this.currentState = currentState;

    }

    @Override
    public StateAPI nextState() {
        currentState.setState("gamestart");
        return new PlayerOneMoves();
    }
}
