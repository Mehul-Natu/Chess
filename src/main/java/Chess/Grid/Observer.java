package Chess.Grid;

import Chess.Piece.Observable;

import java.util.List;

public interface Observer {

    void update(Observable observable);

    List<Observable> getDirectMovers(boolean black);

    public List<Observable> getInDirectMovers(boolean black);

}
