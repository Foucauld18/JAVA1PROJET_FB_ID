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
    protected int scoreJoueur1;
    protected int scoreJoueur2;
   
    protected Joueur vainqueurMatch;
    protected Joueur perdantMatch;
    protected String niveauMatch;

 
    public Match(String categorie,Joueur joueur1,Joueur joueur2,String niveauMatch ){
        this.categorie = categorie;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.niveauMatch = niveauMatch;
        this.scoreJoueur1=0;
        this.scoreJoueur2=0;
        this.vainqueurMatch=null;
        this.perdantMatch=null;
        
    }
    public void SetMatchResultat(Joueur vainqueurDernierSet){

        if(joueur1==vainqueurDernierSet){
            this.scoreJoueur1+=1;
            if(this.scoreJoueur1>2 && this.categorie=="homme"){
                this.vainqueurMatch=joueur1;
                this.perdantMatch = joueur2;
            } 
            if(this.scoreJoueur1>1 && this.categorie=="femme"){
                this.vainqueurMatch=joueur1;
                this.perdantMatch = joueur2;
            } 
            
        } else {
            this.scoreJoueur2+=1;
            if(this.scoreJoueur2>2 && this.categorie=="homme"){
                this.vainqueurMatch=joueur2;
                this.perdantMatch = joueur1;
            } 
            if(this.scoreJoueur2>1 && this.categorie=="femme"){
                this.vainqueurMatch=joueur2;
                this.perdantMatch = joueur1;
            } 

        }      

}
public Joueur jouerMatch(){
    boolean matchIsFinished=false;
    Joueur vainqueurDernierSet=null;
    while(matchIsFinished==false){
        Set set = new Set(joueur1, joueur2);
        vainqueurDernierSet = set.jouerSet();
        SetMatchResultat(vainqueurDernierSet);
        if(this.vainqueurMatch==vainqueurDernierSet){
            matchIsFinished=true;
        }
    }
    return(vainqueurDernierSet);
}
    

}










    

