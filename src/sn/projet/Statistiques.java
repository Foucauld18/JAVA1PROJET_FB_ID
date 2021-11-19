package sn.projet;

public class Statistiques implements Cloneable {

    
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
    protected int []tableau={};

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

    public int[] getTableau() {
        return this.tableau;
    }

    
    

    /*Methods*/

    public void afficherStat(){
        
        System.out.println("Set gagné : " + this.nbSetGagne);
        System.out.println("Set Joué : " + this.nbSetJoue);
        System.out.println("Jeu Joué : " + this.nbJeuJoue);
        System.out.println("Jeu gagné : " + this.nbJeuGagne);
        System.out.println("Total de points remporté : " +this.nbTotalPointRemporte );
        System.out.println("Ace : " +this.nbAce );
        System.out.println("Premier service gagnant : " + this.nbPremierService);
        System.out.println("Second service: " +this.nbSecondService );
        System.out.println("doubles fautes: " + this.nbDoubleFautes);
        System.out.println("Balle de break gagné : " + this.nbBalleDeBreakRemporte);
        System.out.println("Balle de Break : " + this.nbBalleDeBreak);
        System.out.println("----------------------------");
    }
 
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
    public Object clone() {
        Statistiques stat = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la 
            // méthode super.clone()
            stat =(Statistiques) super.clone();
        } catch(CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver, car nous implémentons 
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return stat;
    }

}
