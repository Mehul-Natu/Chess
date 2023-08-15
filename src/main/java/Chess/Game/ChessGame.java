package Chess.Game;

import Chess.Game.States.*;

import java.util.Scanner;

public class ChessGame implements StateAPI  {

    //create the player inputs such as B2,C1
    //convert B2 to array input [1][2] to [2][0]

    private CurrentStateConfiguration stateConfiguration;




    public ChessGame() {

        this.stateConfiguration = new CurrentStateConfiguration();
        this.stateConfiguration.setGameEnd(new GameEnd(stateConfiguration));
        this.stateConfiguration.setGameStart(new GameStart(stateConfiguration));
        this.stateConfiguration.setPlayerOneMoves(new PlayerOneMoves(stateConfiguration));
        this.stateConfiguration.setPlayerTwoMoves(new PlayerTwoMoves(stateConfiguration));
        this.stateConfiguration.setResultState(new ResultsState(stateConfiguration));
        this.stateConfiguration.setCheckOrCheckMate(new CheckOrCheckmate(stateConfiguration));

        this.stateConfiguration.setStateAPI(stateConfiguration.getGameStart());

    }

    public void operate(){
        this.stateConfiguration.getStateAPI().operate();
    }


    public void scan(){
        Scanner scanner = new Scanner(System.in);

        // Prompt the user
        System.out.print("Input tile to move: ");

        String originTile = scanner.nextLine();

        System.out.println("Input tile destination: ");

        String destinationTile = scanner.nextLine();

        scanner.close();
    }

    public void input(String originTile, String destinationTile){



        char x_axischarO = originTile.charAt(0);
        int x_axisO;

        if (x_axischarO >= 'a' && x_axischarO <= 'h') {
            x_axisO = x_axischarO - 'a';
        }

        int y_axisO = originTile.charAt(1) - 1;


        char x_axischarD = destinationTile.charAt(0);
        int x_axisD;

        if (x_axischarD >= 'a' && x_axischarD <= 'h') {
            x_axisD = x_axischarD - 'a';
        }

        int y_axisD = originTile.charAt(1) - 1;

    }
}
