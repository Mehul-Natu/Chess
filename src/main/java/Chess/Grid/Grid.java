package Chess.Grid;

import Chess.Grid.Builder.GridCellFactory;
import Chess.Grid.Builder.GridCellFactoryAPI;
import Chess.Piece.Piece;
import Chess.Piece.PieceManager;
import Chess.Piece.PieceType;
import Chess.Position;

public class Grid {

    GridCell[][] grid;

    GridCellFactoryAPI gridCellFactory;

    public Grid() {
        this.grid = new GridCell[8][8];
        this.gridCellFactory = new GridCellFactory();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.grid[i][j] = gridCellFactory.createGrid(new Position(i,j));
            }
        }

        System.out.println(grid[0][0].currentPiece);
    }

    public void setPiece(PieceManager pieceManager, Position position) {
        grid[position.getX()][position.getY()].setCurrentPiece(pieceManager);
    }


    public void printBoard(){
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        System.out.println("  ---------------------------------");


        PieceType pieceType = PieceType.BlackKnight;
        Piece king1 = new Piece(pieceType,null);
        PieceManager king = new PieceManager(king1, new Position(1, 0));

        grid[1][1].setCurrentPiece(king);

        int count = 8;
        for (int i = 0; i < 8; i++) {
            System.out.print(count + " ");
            System.out.print("| ");
            for (int j = 0; j < 8; j++) {
                if (grid[i][j].getCurrentPiece() == null) {
                    System.out.print("  | ");
                } else {
                    System.out.print(grid[i][j].getCurrentPiece().getPiece().getPieceType().getUnicode() + " | ");
                }
            }
            System.out.print(count);
            count--;
            System.out.println();
            System.out.println("  ---------------------------------");
        }
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        System.out.println();

    }

    public GridCell getGridCell(int x, int y) {
        return grid[x][y];
    }
}
