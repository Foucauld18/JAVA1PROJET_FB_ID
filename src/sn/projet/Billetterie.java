package sn.projet;

public class Billetterie {
    protected Tournoi tournoi;
    protected int nbBilletVendu;
    protected int nbSpectateur;
    protected Match [] matchs;
    protected Spectateur[]spectateurs;
    protected int totalGain;

    /**Constructeur */
    public Billetterie(Tournoi tournoi){
        this.tournoi=tournoi;
        this.nbBilletVendu=0;
        this.nbSpectateur=0;
        this.totalGain=0;
        this.matchs = new Match [256];
        this.spectateurs=null;
    }
    /**Methods */

}
