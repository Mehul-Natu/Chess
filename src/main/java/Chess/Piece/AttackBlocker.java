package Chess.Piece;

import Chess.Piece.PieceManager;

public class AttackBlocker {

    PieceManager attackedBy;
    PieceManager saving;

    public AttackBlocker(PieceManager attackedBy, PieceManager saving) {
        this.attackedBy = attackedBy;
        this.saving = saving;
    }

    public PieceManager getAttackedBy() {
        return attackedBy;
    }

    public void setAttackedBy(PieceManager attackedBy) {
        this.attackedBy = attackedBy;
    }

    public PieceManager getSaving() {
        return saving;
    }

    public void setSaving(PieceManager saving) {
        this.saving = saving;
    }
}
