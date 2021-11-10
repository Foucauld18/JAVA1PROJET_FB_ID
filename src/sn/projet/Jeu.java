package sn.projet;

public class Jeu {
    protected Joueur serveur;
    protected Joueur joueur2;
    protected String scoreServeur;
    protected String scoreJoueur2;
    protected Joueur vainqueurJeu;

    /*Builder */

    public Jeu(Joueur serveur, Joueur joueur2){
        this.serveur=serveur;
        this.joueur2=joueur2;
        this.scoreServeur="0";
        this.scoreJoueur2="0";
    }

    public void SetScore(Joueur joueur){
        String newScore="0";
        String scoreActuelle="0";
        boolean modificationScore = false;
        if(joueur == this.serveur){
            scoreActuelle=this.scoreServeur;
        } else scoreActuelle=this.scoreJoueur2;

        if(scoreActuelle=="0"){//SCORE DE +15
            newScore="15";
            modificationScore=true;
        } 
        if(scoreActuelle=="15"){//SCORE DE +15
            newScore="30";
            modificationScore=true;
        }
        if (scoreActuelle=="30"){//SCORE DE +10
            newScore="40";
            modificationScore=true;

        }
        if(joueur == this.serveur){
            if(modificationScore==true){//Le score a déjà été modifié et il n'implique pas une fin de jeu
                this.scoreServeur=newScore;
            } else{// le score actuelle(avant modification du setter) du joueur est de 40
                if(this.scoreJoueur2 == "40"){// AV-40
                    this.scoreServeur="AV";
                }
                if(this.scoreJoueur2 == "AV"){ // Cas ou l'avantage est pour le joueur 2 et on revient à 40a
                    this.scoreServeur="40";
                    this.scoreJoueur2="40";
                }
                else this.vainqueurJeu=this.serveur; // Cas ou le seveur à l'avantage (AV-40) ou que le joueur 2 a O,15 ou 30 points.
            }
            
        } else 
        if(modificationScore==true){//Le score a déjà été modifié et il n'implique pas une fin de jeu
            this.scoreJoueur2=newScore;
        } else {// le score actuelle(avant modification du setter) du joueur2 est de 40
            if(this.scoreServeur == "40"){// AV-40
                this.scoreJoueur2="AV";
            }
            if(this.scoreServeur == "AV"){ // Cas ou l'avantage est pour le serveur et on revient à 40a
                this.scoreServeur="40";
                this.scoreJoueur2="40";
            }
            else this.vainqueurJeu=this.joueur2; // Cas ou le joeur 2 à l'avantage (AV-40) ou que le serveur a O,15 ou 30 points.
    
        }
        
        

    }

    public Joueur jouerJeu(){
        boolean hasVainqueurJeu = false;
        Joueur vainqueurDernierEchange=null;
        while(hasVainqueurJeu != true)
        {
           Echange echange = new Echange(this.serveur,this.joueur2);
           vainqueurDernierEchange=echange.jouerEchange();
           SetScore(vainqueurDernierEchange);
           if(this.vainqueurJeu==vainqueurDernierEchange){
               hasVainqueurJeu=true;
           }
        }
        return (vainqueurDernierEchange);

    }

}
