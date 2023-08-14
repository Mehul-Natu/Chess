package Chess.Piece;

public enum PieceType {
    BlackKnight("\u265E", true),
    BlackRook("\u265C", true),
    BlackQueen("\u265B", true),
    BlackKing("\u265A", true),
    BlackPawn("\u265F", true),
    BlackBishop("\u265D", true),
    WhiteKnight("\u2658", false),
    WhiteRook("\u2656", false),
    WhiteQueen("\u2655", false),
    WhiteKing("\u2654", false),
    WhitePawn("\u2659", false),
    WhiteBishop("\u2657", false);

    private final String pieceColorUnicode;

    private final boolean black;

    PieceType(String pieceType, boolean black) {
        this.pieceColorUnicode = pieceType;
        this.black = black;
    }

    public String getUnicode() {
        return pieceColorUnicode;
    }

    public boolean isBlack() {
        return this.black;
    }
}
