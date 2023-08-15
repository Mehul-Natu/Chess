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
        CHECK,

        GAME_STILL_ON;
    }

    private final StatusEnum statusEnum;

    private String message;

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public String getMessage() {
        return message;
    }
}
