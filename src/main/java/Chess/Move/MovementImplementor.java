package Chess.Move;

import Chess.Game.Player;
import Chess.Position;

public interface MovementImplementor {

    MovementResponse makeMove(Position starting, Position ending, Player player);

}
