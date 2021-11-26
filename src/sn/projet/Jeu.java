package sn.projet;

public class Jeu {
    protected Joueur[] joueurs;
    protected Echange[] echanges;
    protected String scoreServeur;
    protected String scoreJoueur1;
    protected Joueur vainqueurJeu;
    protected Arbitre arbitre;

    /* Builder */
    /**
     * 
     * @param serveur
     * @param joueur1
     * @param arbitre
     */

    public Jeu(Joueur serveur, Joueur joueur1, Arbitre arbitre) {
        this.joueurs = new Joueur[] { serveur, joueur1 };
        this.scoreServeur = "0";
        this.scoreJoueur1 = "0";
        this.arbitre = arbitre;
        this.vainqueurJeu = null;
    }
    /**
     * 
     * @param joueur
     * @return Met a jour le classement du jeu suite à un échange
     */

    public void SetScore(Joueur joueur) {
        String newScore = "0";
        String scoreActuelle = "0";
        boolean modificationScore = false;
        if (joueur == joueurs[0]) {
            scoreActuelle = this.scoreServeur;
        } else
            scoreActuelle = this.scoreJoueur1;

        if (scoreActuelle == "0") {// SCORE DE +15
            newScore = "15";
            modificationScore = true;
        }
        if (scoreActuelle == "15") {// SCORE DE +15
            newScore = "30";
            modificationScore = true;
        }
        if (scoreActuelle == "30") {// SCORE DE +10
            newScore = "40";
            modificationScore = true;

        }
        if (joueur == joueurs[0]) {
            if (modificationScore == true) {// Le score a déjà été modifié et il n'implique pas une fin de jeu
                this.scoreServeur = newScore;
                return;
            } else {// le score actuelle(avant modification du setter) du joueur est de 40 ou de AV
                if (this.scoreJoueur1 == "40") {// AV-40
                    if (this.scoreServeur == "40") {
                        this.scoreServeur = "AV";
                    } else {
                        this.vainqueurJeu = joueurs[0];
                    }
                    return;
                }
                if (this.scoreJoueur1 == "AV") { // Cas ou l'avantage est pour le joueur 2 et on revient à 40a
                    this.scoreServeur = "40";
                    this.scoreJoueur1 = "40";
                    return;
                } else
                    this.vainqueurJeu = joueurs[0]; // Cas ou le seveur à l'avantage (AV-40) ou que le joueur 2 a O,15
                                                    // ou 30 points.
            }

        } else if (modificationScore == true) {// Le score a déjà été modifié et il n'implique pas une fin de jeu
            this.scoreJoueur1 = newScore;
        } else {// le score actuelle(avant modification du setter) du joueur1 est de 40 ou de AV
            if (this.scoreServeur == "40") {// AV-40
                if (this.scoreJoueur1 == "40") {
                    this.scoreJoueur1 = "AV";
                } else {
                    this.vainqueurJeu = joueurs[1];
                }
                return;
            }
            if (this.scoreServeur == "AV") { // Cas ou l'avantage est pour le serveur et on revient à 40a
                this.scoreServeur = "40";
                this.scoreJoueur1 = "40";
            } else
                this.vainqueurJeu = joueurs[1]; // Cas ou le joueur 1 à l'avantage (AV-40) ou que le serveur a O,15 ou
                                                // 30 points.

        }

    }
    /**
     * Ajoute un Echange à la liste des echange d'un jeu
     * @param newEchange
     */

    public void ajouterUnEchange(Echange newEchange) {
        Echange[] listeEchanges = this.echanges;
        int SizeArray = 0, i;
        try {
            SizeArray = listeEchanges.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        Echange[] newListeEchange = new Echange[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newListeEchange[i] = listeEchanges[i];
        }
        newListeEchange[SizeArray] = newEchange;
        this.echanges = newListeEchange;
    }
/**
 * 
 * @param jeuAutomatique true le jeu se joura automatiquement, false manuellement
 * @param afficherDetailJeu true tout les echange seront afficher ainsi que les scores après chaque échange
 * @return Vainqueur du jeu
 */
    public Joueur jouerJeu(boolean jeuAutomatique,boolean afficherDetailJeu) {
        boolean hasVainqueurJeu = false;
        Joueur vainqueurDernierEchange = null;
        while (hasVainqueurJeu != true) {
            Echange echange = new Echange(joueurs[0], joueurs[1], this.arbitre);
            ajouterUnEchange(echange);
            if (jeuAutomatique == true) {
                vainqueurDernierEchange = echange.jouerEchange(true);
            } else {
                vainqueurDernierEchange = echange.jouerEchange(false);
            }

            SetScore(vainqueurDernierEchange);

            if (this.vainqueurJeu == vainqueurDernierEchange) {// Le jeu est fini
                hasVainqueurJeu = true;
                this.arbitre.annoncerScoreJeu(this.scoreServeur, this.scoreJoueur1, joueurs[0].nomCourant,
                        joueurs[1].nomCourant, vainqueurDernierEchange.nomCourant, afficherDetailJeu);
                if (this.vainqueurJeu == joueurs[0]) {// Stat jeux gagnés
                    joueurs[0].statJoueur.setNbJeuGagne(joueurs[0].statJoueur.getNbJeuGagne() + 1);
                    joueurs[0].statJoueur.setJeuServiceGagne(joueurs[0].statJoueur.getJeuServiceGagne() + 1);
                } else {
                    joueurs[1].statJoueur.setNbJeuGagne(joueurs[1].statJoueur.getNbJeuGagne() + 1);
                }
            } else {// le Jeu n'est pas fini on continue
                this.arbitre.annoncerScoreJeu(this.scoreServeur, this.scoreJoueur1, joueurs[0].nomCourant,
                        joueurs[1].nomCourant, null, afficherDetailJeu);
            }
        }
        return (vainqueurDernierEchange);

    }

}
