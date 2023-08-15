package Chess.Game;

public class GridResponse {

    public GridResponse(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }


    public GridResponse(StatusEnum statusEnum, String message) {
        this.statusEnum = statusEnum;
        this.message = message;
    }

    public static enum  StatusEnum {
        SUCCESSFULLY_MOVED,
        ERROR_MOVING,
        CHECKMATED,
        CHECK;
    }

    private final StatusEnum statusEnum;

    private String message;

}
