package Chess.Move;

import Chess.Move.MoveGenerator.MoveGeneratorAPI;
import Chess.Move.MoveGenerator.impl.*;

public enum MoveType {
    blank(MGBlank.getInstance()),
    kill(MGKill.getInstance()),
    blank_kill(MGBlankKill.getInstance()),
    jump_blank_kill(MGJumpBlankKill.getInstance()),
    safe_blank_kill(MGSafeBlankKill.getInstance());

    private MoveGeneratorAPI moveGeneratorBasedAPI;

    MoveType(MoveGeneratorAPI moveGenerator) {
        this.moveGeneratorBasedAPI = moveGenerator;
    }

    public MoveGeneratorAPI getMoveGeneratorBasedAPI() {
        return moveGeneratorBasedAPI;
    }
}
