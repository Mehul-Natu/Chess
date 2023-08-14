package Chess.Game;

import Chess.Game.States.GameStateEnum;
import Chess.Grid.GameToGridAdapter;

public class CurrentStateConfiguration {

    private GameStateEnum stateEnum;
    private StateAPI stateAPI;

    private final GameToGridAdapter grid;

    private Player playerOne;

    private Player playerTwo;


    public CurrentStateConfiguration() {
        grid = new GameToGridAdapter();
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
