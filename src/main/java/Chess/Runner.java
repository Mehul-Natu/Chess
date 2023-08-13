package Chess;

import Chess.Grid.Grid;
import Chess.Move.MoveType;
import Chess.Move.PlayableMove;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Hello");
        Grid grid = new Grid();


        Set<PlayableMove> set = new HashSet<>();
        set.add(new PlayableMove(1, 0, MoveType.blank));
        set.add(new PlayableMove(1, 0, MoveType.kill));
        //System.out.println(set.contains();
    }
}
