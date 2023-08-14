package Chess.Game;

public class PlayerTwoMoves implements StateAPI{

    CurrentState currentState;

    @Override
    public void operate(CurrentState currentState) {
        this.currentState = currentState;
    }

    @Override
    public StateAPI nextState() {
        currentState.setState("playertwo");
        return new CheckForCheckmate();
    }
}
