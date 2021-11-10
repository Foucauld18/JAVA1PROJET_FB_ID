package sn.projet;


public class Set {
    protected Joueur Joueur1;
    protected Joueur Joueur2;
    protected int scoreSetJoueur1;
    protected int scoreSetJoueur2;
    protected Joueur vainqueurSet;
        
    

    /*Builder */

    public Set(Joueur joueur1, Joueur joueur2){
        this.Joueur1=joueur1;
        this.Joueur2=joueur2;
        this.vainqueurSet=null;
    }

    public void SetScore(Joueur VainqueurDernierJeu,int numeroSet){

        
        
        if(VainqueurDernierJeu==this.Joueur1){
            this.scoreSetJoueur1+=1;

        } else this.scoreSetJoueur2+=1;

        if(this.scoreSetJoueur1 - this.scoreSetJoueur2 >1 || this.scoreSetJoueur1 - this.scoreSetJoueur2 <-1){
            if (this.scoreSetJoueur1>5){
                this.vainqueurSet=this.Joueur1;
            }
            if (this.scoreSetJoueur2>5){
                this.vainqueurSet=this.Joueur2;
            }
            
        }if(this.scoreSetJoueur1==7 && this.scoreSetJoueur2 ==6 && numeroSet<5){
            this.vainqueurSet=this.Joueur1;
        }if(this.scoreSetJoueur2==7 && this.scoreSetJoueur1 ==6 && numeroSet<5){
            this.vainqueurSet=this.Joueur2;
        }

    }

public void jouerSet(){
    boolean estfini=false;
    Joueur vainqueurDernierJeu;
    int compteur=1;
    while(estfini == false){
        Jeu jeu = new Jeu(this.Joueur1,this.Joueur2);
        vainqueurDernierJeu=jeu.jouerJeu();
        SetScore(vainqueurDernierJeu,compteur);
        if(this.vainqueurSet==vainqueurDernierJeu){
            estfini=true;
        }

    }

}

    
}
