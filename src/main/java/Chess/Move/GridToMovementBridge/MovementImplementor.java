package Chess.Move.GridToMovementBridge;

import Chess.Game.CurrentStateConfiguration;
import Chess.Game.Player;
import Chess.Move.MovementResponse;
import Chess.Position;

public interface MovementImplementor {

    MovementResponse makeMove(Position starting, Position ending, Player player);

    MovementResponse checkOrCheckMate(CurrentStateConfiguration stateConfiguration);

}
