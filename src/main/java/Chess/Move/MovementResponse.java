package Chess.Move;

public class MovementResponse<T> {


    T extraField;

    public MovementResponse(MovementResponseType movementResponseType) {
        this.movementResponseType = movementResponseType;
    }

    public static enum MovementResponseType {
        EMPTY_GRID_CELL("The grid cell is empty"),
        WRONG_PIECE_SELECTED("Wrong piece selected"),
        CANNOT_MOVE_THERE("Cannot move your piece there"),
        CANNOT_MOVE_WITHOUT_DEFENDING_KING("Cannot move to that position otherwise king will get check"),
        MOVED_SUCCESSFULLY("Made the move successfully"),
        NO_CHECK("no check"),
        CHECK("check"),

        CHECKMATE("checkmate");



        MovementResponseType(String message) {
            this.message = message;
        }

        private String message;

        public String getMessage() {
            return message;
        }
    }


    MovementResponseType movementResponseType;

    public MovementResponseType getMovementResponseType() {
        return movementResponseType;
    }

    public void setMovementResponseType(MovementResponseType movementResponseType) {
        this.movementResponseType = movementResponseType;
    }

    public T getExtraField() {
        return extraField;
    }

    public void setExtraField(T extraField) {
        this.extraField = extraField;
    }
}
