/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

/**
 *
 * @author Foucauld
 */
public class Match {
    protected String categorie;
    protected Joueur joueur1;
    protected Joueur joueur2;
   
    protected Joueur vainqueurMatch;
    protected Joueur perdantMatch;
    protected String niveauMatch;

 
    /**
     * 
     * @param categorie
     * @param joueur1
     * @param joueur2
     * @param niveauMatch
     */
    public Match(String categorie,Joueur joueur1,Joueur joueur2,String niveauMatch ){
        this.categorie = categorie;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        
        this.niveauMatch = niveauMatch;
        
    }
    public void SetResultat(Joueur vainqueur){
        this.vainqueurMatch=vainqueur;
        if(joueur1==vainqueur){
            this.perdantMatch = joueur2;
        } else {

            this.perdantMatch = joueur1;
        }
        
        

}

}










    

