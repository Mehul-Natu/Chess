package Chess.Grid;

import Chess.Game.CurrentStateConfiguration;
import Chess.Game.GameToGridBridgeAbstraction;
import Chess.Game.GridResponse;
import Chess.Game.Player;
import Chess.Grid.Builder.GridCellFactory;
import Chess.Grid.Builder.GridCellFactoryAPI;
import Chess.Move.MoveGenerator.MoveGeneratorAPI;
import Chess.Move.GridToMovementBridge.MovementEncapsulator;
import Chess.Move.GridToMovementBridge.MovementImplementor;
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

import static Chess.Move.MovementResponse.MovementResponseType.*;

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
        MoveGeneratorAPI.setGrid(this);
        setBaseBoard();
        printBoard();
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
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager blackKing = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.BlackRook).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackRook));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager blackRook1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager blackRook2 = blackRook1.clone();

        pieceBuilder.setPieceType(PieceType.BlackKnight).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackKnight));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager blackKnight1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager blackKnight2 = blackKnight1.clone();

        pieceBuilder.setPieceType(PieceType.BlackBishop).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackBishop));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager blackBishop1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager blackBishop2 = blackBishop1.clone();

        pieceBuilder.setPieceType(PieceType.BlackPawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.BlackPawn));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager blackPawn1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager blackPawn2 = blackPawn1.clone();

        PieceManager blackPawn3 = blackPawn1.clone();

        PieceManager blackPawn4 = blackPawn1.clone();

        PieceManager blackPawn5 = blackPawn1.clone();

        PieceManager blackPawn6 = blackPawn1.clone();

        PieceManager blackPawn7 = blackPawn1.clone();

        PieceManager blackPawn8 = blackPawn1.clone();


        //Setting White Pieces
        pieceBuilder.setPieceType(PieceType.WhiteQueen).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteQueen));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager whiteQueen = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhiteKing).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteKing));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager whiteKing = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        pieceBuilder.setPieceType(PieceType.WhiteRook).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteRook));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager whiteRook1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager whiteRook2 = whiteRook1.clone();

        pieceBuilder.setPieceType(PieceType.WhiteKnight).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteKnight));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager whiteKnight1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager whiteKnight2 = whiteKnight1.clone();

        pieceBuilder.setPieceType(PieceType.WhiteBishop).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhiteBishop));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager whiteBishop1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager whiteBishop2 = whiteBishop1.clone();

        pieceBuilder.setPieceType(PieceType.WhitePawn).setMoveRuleList(Factory.getInstance().getMoveList(PieceType.WhitePawn));
        pieceManagerBuilder.reset().setPiece(pieceFactory.createPiece(pieceBuilder));
        PieceManager whitePawn1 = pieceManagerFactory.createPieceManager(pieceManagerBuilder);

        PieceManager whitePawn2 = whitePawn1.clone();

        PieceManager whitePawn3 = whitePawn1.clone();

        PieceManager whitePawn4 = whitePawn1.clone();

        PieceManager whitePawn5 = whitePawn1.clone();

        PieceManager whitePawn6 = whitePawn1.clone();

        PieceManager whitePawn7 = whitePawn1.clone();

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



        setPiece(blackPawn1 , new Position(1,0));
        setPiece(blackPawn2 , new Position(1,1));
        setPiece(blackPawn3 , new Position(1,2));
        setPiece(blackPawn4 , new Position(1,3));
        setPiece(blackPawn5 , new Position(1,4));
        setPiece(blackPawn6 , new Position(1,5));
        setPiece(blackPawn7 , new Position(1,6));
        setPiece(blackPawn8 , new Position(1,7));
        setPiece(blackRook1 , new Position(0,0));
        setPiece(blackKnight1 , new Position(0,1));
        setPiece(blackBishop1 , new Position(0,2));
        setPiece(blackQueen , new Position(0,3));
        setPiece(blackKing , new Position(0,4));
        setPiece(blackBishop2 , new Position(0,5));
        setPiece(blackKnight2 , new Position(0,6));
        setPiece(blackRook2 , new Position(0,7));


        setPiece(whitePawn1 , new Position(6,0));
        setPiece(whitePawn2 , new Position(6,1));
        setPiece(whitePawn3 , new Position(6,2));
        setPiece(whitePawn4 , new Position(6,3));
        setPiece(whitePawn5 , new Position(6,4));
        setPiece(whitePawn6 , new Position(6,5));
        setPiece(whitePawn7 , new Position(6,6));
        setPiece(whitePawn8 , new Position(6,7));
        setPiece(whiteRook1 , new Position(7,0));
        setPiece(whiteKnight1 , new Position(7,1));
        setPiece(whiteBishop1 , new Position(7,2));
        setPiece(whiteQueen , new Position(7,3));
        setPiece(whiteKing , new Position(7,4));
        setPiece(whiteBishop2 , new Position(7,5));
        setPiece(whiteKnight2 , new Position(7,6));
        setPiece(whiteRook2 , new Position(7,7));

        pieceList.forEach(p -> ((PieceManager) p).refreshMoves());
        System.out.println("hello");

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


    public void printBoard() {
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        System.out.println("  ---------------------------------");


        int count = 1;
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
            count++;
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
    public GridResponse checkForCheckMate(CurrentStateConfiguration stateConfiguration) {

        MovementResponse response = movementImplementor.checkOrCheckMate(stateConfiguration);

        if (CHECK.equals(response.getMovementResponseType())) {
            Player player = (Player) response.getExtraField();
            return new GridResponse(GridResponse.StatusEnum.CHECK);
        } else if (CHECKMATE.equals(response.getMovementResponseType())) {
            return new GridResponse(GridResponse.StatusEnum.CHECKMATED);
        } else {
            return new GridResponse(GridResponse.StatusEnum.GAME_STILL_ON);
        }

    }
}
