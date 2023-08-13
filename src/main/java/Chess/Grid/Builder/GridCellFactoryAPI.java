package Chess.Grid.Builder;

import Chess.Grid.GridCell;
import Chess.Position;

public interface GridCellFactoryAPI {

    GridCell createGrid(Position position);
    public GridCell createGrid(GridCellBuilder g);

}
