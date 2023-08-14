package Chess.Piece.AttackBlocker;

import Chess.Position;

import java.util.Set;

public interface AttackerBlockerPositionCalculatorAPI {


    Set<Position> getPositions(Position attacker, Position victim);

}
