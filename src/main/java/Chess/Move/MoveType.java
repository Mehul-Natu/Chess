package Chess.Move;

import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;
import Chess.Move.MoveGenerator.impl.MGBlank;

public enum MoveType {
    blank(MGBlank),
    kill(),
    blank_kill(),
    jump_blank_kill(),
    safe_blank_kill();

    private MoveGeneratorBasedAPI moveGeneratorBasedAPI;

    MoveType(MoveGeneratorBasedAPI moveGenerator) {
        this.moveGeneratorBasedAPI = moveGenerator;
    }

}
