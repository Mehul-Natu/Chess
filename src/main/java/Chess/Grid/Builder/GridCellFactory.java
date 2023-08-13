package Chess.Grid.Builder;

import Chess.Grid.GridCell;

public class GridCellFactory implements GridCellFactoryAPI {


    @Override
    public GridCell createGrid() {
        return new GridCell();
    }

    @Override
    public GridCell createGrid(Chess.Grid.Builder.GridCellBuilder g) {
        return g.build();
    }
}
