package Chess.Grid.Builder;

import Chess.Grid.GridCell;
import Chess.Position;

public class GridCellFactory implements GridCellFactoryAPI {

    GridCellBuilder gridCellBuilder;

    @Override
    public GridCell createGrid(Position position) {
        gridCellBuilder.setPosition(position);
        return gridCellBuilder.build();
    }

    @Override
    public GridCell createGrid(Chess.Grid.Builder.GridCellBuilder g) {
        return g.build();
    }
}
