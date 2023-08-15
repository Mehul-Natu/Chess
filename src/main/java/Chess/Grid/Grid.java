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
import Chess.Piece.Observable;
import Chess.Piece.PieceManager;
import Chess.Piece.PieceType;
import Chess.Position;

import java.util.ArrayList;
import java.util.List;

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

        setBaseBoard();
    }

    public void setBaseBoard(){
        PieceBuilder pieceBuilder = new PieceBuilder();
        pieceBuilder.setPieceType(PieceType.BlackQueen).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackQueen));
        PieceFactory pieceFactory = PieceFactory.getInstance();
        PieceManagerBuilder pieceManagerBuilder = new PieceManagerBuilder();
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));

        PieceManagerFactory pieceManagerFactory = PieceManagerFactory.getInstance();


        //Setting Black Pieces
        PieceManager blackQueen = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.BlackKing).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackKing));
        PieceManager blackKing = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.BlackRook).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackRook));
        PieceManager blackRook1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.BlackRook).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackRook));
        PieceManager blackRook2 = blackRook1.clone();

        pieceBuilder.setPieceType(PieceType.BlackKnight).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackKnight));
        PieceManager blackKnight1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.BlackKnight).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackKnight));
        PieceManager blackKnight2 = blackKnight1.clone();

        pieceBuilder.setPieceType(PieceType.BlackBishop).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackBishop));
        PieceManager blackBishop1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.BlackBishop).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackBishop));
        PieceManager blackBishop2 = blackBishop1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn2 = blackPawn1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn3 = blackPawn1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn4 = blackPawn1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn5 = blackPawn1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn6 = blackPawn1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn7 = blackPawn1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        PieceManager blackPawn8 = blackPawn1.clone();


        //Setting White Pieces
        pieceBuilder.setPieceType(PieceType.WhiteQueen).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteQueen));
        PieceManager whiteQueen = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhiteKing).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteKing));
        PieceManager whiteKing = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhiteRook).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteRook));
        PieceManager whiteRook1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhiteRook).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteRook));
        PieceManager whiteRook2 = whiteRook1.clone();

        pieceBuilder.setPieceType(PieceType.WhiteKnight).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteKnight));
        PieceManager whiteKnight1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhiteKnight).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteKnight));
        PieceManager whiteKnight2 = whiteKnight1.clone();

        pieceBuilder.setPieceType(PieceType.WhiteBishop).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteBishop));
        PieceManager whiteBishop1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhiteBishop).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteBishop));
        PieceManager whiteBishop2 = whiteBishop1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn2 = whitePawn1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn3 = whitePawn1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn4 = whitePawn1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn5 = whitePawn1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn6 = whitePawn1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn7 = whitePawn1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        PieceManager whitePawn8 = whitePawn1.clone();



        List<Observable> pieceList = new ArrayList<>();
        pieceList.add(blackQueen);
        pieceList.add(blackKing);
        pieceList.add(blackRook1);
        pieceList.add(blackRook2);
        pieceList.add(blackKnight1);
        pieceList.add(blackKnight2);
        pieceList.add(blackBishop1);
        pieceList.add(blackBishop2);
        pieceList.add(blackPawn1);
        pieceList.add(blackPawn2);
        pieceList.add(blackPawn3);
        pieceList.add(blackPawn4);
        pieceList.add(blackPawn5);
        pieceList.add(blackPawn6);
        pieceList.add(blackPawn7);
        pieceList.add(blackPawn8);

        pieceList.add(whiteQueen);
        pieceList.add(whiteKing);
        pieceList.add(whiteRook1);
        pieceList.add(whiteRook2);
        pieceList.add(whiteKnight1);
        pieceList.add(whiteKnight2);
        pieceList.add(whiteBishop1);
        pieceList.add(whiteBishop2);
        pieceList.add(whitePawn1);
        pieceList.add(whitePawn2);
        pieceList.add(whitePawn3);
        pieceList.add(whitePawn4);
        pieceList.add(whitePawn5);
        pieceList.add(whitePawn6);
        pieceList.add(whitePawn7);
        pieceList.add(whitePawn8);

        subscribeToAll(pieceList,this);


        setPiece(blackRook1 , new Position(0,0));
        setPiece(blackKnight1 , new Position(1,0));
        setPiece(blackBishop1 , new Position(2,0));
        setPiece(blackQueen , new Position(3,0));
        setPiece(blackKing , new Position(4,0));
        setPiece(blackBishop2 , new Position(5,0));
        setPiece(blackKnight2 , new Position(6,0));
        setPiece(blackRook2 , new Position(7,0));
        setPiece(blackPawn1 , new Position(0,1));
        setPiece(blackPawn2 , new Position(1,1));
        setPiece(blackPawn3 , new Position(2,1));
        setPiece(blackPawn4 , new Position(3,1));
        setPiece(blackPawn5 , new Position(4,1));
        setPiece(blackPawn6 , new Position(5,1));
        setPiece(blackPawn7 , new Position(6,1));
        setPiece(blackPawn8 , new Position(7,1));

        setPiece(whiteRook1 , new Position(0,7));
        setPiece(whiteKnight1 , new Position(1,7));
        setPiece(whiteBishop1 , new Position(2,7));
        setPiece(whiteQueen , new Position(3,7));
        setPiece(whiteKing , new Position(4,7));
        setPiece(whiteBishop2 , new Position(5,7));
        setPiece(whiteKnight2 , new Position(6,7));
        setPiece(whiteRook2 , new Position(7,7));
        setPiece(whitePawn1 , new Position(0,6));
        setPiece(whitePawn2 , new Position(1,6));
        setPiece(whitePawn3 , new Position(2,6));
        setPiece(whitePawn4 , new Position(3,6));
        setPiece(whitePawn5 , new Position(4,6));
        setPiece(whitePawn6 , new Position(5,6));
        setPiece(whitePawn7 , new Position(6,6));
        setPiece(whitePawn8 , new Position(7,6));

    }

    public static void subscribeToAll(List<Observable> list, Grid grid) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (Observable observable : list) {
                    observable.subscribe(grid.getGridCell(i, j));
                }
            }
        }

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
