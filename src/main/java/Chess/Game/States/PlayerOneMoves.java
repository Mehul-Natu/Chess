package Chess.Game.States;

import Chess.Game.Command.Command;
import Chess.Game.GridResponse;
import Chess.Game.Receiver.ReceiverPosition;
import Chess.Game.StateAPI;
import Chess.Game.CurrentStateConfiguration;
import Chess.Position;

import java.util.Scanner;

import static Chess.Game.GridResponse.StatusEnum.ERROR_MOVING;

public class PlayerOneMoves implements StateAPI {

    CurrentStateConfiguration currentState;

    public PlayerOneMoves(CurrentStateConfiguration currentState) {
        this.currentState = currentState;
    }

    @Override
    public void operate() {

        // take input from player one check if it is correct if not
        // then do not make any changes in state configurations
        //if correct move then move onto check or checkmate state

        Position startingPosition = null;
        Position endingPosition = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting position");
        String startingPos = scanner.nextLine();
        System.out.println("Enter ending position");
        String endingPos = scanner.nextLine();


        Command<Position, Position> input = new Command<>(new ReceiverPosition(), startingPos.strip(), endingPos.strip());
        input.execute();
        startingPosition = input.getOutputPair().getFieldOne();
        endingPosition = input.getOutputPair().getFieldTwo();

        GridResponse response = currentState.getGrid().makeMove(startingPosition, endingPosition, currentState.getPlayerOne());

        if (ERROR_MOVING.equals(response.getStatusEnum())) {
            System.out.println(response.getMessage());
            System.out.println("Try inputing again");
        } else {
            System.out.println("SuccessfullyMoved");
            //todo mehul do everything for killing a piece
            currentState.setStateAPI(currentState.getCheckOrCheckMate());
            currentState.setLastMoveByPlayerOne(true);
            currentState.getGrid().printBoard();
        }


    }


}
