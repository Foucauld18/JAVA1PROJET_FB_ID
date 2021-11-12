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
        
    

    /*Builder */

    public Set(Joueur joueur0, Joueur joueur1){
        this.joueurs = new Joueur[] {joueur0,joueur1};
        this.vainqueurSet=null;
    }

    public void SetScore(Joueur VainqueurDernierJeu,int numeroSet){

        
        
        if(VainqueurDernierJeu==joueurs[0]){
            this.scoreSetJoueur0+=1;

        } else this.scoreSetJoueur1+=1;

        if(this.scoreSetJoueur0 - this.scoreSetJoueur1 >1 || this.scoreSetJoueur0 - this.scoreSetJoueur1 <-1){
            if (this.scoreSetJoueur0>5){
                this.vainqueurSet=joueurs[0];
            }
            if (this.scoreSetJoueur1>5){
                this.vainqueurSet=joueurs[1];
            }
            
        }if(this.scoreSetJoueur0==7 && this.scoreSetJoueur1 ==6 && numeroSet<5){
            this.vainqueurSet=joueurs[0];
        }if(this.scoreSetJoueur1==7 && this.scoreSetJoueur0 ==6 && numeroSet<5){
            this.vainqueurSet=joueurs[1];
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

public Joueur jouerSet(){
    boolean estfini=false;
    Joueur vainqueurDernierJeu=null;
    int compteur=1;
    while(estfini == false){
        Jeu jeu = new Jeu(joueurs[0],joueurs[1]);
        ajouterUnJeu(jeu);
        vainqueurDernierJeu=jeu.jouerJeu();
        SetScore(vainqueurDernierJeu,compteur);
        if(this.vainqueurSet==vainqueurDernierJeu){
            estfini=true;
        }
        

    }
    return(vainqueurDernierJeu);
}

    
}

