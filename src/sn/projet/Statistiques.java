package sn.projet;

public class Statistiques {
   
    protected int nbSetGagne;
    protected int nbSetJoue;
    protected int nbJeuJoue;
    protected int nbJeuGagne;
    protected int nbTotalPointRemporte;
    protected int nbAce;
    protected int nbPremierService;
    protected int nbSecondService;
    protected int nbDoubleFautes;
    protected int nbBalleDeBreakRemporte;
    protected int nbBalleDeBreak;

    /*constructor*/
    public  Statistiques(){
        this.nbSetGagne=0;
        this.nbSetJoue=0;
        this.nbJeuJoue=0;
        this.nbJeuGagne=0;
        this.nbTotalPointRemporte=0;
        this.nbAce=0;
        this.nbPremierService=0;
        this.nbSecondService=0;
        this.nbDoubleFautes=0;
        this.nbBalleDeBreakRemporte=0;
        this.nbBalleDeBreak=0;
    }
    ;

    /*Methods*/
 
    public int getNbSetGagne() {
        return this.nbSetGagne;
    }

    public void setNbSetGagne(int nbSetGagne) {
        this.nbSetGagne = nbSetGagne;
    }

    public int getNbSetJoue() {
        return this.nbSetJoue;
    }

    public void setNbSetJoue(int nbSetJoue) {
        this.nbSetJoue = nbSetJoue;
    }

    public int getNbJeuJoue() {
        return this.nbJeuJoue;
    }

    public void setNbJeuJoue(int nbJeuJoue) {
        this.nbJeuJoue = nbJeuJoue;
    }

    public int getNbJeuGagne() {
        return this.nbJeuGagne;
    }

    public void setNbJeuGagne(int nbJeuGagne) {
        this.nbJeuGagne = nbJeuGagne;
    }

    public int getNbTotalPointRemporte() {
        return this.nbTotalPointRemporte;
    }

    public void setNbTotalPointRemporte(int nbTotalPointRemporte) {
        this.nbTotalPointRemporte = nbTotalPointRemporte;
    }

    public int getNbAce() {
        return this.nbAce;
    }

    public void setNbAce(int nbAce) {
        this.nbAce = nbAce;
    }

    public int getNbPremierService() {
        return this.nbPremierService;
    }

    public void setNbPremierService(int nbPremierService) {
        this.nbPremierService = nbPremierService;
    }

    public int getNbSecondService() {
        return this.nbSecondService;
    }

    public void setNbSecondService(int nbSecondService) {
        this.nbSecondService = nbSecondService;
    }

    public int getNbDoubleFautes() {
        return this.nbDoubleFautes;
    }

    public void setNbDoubleFautes(int nbDoubleFautes) {
        this.nbDoubleFautes = nbDoubleFautes;
    }

    public int getNbBalleDeBreakRemporte() {
        return this.nbBalleDeBreakRemporte;
    }

    public void setNbBalleDeBreakRemporte(int nbBalleDeBreakRemporte) {
        this.nbBalleDeBreakRemporte = nbBalleDeBreakRemporte;
    }

    public int getNbBalleDeBreak() {
        return this.nbBalleDeBreak;
    }

    public void setNbBalleDeBreak(int nbBalleDeBreak) {
        this.nbBalleDeBreak = nbBalleDeBreak;
    }


}
