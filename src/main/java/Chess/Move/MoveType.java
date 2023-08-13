package Chess.Move;

import Chess.Move.MoveGenerator.MoveGeneratorBasedAPI;

public enum MoveType {
    blank(),
    kill(),
    blank_kill(),
    jump_blank_kill(),
    safe_blank_kill();

    private MoveGeneratorBasedAPI moveGeneratorBasedAPI;

    MoveType(MoveGeneratorBasedAPI moveGenerator) {
        this.moveGeneratorBasedAPI = moveGenerator;
    }

}
