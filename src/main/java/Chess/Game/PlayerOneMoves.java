package Chess.Game;

public class PlayerOneMoves implements StateAPI{

    CurrentState currentState;

    @Override
    public void operate(CurrentState currentState) {
        this.currentState = currentState;
    }

    @Override
    public StateAPI nextState() {
        currentState.setState("playerone");
        return new CheckForCheckmate();
    }
}
