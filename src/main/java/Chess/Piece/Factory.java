package Chess.Piece;

import Chess.Move.MoveConstants;
import Chess.Move.MoveRule;
import Chess.Move.MoveType;
import Chess.Piece.Builder.PieceBuilder;
import Chess.Piece.Builder.PieceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {

    Map<PieceType, List<MoveRule>> map = new HashMap<>();

    public static Factory instance;
    private Factory() {
        List<MoveRule> queenMoveRuleList = new ArrayList<>();
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_ADD}));
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_SUBTRACT}));
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, 0}));
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, 0}));
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_ADD}));
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_ADD}));
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_SUBTRACT}));
        queenMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_SUBTRACT}));
        map.put(PieceType.BlackQueen, queenMoveRuleList);
        map.put(PieceType.WhiteQueen, queenMoveRuleList);

        List<MoveRule> kingMoveRuleList = new ArrayList<>();
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {0, 1}));
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {0, -1}));
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {1, 0}));
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {-1, 0}));
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {1, 1}));
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {-1, 1}));
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {1, -1}));
        kingMoveRuleList.add(new MoveRule(MoveType.safe_blank_kill, new int[] {-1, -1}));
        map.put(PieceType.BlackKing, kingMoveRuleList);
        map.put(PieceType.WhiteKing, kingMoveRuleList);

        List<MoveRule> knightMoveRuleList = new ArrayList<>();
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {2, 1}));
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {2, -1}));
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-2, 1}));
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-2, -1}));
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {1, -2}));
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {1, 2}));
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-1, -2}));
        knightMoveRuleList.add(new MoveRule(MoveType.jump_blank_kill, new int[] {-1, -2}));
        map.put(PieceType.BlackKnight, knightMoveRuleList);
        map.put(PieceType.WhiteKnight, knightMoveRuleList);

        List<MoveRule> bishopMoveRuleList = new ArrayList<>();
        bishopMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_ADD}));
        bishopMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_ADD}));
        bishopMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, MoveConstants.INFINITE_SUBTRACT}));
        bishopMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, MoveConstants.INFINITE_SUBTRACT}));
        map.put(PieceType.BlackBishop, bishopMoveRuleList);
        map.put(PieceType.WhiteBishop, bishopMoveRuleList);

        List<MoveRule> rookMoveRuleList = new ArrayList<>();
        rookMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_ADD}));
        rookMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {0, MoveConstants.INFINITE_SUBTRACT}));
        rookMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_ADD, 0}));
        rookMoveRuleList.add(new MoveRule(MoveType.blank_kill, new int[] {MoveConstants.INFINITE_SUBTRACT, 0}));
        map.put(PieceType.BlackRook, rookMoveRuleList);
        map.put(PieceType.WhiteRook, rookMoveRuleList);


        List<MoveRule> blackPawnMoveRuleList = new ArrayList<>();
        blackPawnMoveRuleList.add(new MoveRule(MoveType.blank, new int[] {0, -1}));
        blackPawnMoveRuleList.add(new MoveRule(MoveType.kill, new int[] {1, -1}));
        blackPawnMoveRuleList.add(new MoveRule(MoveType.kill, new int[] {-1, -1}));
        map.put(PieceType.BlackPawn, blackPawnMoveRuleList);

        List<MoveRule> whitePawnMoveRuleList = new ArrayList<>();
        whitePawnMoveRuleList.add(new MoveRule(MoveType.blank, new int[] {0, 1}));
        whitePawnMoveRuleList.add(new MoveRule(MoveType.kill, new int[] {1, 1}));
        whitePawnMoveRuleList.add(new MoveRule(MoveType.kill, new int[] {-1, 1}));
        map.put(PieceType.WhitePawn, whitePawnMoveRuleList);

    }
    public synchronized static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public List<MoveRule> getMoveList(PieceType pieceType){
        return map.get(pieceType);
    }

}
