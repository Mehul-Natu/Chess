package Chess.Piece;

public enum PieceType {
    BlackKnight("\u2658", true),
    BlackRook("\u2656", true),
    BlackQueen("\u2655", true),
    BlackKing("\u2654", true),
    BlackPawn("\u2659", true),
    BlackBishop("\u2657", true),
    WhiteKnight("\u265E", false),
    WhiteRook("\u265C", false),
    WhiteQueen("\u265B", false),
    WhiteKing("\u265A", false),
    WhitePawn("\u265F", false),
    WhiteBishop("\u265D", false);

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
