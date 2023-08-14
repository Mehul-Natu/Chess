package Chess.Game;

public interface StateAPI {

    void operate(CurrentState currentState);
    StateAPI nextState();


}
