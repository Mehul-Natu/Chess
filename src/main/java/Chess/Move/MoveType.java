package Chess.Move;

import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.MoveGenerator.impl.*;

public enum MoveType {
    blank(MGBlank.getInstance()),
    kill(MGKill.getInstance()),
    blank_kill(MGBlankKill.getInstance()),
    jump_blank_kill(MGJumpBlankKill.getInstance()),
    safe_blank_kill(MGSafeBlankKill.getInstance());

    private MoveGeneratorBasedAPI moveGeneratorBasedAPI;

    MoveType(MoveGeneratorBasedAPI moveGenerator) {
        this.moveGeneratorBasedAPI = moveGenerator;
    }

    public MoveGeneratorBasedAPI getMoveGeneratorBasedAPI() {
        return moveGeneratorBasedAPI;
    }
}
