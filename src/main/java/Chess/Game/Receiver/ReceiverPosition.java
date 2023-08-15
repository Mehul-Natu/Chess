package Chess.Game.Receiver;

import Chess.Position;
import Chess.Util.Pair;

public class ReceiverPosition implements ReceiverAPI<Position,Position> {

    @Override
    public void input(String originTile, String destinationTile, Pair<Position,Position> outputPair) {
        char y_axischarO = originTile.charAt(0);
        int y_axisO = 0;

        if (y_axischarO >= 'a' && y_axischarO <= 'h') {
            y_axisO = y_axischarO - 'a';
        }

        int x_axisO = originTile.charAt(1) - 1;


        char y_axischarD = destinationTile.charAt(0);
        int y_axisD = 0;

        if (y_axischarD >= 'a' && y_axischarD <= 'h') {
            y_axisD = y_axischarD - 'a';
        }

        int x_axisD = originTile.charAt(1) - 1;

        outputPair.setFieldOne(new Position(x_axisO,y_axisO));
        outputPair.setFieldTwo(new Position(x_axisD,y_axisD));
    }
}
