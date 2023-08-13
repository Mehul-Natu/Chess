package Chess.Grid.Builder;

import Chess.Grid.GridCell;

public interface GridCellFactoryAPI {

    GridCell createGrid();
    public GridCell createGrid(GridCellBuilder g);

}
