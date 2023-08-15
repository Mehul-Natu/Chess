package Chess.Game;

public class Player {


    private final boolean black;

    private final String name;

    int moveCount = 0;

    GameResult gameResult;



    public Player(boolean black, String name) {
        this.black = black;
        this.name = name;
    }

    public boolean isBlack() {
        return black;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public String getName() {
        return name;
    }
}
