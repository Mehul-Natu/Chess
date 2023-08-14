package Chess.Game;

public enum Player {

    Player1(false),
    Player2(true);

    private boolean black;

    Player(boolean black) {
        this.black = black;
    }

    public boolean isBlack() {
        return black;
    }
}
