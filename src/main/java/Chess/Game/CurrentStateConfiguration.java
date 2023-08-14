package Chess.Game;

import Chess.Game.States.GameStateEnum;
import Chess.Grid.Grid;

public class CurrentStateConfiguration {

    private GameStateEnum stateEnum;
    private StateAPI stateAPI;

    private final Grid grid;

    private Player playerOne;

    private Player playerTwo;


    public CurrentStateConfiguration() {
        grid = new Grid();
    }

    public void setStateEnum(GameStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }

    public StateAPI getStateAPI() {
        return stateAPI;
    }

    public void setStateAPI(StateAPI stateAPI) {
        this.stateAPI = stateAPI;
    }
}
