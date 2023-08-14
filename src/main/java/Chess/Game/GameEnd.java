package Chess.Game;

public class GameEnd implements StateAPI{

    CurrentState currentState;

    @Override
    public void operate(CurrentState currentState) {
        this.currentState = currentState;
    }

    @Override
    public StateAPI nextState() {
        System.out.println("GAME OVER");
        return null;
    }
}
