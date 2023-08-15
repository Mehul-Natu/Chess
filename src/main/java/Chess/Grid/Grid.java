package Chess.Grid;

import Chess.Game.GameToGridBridgeAbstraction;
import Chess.Game.GridResponse;
import Chess.Game.Player;
import Chess.Grid.Builder.GridCellFactory;
import Chess.Grid.Builder.GridCellFactoryAPI;
import Chess.Move.MovementEncapsulator;
import Chess.Move.MovementImplementor;
import Chess.Move.MovementResponse;
import Chess.Piece.Builder.PieceBuilder;
import Chess.Piece.Builder.PieceFactory;
import Chess.Piece.Builder.PieceManagerBuilder;
import Chess.Piece.Builder.PieceManagerFactory;
import Chess.Piece.Factory;
import Chess.Piece.PieceManager;
import Chess.Piece.PieceType;
import Chess.Position;

import static Chess.Move.MovementResponse.MovementResponseType.MOVED_SUCCESSFULLY;

public class Grid implements GameToGridBridgeAbstraction {

    GridCell[][] grid;
    GridCellFactoryAPI gridCellFactory;

    MovementImplementor movementImplementor;

    public Grid() {
        this.movementImplementor = new MovementEncapsulator(this);
        this.grid = new GridCell[8][8];
        this.gridCellFactory = GridCellFactory.getInstance();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.grid[i][j] = gridCellFactory.createGrid(new Position(i,j));
            }
        }
    }

    public void setBaseBoard(){
        PieceBuilder pieceBuilder = new PieceBuilder();
        pieceBuilder.setPieceType(PieceType.BlackQueen).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackQueen));
        PieceFactory pieceFactory = PieceFactory.getInstance();
        PieceManagerBuilder pieceManagerBuilder = new PieceManagerBuilder();
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder)).setCurrentPosition(new Position(1,1));
        PieceManagerFactory pieceManagerFactory = PieceManagerFactory.getInstance();
        PieceManager blackQueen = pieceManagerFactory.createPieceManager(pieceManagerBuilder);


    }

    public void setPiece(PieceManager pieceManager, Position position) {
        grid[position.getX()][position.getY()].setCurrentPiece(pieceManager);
        pieceManager.setCurrentPosition(position);
    }


    public void printBoard(){
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        System.out.println("  ---------------------------------");


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

    public GridCell getGridCell(Position position) {
        return grid[position.getX()][position.getY()];
    }


    @Override
    public GridResponse makeMove(Position starting, Position ending, Player player) {

        MovementResponse movementResponse = movementImplementor.makeMove(starting, ending, player);

        if (MOVED_SUCCESSFULLY.equals(movementResponse.getMovementResponseType())) {
            return new GridResponse(GridResponse.StatusEnum.SUCCESSFULLY_MOVED);
        } else {
            return new GridResponse(GridResponse.StatusEnum.ERROR_MOVING, movementResponse.getMovementResponseType().getMessage());
        }
    }

    @Override
    public GridResponse checkForCheckMate(Player lastMoved) {
        return null;
    }
}
