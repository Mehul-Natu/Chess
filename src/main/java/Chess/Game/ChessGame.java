package Chess.Game;

public class ChessGame {

    //create the player inputs such as B2,C1
    //convert B2 to array input [1][2] to [2][0]

    private static StateAPI state;

    CurrentState currentState = new CurrentState();

    public void operate(StateAPI state, CurrentState currentState){
        state.operate(currentState);
    }

    public void nextState(StateAPI state){
        this.state = state.nextState();
    }

}
