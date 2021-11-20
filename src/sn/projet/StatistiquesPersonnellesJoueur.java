package sn.projet;

public class StatistiquesPersonnellesJoueur extends Statistiques{

    Match [] matchsJoue;
    int nbMatchGagne;
    int nbTournoisJoue;
    int totalGain;
    protected int jeuServiceGagne;
    

    public StatistiquesPersonnellesJoueur(){
        this.jeuServiceGagne=0;
    };

    /*Methods*/
    /**
     * 
     * @param newMatch
     */

    public void ajouterUnMatch(Match newMatch){
        Match [] listeMatchs = this.matchsJoue;
        int SizeArray=0,i;
        try{
           SizeArray = listeMatchs.length;
        }
        catch(Exception e){
            SizeArray=0;
        }
         
        Match[] newListeMatchs = new Match[SizeArray+1];
        for(i=0;i<SizeArray;i++){
            newListeMatchs[i]=listeMatchs[i];
        }
        newListeMatchs[SizeArray]=newMatch;
        this.matchsJoue=newListeMatchs;
    }
    /**
     * 
     * @return
     */
    public int getNbMatchJoue(){
        Match [] listeMatchs = this.matchsJoue;
        int SizeArray=0;
        try{
           SizeArray = listeMatchs.length;
        }
        catch(Exception e){
            SizeArray=0;
        }
        return (SizeArray);

    }
    public int getJeuServiceGagne() {
        return this.jeuServiceGagne;
    }

    public void setJeuServiceGagne(int jeuServiceGagne) {
        this.jeuServiceGagne = jeuServiceGagne;
    }


    public int getNbMatchGagne() {
        return this.nbMatchGagne;
    }


    public int getNbTournoisJoue() {
        return this.nbTournoisJoue;
    }

    public void setNbTournoisJoue(int nbTournoisJoue) {
        this.nbTournoisJoue = nbTournoisJoue;
    }

    public void SetNbMatchGagne(int nbMatchGagne) {
        this.nbMatchGagne=nbMatchGagne;
    }

    public int getTotalGain() {
        return this.totalGain;
    }

    public void setTotalGain(int totalGain) {
        this.totalGain = totalGain;
    }
}
