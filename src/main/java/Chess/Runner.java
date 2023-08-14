package Chess;

import Chess.Grid.Grid;
import Chess.Move.MoveConstants;
import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.MoveGenerator.impl.MGBlank;
import Chess.Move.MoveGenerator.impl.MGBlankKill;
import Chess.Move.MoveRule;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;
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


        //testForBishop();
        testForQueen();

    }



    public static void testForBishop() {
        try {


            MoveGeneratorBasedAPI moveGeneratorBasedAPI = MGBlank.getInstance();
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



            MoveGeneratorBasedAPI.setGrid(grid1);
            pieceManager.refreshCurrentPlayableMoves();

        } catch (Exception e) {

        }

    }

    public static void testForQueen() {
        try {


            MoveGeneratorBasedAPI moveGeneratorBasedAPI = MGBlankKill.getInstance();
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

            MoveGeneratorBasedAPI.setGrid(grid1);
            pieceManager.refreshCurrentPlayableMoves();

        } catch (Exception e) {

        }

    }

}
