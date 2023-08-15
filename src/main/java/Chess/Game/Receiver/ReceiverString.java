package Chess.Game.Receiver;

import Chess.Position;
import Chess.Util.Pair;

public class ReceiverString implements ReceiverAPI<String,String> {

    @Override
    public void input(String player1, String player2, Pair<String,String> outputPair) {
        outputPair.setFieldOne(player1);
        outputPair.setFieldTwo(player2);
    }
}
