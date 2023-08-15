package Chess.Game;

import Chess.Position;

public interface GameToGridBridgeAbstraction {


    GridResponse makeMove(Position starting, Position ending, Player player);

    GridResponse checkForCheckMate(CurrentStateConfiguration stateConfiguration);

    public void printBoard();


}
