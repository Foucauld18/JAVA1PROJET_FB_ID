package sn.projet;

/**
 *
 * @author Foucauld
 */


public class Set {
    protected Joueur [] joueurs;
    protected int scoreSetJoueur0;
    protected int scoreSetJoueur1;
    protected Joueur vainqueurSet;
    protected Jeu jeux [];
    protected Arbitre arbitre;
        
    

    /*Builder */

    public Set(Joueur joueur0, Joueur joueur1,Arbitre arbitre){
        this.joueurs = new Joueur[] {joueur0,joueur1};
        this.vainqueurSet=null;
        this.arbitre=arbitre;
    }

    public void SetScore(Joueur VainqueurDernierJeu,int numeroSet,CategorieMatch categorie){

        
        
        if(VainqueurDernierJeu==joueurs[0]){
            this.scoreSetJoueur0+=1;

        } else this.scoreSetJoueur1+=1;

        if(this.scoreSetJoueur0 - this.scoreSetJoueur1 >1 || this.scoreSetJoueur0 - this.scoreSetJoueur1 <-1){//if 2 jeux d'ecart
            System.out.println("2jeux ecart");
            if (this.scoreSetJoueur0>5){//a gagner au moins 6jeux
                this.vainqueurSet=joueurs[0];
            }
            if (this.scoreSetJoueur1>5){
                this.vainqueurSet=joueurs[1];//a gagner au moins 6jeux
            }
            
        }
        if(categorie==CategorieMatch.simple_Homme){//match Homme en 5set
            if(this.scoreSetJoueur0==7 && this.scoreSetJoueur1 ==6 && numeroSet<5){//avant le 5eme set un socre de 7-6 permet de remporter le set
                this.vainqueurSet=joueurs[0];
            }
            if(this.scoreSetJoueur1==7 && this.scoreSetJoueur0 ==6 && numeroSet<5){
                this.vainqueurSet=joueurs[1];
            }
        }else{//match femme en 3 set
            if(this.scoreSetJoueur0==7 && this.scoreSetJoueur1 ==6 && numeroSet<3){//avant le 3eme set un socre de 7-6 permet de remporter le set
                this.vainqueurSet=joueurs[0];
            }
            if(this.scoreSetJoueur1==7 && this.scoreSetJoueur0 ==6 && numeroSet<3){
                this.vainqueurSet=joueurs[1];
            }
        }
       
        

    }

    public void ajouterUnJeu(Jeu newJeu){
        Jeu[] listeJeux = this.jeux;
        int SizeArray=0,i;
        try{
           SizeArray = listeJeux.length;
        }
        catch(Exception e){
            SizeArray=0;
        }
         
        Jeu [] newListeJeux= new Jeu[SizeArray+1];
        for(i=0;i<SizeArray;i++){
            newListeJeux[i]=listeJeux[i];
        }
        newListeJeux[SizeArray]=newJeu;
        this.jeux=newListeJeux;
    }

public Joueur jouerSet(int numeroSet,CategorieMatch categorie){
    boolean estfini=false;
    Joueur vainqueurDernierJeu=null;
    int compteurJeu=0;
    while(estfini == false){
          // Stat nb jeux joue par les deux joueurs
          joueurs[0].statJoueur.setNbJeuJoue(joueurs[0].statJoueur.getNbJeuJoue()+1);
          joueurs[1].statJoueur.setNbJeuJoue(joueurs[1].statJoueur.getNbJeuJoue()+1);
           //---  
        if(compteurJeu%2==0){//Permet d'alterner le service. Le premier serveur du match est tjs le joueur 0
            Jeu jeu = new Jeu(joueurs[0],joueurs[1],this.arbitre);
            ajouterUnJeu(jeu);
            vainqueurDernierJeu=jeu.jouerJeu();
        } else {
            Jeu jeu = new Jeu(joueurs[1],joueurs[0],this.arbitre);
            ajouterUnJeu(jeu);
            vainqueurDernierJeu=jeu.jouerJeu();
        }
        compteurJeu++;
        
        SetScore(vainqueurDernierJeu,numeroSet,categorie);
        arbitre.annoncerScoreSet(joueurs[0], joueurs[1], this.scoreSetJoueur0, this.scoreSetJoueur1,null);
        if(this.vainqueurSet==vainqueurDernierJeu){
            estfini=true;
            arbitre.annoncerScoreSet(joueurs[0], joueurs[1], this.scoreSetJoueur0, this.scoreSetJoueur1,vainqueurDernierJeu);
            if(this.vainqueurSet==joueurs[0]){//statistique
                joueurs[0].statJoueur.setNbSetGagne(joueurs[0].statJoueur.getNbSetGagne()+1);
            }else{
                joueurs[1].statJoueur.setNbSetGagne(joueurs[1].statJoueur.getNbSetGagne()+1);
            }
        }
        

    }
    return(vainqueurDernierJeu);
}

    
}

