package sn.projet;

public class Jeu {
    protected Joueur [] joueurs;
    protected Echange [] echanges;
    protected String scoreServeur;
    protected String scoreJoueur1;
    protected Joueur vainqueurJeu;

    /*Builder */

    public Jeu(Joueur serveur, Joueur joueur1){
        this.joueurs = new Joueur[]{serveur,joueur1};
        this.scoreServeur="0";
        this.scoreJoueur1="0";
    }

    public void SetScore(Joueur joueur){
        String newScore="0";
        String scoreActuelle="0";
        boolean modificationScore = false;
        if(joueur == joueurs[0]){
            scoreActuelle=this.scoreServeur;
        } else scoreActuelle=this.scoreJoueur1;

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
        if(joueur == joueurs[0]){
            if(modificationScore==true){//Le score a déjà été modifié et il n'implique pas une fin de jeu
                this.scoreServeur=newScore;
            } else{// le score actuelle(avant modification du setter) du joueur est de 40
                if(this.scoreJoueur1 == "40"){// AV-40
                    this.scoreServeur="AV";
                }
                if(this.scoreJoueur1 == "AV"){ // Cas ou l'avantage est pour le joueur 2 et on revient à 40a
                    this.scoreServeur="40";
                    this.scoreJoueur1="40";
                }
                else this.vainqueurJeu=joueurs[0]; // Cas ou le seveur à l'avantage (AV-40) ou que le joueur 2 a O,15 ou 30 points.
            }
            
        } else 
        if(modificationScore==true){//Le score a déjà été modifié et il n'implique pas une fin de jeu
            this.scoreJoueur1=newScore;
        } else {// le score actuelle(avant modification du setter) du joueur2 est de 40
            if(this.scoreServeur == "40"){// AV-40
                this.scoreJoueur1="AV";
            }
            if(this.scoreServeur == "AV"){ // Cas ou l'avantage est pour le serveur et on revient à 40a
                this.scoreServeur="40";
                this.scoreJoueur1="40";
            }
            else this.vainqueurJeu=joueurs[1]; // Cas ou le joeur 2 à l'avantage (AV-40) ou que le serveur a O,15 ou 30 points.
    
        }
        
        

    }

    public void ajouterUnEchange(Echange newEchange){
        Echange [] listeEchanges = this.echanges;
        int SizeArray=0,i;
        try{
           SizeArray = listeEchanges.length;
        }
        catch(Exception e){
            SizeArray=0;
        }
         
        Echange[] newListeEchange = new Echange[SizeArray+1];
        for(i=0;i<SizeArray;i++){
            newListeEchange[i]=listeEchanges[i];
        }
        newListeEchange[SizeArray]=newEchange;
        this.echanges=newListeEchange;
    }

    public Joueur jouerJeu(){
        boolean hasVainqueurJeu = false;
        Joueur vainqueurDernierEchange=null;
        while(hasVainqueurJeu != true)
        {
           Echange echange = new Echange(joueurs[0],joueurs[1]);
           ajouterUnEchange(echange);
           vainqueurDernierEchange=echange.jouerEchange();
           SetScore(vainqueurDernierEchange);
           if(this.vainqueurJeu==vainqueurDernierEchange){
               hasVainqueurJeu=true;
           }
        }
        return (vainqueurDernierEchange);

    }

}