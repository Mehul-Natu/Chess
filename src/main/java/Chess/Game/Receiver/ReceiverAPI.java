package Chess.Game.Receiver;

import Chess.Util.Pair;

public interface ReceiverAPI<X,Y> {
    void input(String originTile, String destinationTile, Pair<X,Y> outputPair);

}
