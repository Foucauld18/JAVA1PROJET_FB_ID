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
    protected Joueur [] joueurs;
    protected int scoreJoueur1;
    protected int scoreJoueur2;
    protected Set sets[];
   
    protected Joueur vainqueurMatch;
    protected Joueur perdantMatch;
    protected String niveauMatch;

 
    public Match(String categorie,Joueur joueur0,Joueur joueur1,String niveauMatch){
        this.categorie = categorie;
        this.joueurs = new Joueur[] {joueur0,joueur1};
        this.niveauMatch = niveauMatch;
        this.scoreJoueur1=0;
        this.scoreJoueur2=0;
        this.vainqueurMatch=null;
        this.perdantMatch=null;
        
    }
    public void SetMatchResultat(Joueur vainqueurDernierSet){

        if(joueurs[0]==vainqueurDernierSet){
            this.scoreJoueur1+=1;
            if(this.scoreJoueur1>2 && this.categorie=="homme"){
                this.vainqueurMatch=joueurs[0];
                this.perdantMatch = joueurs[1];
            } 
            if(this.scoreJoueur1>1 && this.categorie=="femme"){
                this.vainqueurMatch=joueurs[0];
                this.perdantMatch = joueurs[1];
            } 
            
        } else {
            this.scoreJoueur2+=1;
            if(this.scoreJoueur2>2 && this.categorie=="homme"){
                this.vainqueurMatch=joueurs[1];
                this.perdantMatch = joueurs[0];
            } 
            if(this.scoreJoueur2>1 && this.categorie=="femme"){
                this.vainqueurMatch=joueurs[1];
                this.perdantMatch = joueurs[0];
            } 

        }      

}

public void ajouterUnSet(Set newSet){
    Set [] listeSets = this.sets;
    int SizeArray=0,i;
    try{
       SizeArray = listeSets.length;
    }
    catch(Exception e){
        SizeArray=0;
    }
     
    Set[] newListeSets = new Set[SizeArray+1];
    for(i=0;i<SizeArray;i++){
        newListeSets[i]=listeSets[i];
    }
    newListeSets[SizeArray]=newSet;
    this.sets=newListeSets;
}


public Joueur jouerMatch(){
    boolean matchIsFinished=false;
    Joueur vainqueurDernierSet=null;
    while(matchIsFinished==false){
        Set set = new Set(joueurs[0], joueurs[1]);
        vainqueurDernierSet = set.jouerSet();
        SetMatchResultat(vainqueurDernierSet);
        if(this.vainqueurMatch==vainqueurDernierSet){
            matchIsFinished=true;
        }
    }
    return(vainqueurDernierSet);
}
    

}










    

