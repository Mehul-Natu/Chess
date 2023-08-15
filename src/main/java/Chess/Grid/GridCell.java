package Chess.Grid;

import Chess.Move.IndirectMove;
import Chess.Piece.AttackBlocker.AttackBlocker;
import Chess.Piece.Observable;
import Chess.Piece.PieceManager;
import Chess.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Chess.Piece.PieceType.BlackKing;
import static Chess.Piece.PieceType.WhiteKing;

public class GridCell implements Observer {

    private final Position position;

    private static Position whiteKingPos;

    private static Position blackKingPos;

    PieceManager currentPiece;

    Set<Observable> setOfDirectMovers;

    Set<Observable> setOfInDirectMovers;

    public GridCell(Position position) {
        this.position = position;
        this.setOfInDirectMovers = new HashSet<>();
        this.setOfDirectMovers = new HashSet<>();
    }

    @Override
    public void update(Observable observable) {
        //if (observable)

        if ((observable).getPosition().equals(this.position)) {
            return;
        }

        boolean playablePublisher = observable.containsPlayableMove(position);
        boolean indirectPublisher = observable.containsIndirectMove(position);

        if (!playablePublisher && !indirectPublisher) {
            //observable.unsubscribe(this);
            setOfDirectMovers.remove(observable);
            setOfInDirectMovers.remove(observable);
            return;
        }

        if (playablePublisher) {
            setOfDirectMovers.add(observable);
            setOfInDirectMovers.remove(observable);
        } else {
            setOfInDirectMovers.add(observable);
            setOfDirectMovers.remove(observable);
        }

        // add checks for blank moves

        if (currentPiece != null && this.currentPiece.getPiece().getPieceType().isBlack()
                != observable.getPiece().getPieceType().isBlack()) {

            PieceManager attacker = (PieceManager) observable;

            if (indirectPublisher) {
                IndirectMove indirectMove = observable.getIndirectMove(position);
                PieceManager saviour = indirectMove.getSaviour();
                if (saviour.isBlack() == this.currentPiece.isBlack()) {
                    saviour.addAttackBlockerDetails(this.currentPiece,
                            new AttackBlocker(attacker, this.currentPiece));
                }
            } else {
                //Here we wont get a check from pawn piece front move because it wont come as playable move
                switch (this.currentPiece.getPiece().getPieceType()) {
                    case BlackKing:
                        if (!observable.getPiece().getPieceType().isBlack()) {
                            // got check here
                        }
                        break;
                    case WhiteKing:
                        if (observable.getPiece().getPieceType().isBlack()) {
                            // gets checks
                        }
                        break;
                    default:
                        System.out.println(this.currentPiece.getPiece()
                                .getPieceType().getUnicode() + " is under attack by " + attacker.getPiece()
                                .getPieceType().getUnicode());

                }
            }
        }


    }

    @Override
    public List<Observable> getDirectMovers(boolean black) {
        List<Observable> listOfDirectMovers = new ArrayList<>();
        for (Observable observable : this.setOfDirectMovers) {
            if (observable.getPiece().getPieceType().isBlack() == black) {
                listOfDirectMovers.add(observable);
            }
        }
        return listOfDirectMovers;
    }

    @Override
    public List<Observable> getInDirectMovers(boolean black) {
        List<Observable> listOfIndirectMovers = new ArrayList<>();
        for (Observable observable : this.setOfInDirectMovers) {
            if (observable.getPiece().getPieceType().isBlack() == black) {
                listOfIndirectMovers.add(observable);
            }
        }
        return listOfIndirectMovers;
    }

    public void setCurrentPiece(PieceManager currentPiece) {
        if (this.currentPiece != null) {

            if (WhiteKing.equals(currentPiece.getPiece().getPieceType())) {
                whiteKingPos = this.position;
            } else if (BlackKing.equals(currentPiece.getPiece().getPieceType())) {
                blackKingPos = this.position;
            }

            runDetailStatsForCurrentPiece();
        } else {
            removeAttackBlockers();
        }
        this.currentPiece = currentPiece;
    }


    private void runDetailStatsForCurrentPiece() {
        for (Observable observable : setOfDirectMovers) {

            PieceManager attacker = (PieceManager) observable;

            if (this.currentPiece.getPiece().getPieceType().isBlack()
                    != attacker.getPiece().getPieceType().isBlack()) {
                System.out.println(this.currentPiece.getPiece()
                        .getPieceType().getUnicode() + " is under attack by " + attacker.getPiece()
                        .getPieceType().getUnicode());
            }
        }

        for (Observable observable : setOfInDirectMovers) {

            PieceManager attacker = (PieceManager) observable;
            IndirectMove indirectMove = observable.getIndirectMove(position);
            PieceManager saviour = indirectMove.getSaviour();
            if (saviour.isBlack() == this.currentPiece.isBlack()) {
                saviour.addAttackBlockerDetails(this.currentPiece,
                        new AttackBlocker(attacker, this.currentPiece));
            }
        }
    }

    private void removeAttackBlockers() {
        for (Observable observable : setOfInDirectMovers) {
            PieceManager pieceManager = (PieceManager) observable;
            pieceManager.removeAttackBlockerDetails(this.currentPiece);
        }
    }

    public void setListOfObserver(Set<Observable> listOfPublisher) {
        this.setOfDirectMovers = listOfPublisher;
    }

    public PieceManager getCurrentPiece() {
        return currentPiece;
    }

    public boolean hasPiece() {
        return this.currentPiece != null;
    }

    public void addDirectMover(Observable directMover) {
        this.setOfDirectMovers.add(directMover);
    }

    public void addInDirectMover(Observable inDirectMover) {
        this.setOfInDirectMovers.add(inDirectMover);
    }

    public static Position getWhiteKingPos() {
        return whiteKingPos;
    }

    public static Position getBlackKingPos() {
        return blackKingPos;
    }
}
