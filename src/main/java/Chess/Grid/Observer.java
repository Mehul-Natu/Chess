package Chess.Grid;

import Chess.Piece.Observable;

import java.util.List;

public interface Observer {

    public void update(Observable observable);

    public List<Observable> getObservers(boolean black);

}
