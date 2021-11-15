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
    protected Arbitre arbitre;
    protected int scoreJoueur0;
    protected int scoreJoueur1;
    protected Set sets[];
   
    protected Joueur vainqueurMatch;
    protected Joueur perdantMatch;
    protected String niveauMatch;

 
    public Match(Joueur joueura,Joueur joueurb,String niveauMatch,Arbitre arbitre){
        try{
            if(joueura.vetement!=joueurb.vetement||joueura.vetement==Vetement.Chemise||joueura.vetement==Vetement.Lunette){
                
                int i =2/0;
            }
        }catch(Exception e){
            System.out.println("ERREUR : Deux adversaires doivent être du même genre pour disputer un match");
            System.exit(0);
        }

        if(joueura.vetement==Vetement.Short){
            this.categorie = "Homme Simple";
        } else {
            this.categorie="Femme Simple";
        }
        Double aleatoire =Math.random();
        Joueur joueur0,joueur1;
        if(aleatoire<0.500001){// Designe le premier serveur. Le premier Serveur du match est par la suite le joueur0
            joueur0=joueura;
            joueur1=joueurb;
        }else{
            joueur0=joueurb;
            joueur1=joueura;
        }
        this.joueurs = new Joueur[] {joueur0,joueur1};
        this.niveauMatch = niveauMatch;
        this.scoreJoueur0=0;
        this.scoreJoueur1=0;
        this.arbitre=arbitre;
        this.vainqueurMatch=null;
        this.perdantMatch=null;
        
        
    }
   
    public void SetMatchResultat(Joueur vainqueurDernierSet){

        if(joueurs[0]==vainqueurDernierSet){
            this.scoreJoueur0=1;
            if(this.scoreJoueur0>2 && this.categorie=="Homme Simple"){
                this.vainqueurMatch=joueurs[0];
                this.perdantMatch = joueurs[1];
            } 
            if(this.scoreJoueur0>1 && this.categorie=="Femme Simple"){
                this.vainqueurMatch=joueurs[0];
                this.perdantMatch = joueurs[1];
            } 
            
        } else {
            this.scoreJoueur1+=1;
            if(this.scoreJoueur1>2 && this.categorie=="Homme Simple"){
                this.vainqueurMatch=joueurs[1];
                this.perdantMatch = joueurs[0];
            } 
            if(this.scoreJoueur1>1 && this.categorie=="Femme Simple"){
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
    int compteurSet=0;
    while(matchIsFinished==false){
        compteurSet++;
        Set set = new Set(joueurs[0], joueurs[1],this.arbitre);
        ajouterUnSet(set);
        vainqueurDernierSet = set.jouerSet(compteurSet);
        SetMatchResultat(vainqueurDernierSet);
        arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1, null);
        if(this.vainqueurMatch==vainqueurDernierSet){
            matchIsFinished=true;
            arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1, vainqueurDernierSet);
        }
        
    }
    return(vainqueurDernierSet);
}

    

}










    

