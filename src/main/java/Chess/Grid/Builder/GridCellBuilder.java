package Chess.Grid.Builder;

import Chess.Grid.Observer;
import Chess.Grid.GridCell;
import Chess.Piece.*;
import Chess.Position;


import java.util.List;


public class GridCellBuilder implements GridCellBuilderAPI {

    GridCell gridCell;


    @Override
    public GridCellBuilder setPosition(Position position) {
        this.gridCell = new GridCell(position);
        return this;
    }

    @Override
    public GridCellBuilder setCurrentPiece(Piece currentPiece) {
        this.gridCell.setCurrentPiece(currentPiece);
        return this;
    }

    @Override
    public GridCellBuilder setListOfObservable(List<Observer> listOfObservable) {
        this.gridCell.setListOfObserver(listOfObservable);
        return this;
    }

    @Override
    public GridCell build() {
        return gridCell;
    }


}
