package Chess.Piece.AttackBlocker.impl;

import Chess.Piece.AttackBlocker.AttackerBlockerPositionCalculatorAPI;
import Chess.Position;

import java.util.HashSet;
import java.util.Set;

public class StraightLineCalculator implements AttackerBlockerPositionCalculatorAPI {

    private static AttackerBlockerPositionCalculatorAPI instance;

    public static AttackerBlockerPositionCalculatorAPI getInstance() {
        if (instance == null) {
            instance = new StraightLineCalculator();
        }
        return instance;
    }
    private StraightLineCalculator() {
    }

    @Override
    public Set<Position> getPositions(Position attacker, Position victim) {
        Set<Position> set = new HashSet<>();

        int xattacker = attacker.getX();
        int yattacker = attacker.getY();

        int xvictim = victim.getX();
        int yvictim = victim.getY();

        int xcalc = xattacker-xvictim;
        int ycalc = yattacker-yvictim;

        if(xcalc==0){
            if(ycalc>0){
                for (int i = yattacker; i > yvictim+1 ; i--){
                    set.add(new Position(xattacker,i-1));
                }
            }else if (ycalc<0){
                for (int i = yattacker; i < yvictim-1 ; i++){
                    set.add(new Position(xattacker,i+1));
                }
            }
        } else if(ycalc==0){
            if(xcalc>0){
                for (int i = xattacker; i > xvictim+1 ; i--){
                    set.add(new Position(i-1,yattacker));
                }
            }else if (xcalc<0){
                for (int i = xattacker; i < xvictim-1 ; i++){
                    set.add(new Position(i+1,yattacker));
                }
            }
        }
        set.add(attacker);
        return set;
    }
}
