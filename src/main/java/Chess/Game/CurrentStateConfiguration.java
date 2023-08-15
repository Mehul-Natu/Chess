package Chess.Game;

import Chess.Game.States.GameStateEnum;
import Chess.Grid.Grid;

public class CurrentStateConfiguration {

    private GameStateEnum stateEnum;
    private StateAPI stateAPI;
    private GameToGridBridgeAbstraction grid;
    private Player playerOne;
    private Player playerTwo;
    private StateAPI gameEnd;
    private StateAPI gameStart;
    private StateAPI playerOneMoves;
    private StateAPI playerTwoMoves;
    private StateAPI resultState;
    private StateAPI checkOrCheckMate;

    private Boolean lastMoveByPlayerOne = null;


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

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public StateAPI getGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(StateAPI gameEnd) {
        this.gameEnd = gameEnd;
    }

    public StateAPI getGameStart() {
        return gameStart;
    }

    public void setGameStart(StateAPI gameStart) {
        this.gameStart = gameStart;
    }

    public StateAPI getPlayerOneMoves() {
        return playerOneMoves;
    }

    public void setPlayerOneMoves(StateAPI playerOneMoves) {
        this.playerOneMoves = playerOneMoves;
    }

    public StateAPI getPlayerTwoMoves() {
        return playerTwoMoves;
    }

    public void setPlayerTwoMoves(StateAPI playerTwoMoves) {
        this.playerTwoMoves = playerTwoMoves;
    }

    public StateAPI getResultState() {
        return resultState;
    }

    public void setResultState(StateAPI resultState) {
        this.resultState = resultState;
    }

    public StateAPI getCheckOrCheckMate() {
        return checkOrCheckMate;
    }

    public void setCheckOrCheckMate(StateAPI checkOrCheckMate) {
        this.checkOrCheckMate = checkOrCheckMate;
    }

    public GameToGridBridgeAbstraction getGrid() {
        return this.grid;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public GameStateEnum getStateEnum() {
        return stateEnum;
    }

    public Boolean getLastMoveByPlayerOne() {
        return lastMoveByPlayerOne;
    }

    public void setLastMoveByPlayerOne(Boolean lastMoveByPlayerOne) {
        this.lastMoveByPlayerOne = lastMoveByPlayerOne;
    }
}
