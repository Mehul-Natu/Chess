package Chess.Piece;

import Chess.Grid.Observer;
import Chess.Move.MoveRule;
import Chess.Move.PlayableMove;
import Chess.Position;

import java.util.Set;

public class PieceManager implements Observable {


    Piece piece;
    Set<PlayableMove> currentPlayableMoves;
    Set<Observer> gridObservers;

    Position currentPosition;




    @Override
    public void subscribe(Observer observer) {
        gridObservers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        gridObservers.remove(observer);
    }

    @Override
    public void notifyObserver() {

    }

    @Override
    public boolean containsPlayableMove(Position position) {
        return currentPlayableMoves.contains(position);
    }

    public void refreshCurrentPlayableMoves() {
        for (MoveRule rule : piece.getMoveRuleList()) {
            switch (rule.getMoveType()) {
                case kill -> {
                }
                case blank -> {

                }
                case
            }
        }
    }
}
