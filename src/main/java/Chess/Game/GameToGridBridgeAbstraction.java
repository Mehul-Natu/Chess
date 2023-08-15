package Chess.Game;

import Chess.Position;

public interface GameToGridBridgeAbstraction {


    GridResponse makeMove(Position starting, Position ending, Player player);

    GridResponse checkForCheckMate(Player lastMoved);

    public void printBoard();


}
