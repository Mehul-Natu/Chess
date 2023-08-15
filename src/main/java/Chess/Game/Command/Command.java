package Chess.Game.Command;

import Chess.Game.Receiver.ReceiverAPI;
import Chess.Util.Pair;

public class Command<X,Y> implements CommandAPI {

    Pair<X,Y> outputPair;
    ReceiverAPI receiver;
    String originTile;
    String destinationTile;

    public Command(ReceiverAPI<X,Y> receiver, String originTile, String destinationTile) {
        this.receiver = receiver;
        this.originTile = originTile;
        this.destinationTile = destinationTile;
        this.outputPair = new Pair<X,Y>();
    }

    @Override
    public void execute() {
        receiver.input(this.originTile, this.destinationTile, outputPair);
    }

    public Pair<X, Y> getOutputPair() {
        return outputPair;
    }
}
