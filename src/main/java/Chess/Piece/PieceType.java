package Chess.Piece;

public enum PieceType {
    BlackKnight("\u265E"),
    BlackRook("\u265C"),
    BlackQueen("\u265B"),
    BlackKing("\u265A"),
    BlackPawn("\u265F"),
    BlackBishop("\u265D"),
    WhiteKnight("\u2658"),
    WhiteRook("\u2656"),
    WhiteQueen("\u2655"),
    WhiteKing("\u2654"),
    WhitePawn("\u2659"),
    WhiteBishop("\u2657");

    private final String pieceType;

    PieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    public String getUnicode() {
        return pieceType;
    }
}
