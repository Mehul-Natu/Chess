package Chess;

import Chess.Grid.Grid;
import Chess.Move.MoveConstants;
import Chess.Move.MoveGenerator.MoveGeneratorAPI;
import Chess.Move.MoveGenerator.impl.MGBlank;
import Chess.Move.MoveGenerator.impl.MGBlankKill;
import Chess.Move.MoveGenerator.impl.MGSafeBlankKill;
import Chess.Move.MoveRule;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
import Chess.Piece.Builder.PieceBuilder;
import Chess.Piece.Builder.PieceBuilderFactory;
import Chess.Piece.Builder.PieceManagerBuilder;
import Chess.Piece.Builder.PieceManagerBuilderFactory;
import Chess.Piece.Observable;
import Chess.Piece.Piece;
import Chess.Piece.PieceManager;
import Chess.Piece.PieceType;

import java.util.*;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Hello");
        Grid grid = new Grid();


        Set<PlayableMove> set = new HashSet<>();
        set.add(new PlayableMove(1, 0, MoveType.blank));
        set.add(new PlayableMove(1, 0, MoveType.kill));
        //


        //testForKnight();
        //testForQueen();
//        testForRookNQueen();
        testPieceBuilder();

    }



    public static void testForKnight() {
        try {


            MoveGeneratorAPI moveGeneratorBasedAPI = MGBlank.getInstance();
            Grid grid1 = new Grid();
            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {2, 1}));
            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {2, -1}));
            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-2, 1}));
            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-2, -1}));
            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {1, -2}));
            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {1, 2}));
            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-1, -2}));
            moveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-1, -2}));



            PieceManager pieceManager = new PieceManager(new Piece(PieceType.BlackKnight, moveRuleList), new Position(4, 4));
            grid1.setPiece(pieceManager, new Position(4, 4));



            MoveGeneratorAPI.setGrid(grid1);
            pieceManager.refreshMoves();

        } catch (Exception e) {

        }

    }

    public static void testForQueen() {
        try {


            MoveGeneratorAPI moveGeneratorBasedAPI = MGBlankKill.getInstance();
            Grid grid1 = new Grid();
            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, 0}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, 0}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_SUBTRACT}));



            PieceManager pieceManager = new PieceManager(new Piece(PieceType.BlackQueen, moveRuleList), new Position(0, 0));
            grid1.setPiece(pieceManager, new Position(0, 0));


            MoveGeneratorAPI.setGrid(grid1);
            pieceManager.refreshMoves();

        } catch (Exception e) {

        }

    }

    public static void testForBishop() {
        try {


            MoveGeneratorAPI moveGeneratorBasedAPI = MGBlankKill.getInstance();
            Grid grid1 = new Grid();
            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_SUBTRACT}));



            PieceManager pieceManager = new PieceManager(new Piece(PieceType.BlackBishop, moveRuleList), new Position(0, 0));
            grid1.setPiece(pieceManager, new Position(0, 0));


            MoveGeneratorAPI.setGrid(grid1);
            pieceManager.refreshMoves();

        } catch (Exception e) {

        }

    }

    public static void testForRook() {
        try {


            MoveGeneratorAPI moveGeneratorBasedAPI = MGBlankKill.getInstance();
            Grid grid1 = new Grid();
            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, 0}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, 0}));



            PieceManager pieceManager = new PieceManager(new Piece(PieceType.BlackRook, moveRuleList), new Position(0, 0));
            grid1.setPiece(pieceManager, new Position(0, 0));


            MoveGeneratorAPI.setGrid(grid1);
            pieceManager.refreshMoves();

        } catch (Exception e) {

        }

    }

    public static void testForKing() {
        try {


            MoveGeneratorAPI moveGeneratorBasedAPI = MGSafeBlankKill.getInstance();
            Grid grid1 = new Grid();
            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {0, 1}));
            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {0, -1}));
            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {1, 0}));
            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {-1, 0}));
            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {1, 1}));
            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {-1, 1}));
            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {1, -1}));
            moveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {-1, -1}));



            PieceManager pieceManager = new PieceManager(new Piece(PieceType.BlackKing, moveRuleList), new Position(0, 0));
            grid1.setPiece(pieceManager, new Position(0, 0));


            MoveGeneratorAPI.setGrid(grid1);
            pieceManager.refreshMoves();

        } catch (Exception e) {

        }

    }

    public static void testForPawn() {
        try {


            MoveGeneratorAPI moveGeneratorBasedAPI = MGBlankKill.getInstance();
            Grid grid1 = new Grid();
            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.blank, new int[] {0, 1}));
//            moveRuleList.add(new MoveRule(MoveType.blank, new int[] {0, 2}));
            moveRuleList.add(new MoveRule(MoveType.kill, new int[] {1, 1}));
            moveRuleList.add(new MoveRule(MoveType.kill, new int[] {-1, 1}));



            PieceManager pieceManager = new PieceManager(new Piece(PieceType.BlackPawn, moveRuleList), new Position(1, 1));
            grid1.setPiece(pieceManager, new Position(1, 1));


            MoveGeneratorAPI.setGrid(grid1);
            pieceManager.refreshMoves();

        } catch (Exception e) {

        }

    }


    public static void testForRookNQueen() {
        try {
            List<Observable> listOfPieces = new ArrayList<>();

            List<MoveRule> moveRuleQueen = new ArrayList<>();

            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_ADD}));
            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, 0}));
            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, 0}));
            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_ADD}));
            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_ADD}));
            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleQueen.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_SUBTRACT}));



            PieceManager pieceBQueen = new PieceManager(new Piece(PieceType.BlackQueen, moveRuleQueen),
                    new Position(4, 4));


            Grid grid1 = new Grid();
            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, 0}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, 0}));



            PieceManager pieceBRook = new PieceManager(new Piece(PieceType.BlackRook, moveRuleList), new Position(0, 0));


            PieceManager pieceWRook = new PieceManager(new Piece(PieceType.WhiteRook, moveRuleList), new Position(0, 4));


            listOfPieces.add(pieceBQueen);
            listOfPieces.add(pieceBRook);
            listOfPieces.add(pieceWRook);

            subscribeToAll(listOfPieces, grid1);


            grid1.setPiece(pieceBRook, new Position(0, 0));
            grid1.setPiece(pieceBQueen, new Position(4, 4));
            grid1.setPiece(pieceWRook, new Position(0, 4));

            MoveGeneratorAPI.setGrid(grid1);
            pieceBRook.refreshMoves();
            pieceBQueen.refreshMoves();

            grid1.printBoard();

        } catch (Exception e) {

        }

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


    public static void testPieceBuilder(){
        try {

            List<MoveRule> moveRuleList = new ArrayList<>();

            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, 0}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, 0}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_ADD}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_SUBTRACT}));
            moveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_SUBTRACT}));



            Grid grid1 = new Grid();
            MoveGeneratorAPI.setGrid(grid1);
            PieceManagerBuilderFactory.getInstance().createPiece(new PieceManagerBuilder().setPiece(PieceBuilderFactory.getInstance().createPiece(new PieceBuilder().setPieceType(PieceType.BlackQueen).setMoveRuleList(moveRuleList))).setCurrentPosition(new Position(0,0))).refreshMoves();

        } catch (Exception e){

        }
    }


}
