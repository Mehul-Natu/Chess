package Chess.Grid;

import Chess.Grid.Builder.GridCellFactoryAPI;
import Chess.Piece.PieceManager;
import Chess.Position;

public class Grid {

    GridCell[][] grid;

    GridCellFactoryAPI gridCellFactory;

    public Grid() {
        this.grid = new GridCell[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.grid[i][j] = gridCellFactory.createGrid(new Position(i,j));
            }
        }

        System.out.println(grid[0][0].currentPiece);
    }

    public void setPiece(PieceManager pieceManager, Position position) {

    }


    public void printBoard(){

    }

}
