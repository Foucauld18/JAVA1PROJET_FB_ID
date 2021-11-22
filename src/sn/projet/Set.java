package sn.projet;

import java.util.Scanner;

/**
 *
 * @author Foucauld
 */

public class Set {
    protected Joueur[] joueurs;
    protected int scoreSetJoueur0;
    protected int scoreSetJoueur1;
    protected Joueur vainqueurSet;
    protected Jeu jeux[];
    protected Arbitre arbitre;

    /* Builder */

    public Set(Joueur joueur0, Joueur joueur1, Arbitre arbitre) {
        this.joueurs = new Joueur[] { joueur0, joueur1 };
        this.vainqueurSet = null;
        this.arbitre = arbitre;
    }

    public void SetScore(Joueur VainqueurDernierJeu, int numeroSet, CategorieMatch categorie) {

        if (VainqueurDernierJeu == joueurs[0]) {
            this.scoreSetJoueur0 += 1;

        } else
            this.scoreSetJoueur1 += 1;

        if (this.scoreSetJoueur0 - this.scoreSetJoueur1 > 1 || this.scoreSetJoueur0 - this.scoreSetJoueur1 < -1) {// if
                                                                                                                  // 2
                                                                                                                  // jeux
                                                                                                                  // d'ecart
            if (this.scoreSetJoueur0 > 5) {// a gagner au moins 6jeux
                this.vainqueurSet = joueurs[0];
            }
            if (this.scoreSetJoueur1 > 5) {
                this.vainqueurSet = joueurs[1];// a gagner au moins 6jeux
            }

        }
        if (categorie == CategorieMatch.simple_Homme) {// match Homme en 5set
            if (this.scoreSetJoueur0 == 7 && this.scoreSetJoueur1 == 6 && numeroSet < 5) {// avant le 5eme set un socre
                                                                                          // de 7-6 permet de remporter
                                                                                          // le set
                this.vainqueurSet = joueurs[0];
            }
            if (this.scoreSetJoueur1 == 7 && this.scoreSetJoueur0 == 6 && numeroSet < 5) {
                this.vainqueurSet = joueurs[1];
            }
        } else {// match femme en 3 set
            if (this.scoreSetJoueur0 == 7 && this.scoreSetJoueur1 == 6 && numeroSet < 3) {// avant le 3eme set un socre
                                                                                          // de 7-6 permet de remporter
                                                                                          // le set
                this.vainqueurSet = joueurs[0];
            }
            if (this.scoreSetJoueur1 == 7 && this.scoreSetJoueur0 == 6 && numeroSet < 3) {
                this.vainqueurSet = joueurs[1];
            }
        }

    }

    public void ajouterUnJeu(Jeu newJeu) {
        Jeu[] listeJeux = this.jeux;
        int SizeArray = 0, i;
        try {
            SizeArray = listeJeux.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        Jeu[] newListeJeux = new Jeu[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newListeJeux[i] = listeJeux[i];
        }
        newListeJeux[SizeArray] = newJeu;
        this.jeux = newListeJeux;
    }
    /**
     * 
     * @param  numeroSet
     * @param categorie
     * @param matchAutomatique
     * @param afficherDetailSet
     * @return Joueur Vainqueur du Set
     */

    public Joueur jouerSet(int numeroSet, CategorieMatch categorie, boolean matchAutomatique,boolean afficherDetailSet) {
        boolean setAutomatique = true;
        if (matchAutomatique == false) {
            setAutomatique = false;
        }
        boolean estfini = false;
        Joueur vainqueurDernierJeu = null;
        int compteurJeu = 0;
        boolean afficherScorefinDuSet = false;
        while (estfini == false) {
            // Stat nb jeux joue par les deux joueurs
            joueurs[0].statJoueur.setNbJeuJoue(joueurs[0].statJoueur.getNbJeuJoue() + 1);
            joueurs[1].statJoueur.setNbJeuJoue(joueurs[1].statJoueur.getNbJeuJoue() + 1);
            // ---

            if (setAutomatique == true) {//matchautomatique
                if (compteurJeu % 2 == 0) {// Permet d'alterner le service. Le premier serveur du match est tjs le
                                           // joueur 0
                    Jeu jeu = new Jeu(joueurs[0], joueurs[1], this.arbitre);
                    ajouterUnJeu(jeu);
                    vainqueurDernierJeu = jeu.jouerJeu(true, afficherDetailSet);

                } else {
                    Jeu jeu = new Jeu(joueurs[1], joueurs[0], this.arbitre);
                    ajouterUnJeu(jeu);
                    vainqueurDernierJeu = jeu.jouerJeu(true, afficherDetailSet);
                }
                compteurJeu++;
                SetScore(vainqueurDernierJeu, numeroSet, categorie);
                arbitre.annoncerScoreSet(joueurs[0], joueurs[1], this.scoreSetJoueur0, this.scoreSetJoueur1, null,
                        afficherDetailSet);
            } else {//match manuel
                if (compteurJeu % 2 == 0) {// Permet d'alterner le service. Le premier serveur du match est tjs le
                                           // joueur 0
                    Jeu jeu = new Jeu(joueurs[0], joueurs[1], this.arbitre);
                    ajouterUnJeu(jeu);
                    vainqueurDernierJeu = jeu.jouerJeu(false, true);

                } else {
                    Jeu jeu = new Jeu(joueurs[1], joueurs[0], this.arbitre);
                    ajouterUnJeu(jeu);
                    vainqueurDernierJeu = jeu.jouerJeu(false, true);
                }
                compteurJeu++;
                SetScore(vainqueurDernierJeu, numeroSet, categorie);
                arbitre.annoncerScoreSet(joueurs[0], joueurs[1], this.scoreSetJoueur0, this.scoreSetJoueur1, null,
                        true);
            }

            if (this.vainqueurSet == vainqueurDernierJeu) {
                estfini = true;
                if (afficherScorefinDuSet == true || afficherDetailSet==true) {
                    arbitre.annoncerScoreSet(joueurs[0], joueurs[1], this.scoreSetJoueur0, this.scoreSetJoueur1, null,
                            true);
                    arbitre.annoncerScoreSet(joueurs[0], joueurs[1], this.scoreSetJoueur0, this.scoreSetJoueur1,
                            vainqueurDernierJeu, true);
                }

                if (this.vainqueurSet == joueurs[0]) {// statistique
                    joueurs[0].statJoueur.setNbSetGagne(joueurs[0].statJoueur.getNbSetGagne() + 1);
                } else {
                    joueurs[1].statJoueur.setNbSetGagne(joueurs[1].statJoueur.getNbSetGagne() + 1);
                }
            }
            if (setAutomatique == false && estfini == false) {
                boolean goodCommande = false;
                while (goodCommande == false) {
                    System.out.println("Pour simuler la fin du set taper 'fin' sinon continuer!");
                    String commande = "";
                    Scanner keyboard = new Scanner(System.in);
                    commande = keyboard.nextLine();
                    if (commande.equals("fin")) {
                        goodCommande = true;
                        setAutomatique = true;
                        afficherScorefinDuSet = true;
                    } else {
                        goodCommande = true;
                    }
                }
            }

        }
        return (vainqueurDernierJeu);
    }

}
