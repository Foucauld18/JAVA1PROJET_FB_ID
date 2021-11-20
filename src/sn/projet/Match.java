/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.util.Scanner;

import java.security.DrbgParameters.NextBytes;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/**
 *
 * @author Foucauld18
 * 
 */
public class Match {
    protected CategorieMatch categorie;
    protected Joueur[] joueurs;
    protected Arbitre arbitre;
    protected int scoreJoueur0;
    protected int scoreJoueur1;
    protected Set sets[];
    protected Statistiques[] statistiques;

    protected Joueur vainqueurMatch;
    protected Joueur perdantMatch;
    protected NiveauMatch niveauMatch;

    /**
     * 
     * @param joueura
     * @param joueurb
     * @param niveauMatch 1er tour, 2ème tour ... final
     * @param arbitre
     */
    public Match(Joueur joueura, Joueur joueurb, NiveauMatch niveauMatch, Arbitre arbitre) {

        if (joueura instanceof JoueurHomme) {
            if (joueurb instanceof JoueurHomme) {
                this.categorie = CategorieMatch.simple_Homme;
            } else
                System.exit(1);

        } else if (joueura instanceof Joueuse) {
            if (joueurb instanceof Joueuse) {
                this.categorie = CategorieMatch.simple_Femme;
            } else
                System.exit(1);
        } else {
            System.exit(1);
        }

        Double aleatoire = Math.random();
        Joueur joueur0, joueur1;
        if (aleatoire < 0.500001) {// Designe le premier serveur. Le premier Serveur du match est par la suite le
                                   // joueur0
            joueur0 = joueura;
            joueur1 = joueurb;
        } else {
            joueur0 = joueurb;
            joueur1 = joueura;
        }
        this.joueurs = new Joueur[] { joueur0, joueur1 };
        this.niveauMatch = niveauMatch;
        this.scoreJoueur0 = 0;
        this.scoreJoueur1 = 0;
        this.arbitre = arbitre;
        this.vainqueurMatch = null;
        this.perdantMatch = null;
        Statistiques statJoueur0Match = new Statistiques();
        Statistiques statJoueur1Match = new Statistiques();
        Statistiques statMatch = new Statistiques();
        this.statistiques = new Statistiques[] { statJoueur0Match, statJoueur1Match, statMatch };

    }

    /**
     * 
     * @param vainqueurDernierSet
     * @return Permet de mettre à jour le score du match
     */

    /**
     * tgtgbtbt
     * 
     * @param vainqueurDernierSet frfr
     */
    public void SetMatchResultat(Joueur vainqueurDernierSet) {

        if (joueurs[0] == vainqueurDernierSet) {
            this.scoreJoueur0 += 1;
            if (this.scoreJoueur0 > 2 && this.categorie == CategorieMatch.simple_Homme) {
                this.vainqueurMatch = joueurs[0];
                this.perdantMatch = joueurs[1];
            }
            if (this.scoreJoueur0 > 1 && this.categorie == CategorieMatch.simple_Femme) {
                this.vainqueurMatch = joueurs[0];
                this.perdantMatch = joueurs[1];
            }

        } else {
            this.scoreJoueur1 += 1;
            if (this.scoreJoueur1 > 2 && this.categorie == CategorieMatch.simple_Homme) {
                this.vainqueurMatch = joueurs[1];
                this.perdantMatch = joueurs[0];
            }
            if (this.scoreJoueur1 > 1 && this.categorie == CategorieMatch.simple_Femme) {
                this.vainqueurMatch = joueurs[1];
                this.perdantMatch = joueurs[0];
            }

        }

    }

    /**
     * 
     * @param newSet
     * @return Permet d'ajouter un set à un match
     */

    public void ajouterUnSet(Set newSet) {
        Set[] listeSets = this.sets;
        int SizeArray = 0, i;
        try {
            SizeArray = listeSets.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        Set[] newListeSets = new Set[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newListeSets[i] = listeSets[i];
        }
        newListeSets[SizeArray] = newSet;
        this.sets = newListeSets;
    }

    /**
     * Ajoute un certain nombre point au vainqueur d'un match pour mettre à jour le
     * classement ATP et WTA.
     */
    public void modifierClassementVainqueurMatch() {
        int valeurMatch = 0;
        switch (this.niveauMatch) {
        case premierTour:
            valeurMatch = 5;
            break;
        case deuxiemeTour:
            valeurMatch = 10;
            break;
        case troisiemeTour:
            valeurMatch = 15;
            break;
        case huitiemeFinal:
            valeurMatch = 20;
            break;
        case quartFinal:
            valeurMatch = 30;
            break;
        case demiFinal:
            valeurMatch = 40;
            break;
        case Final:
            valeurMatch = 50;
            break;
        default:
            valeurMatch = 0;// Match amicale

        }
        this.vainqueurMatch.setNbPoints(this.vainqueurMatch.getNbPoints() + valeurMatch);

    }

    /**
     * 
     * @return Vainqueur du match
     */
    public Joueur jouerMatch(boolean tournoisAutomatique) {
        boolean matchAutomatique = true;
        if (tournoisAutomatique == false) {

            boolean goodCommande = false;
            while (goodCommande == false) {
                System.out.println(
                        "Pour jouer automatiquement ce match taper 'auto'. Pour jouer manuellement ce match taper 'manuel' ");

                String commande = "";
                Scanner keyboard = new Scanner(System.in);
                commande = keyboard.nextLine();
                if (commande.equals("auto")) {
                    goodCommande = true;
                } else if (commande.equals("manuel")) {
                    goodCommande = true;
                    matchAutomatique = false;
                }

            }

        }

        getInitStatJoueur();
        boolean afficherScorefinDuMatch = false;
        boolean matchIsFinished = false;
        Joueur vainqueurDernierSet = null;
        int compteurSet = 0;
        while (matchIsFinished == false) {
            // STAT NOMBRE DE SET JOUE
            joueurs[0].statJoueur.setNbSetJoue(joueurs[0].statJoueur.getNbSetJoue() + 1);
            joueurs[1].statJoueur.setNbSetJoue(joueurs[1].statJoueur.getNbSetJoue() + 1);
            compteurSet++;
            Set set = new Set(joueurs[0], joueurs[1], this.arbitre);
            ajouterUnSet(set);

            if (matchAutomatique == true) {
                vainqueurDernierSet = set.jouerSet(compteurSet, this.categorie, true);
                SetMatchResultat(vainqueurDernierSet);
                arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1, null, false);
            } else {
                vainqueurDernierSet = set.jouerSet(compteurSet, this.categorie, false);
                SetMatchResultat(vainqueurDernierSet);
                arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1, null, true);
            }

            if (this.vainqueurMatch == vainqueurDernierSet) {
                matchIsFinished = true;
                if (afficherScorefinDuMatch == true) {
                    arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1, null,
                            true);
                }
                arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1,
                        vainqueurDernierSet, true);
                if (this.vainqueurMatch == joueurs[0])// Stat vainqueur match
                {
                    joueurs[0].statJoueur.SetNbMatchGagne(joueurs[0].statJoueur.getNbMatchGagne() + 1);
                } else {
                    joueurs[1].statJoueur.SetNbMatchGagne(joueurs[1].statJoueur.getNbMatchGagne() + 1);
                }
            }

            if (matchAutomatique == false && matchIsFinished == false) {
                boolean goodCommande = false;
                while (goodCommande == false) {
                    System.out.println("Pour simuler la fin du match taper 'fin' sinon continuer!");
                    String commande = "";
                    Scanner keyboard = new Scanner(System.in);
                    commande = keyboard.nextLine();
                    if (commande.equals("fin")) {
                        goodCommande = true;
                        matchAutomatique = true;
                        afficherScorefinDuMatch = true;
                    } else {
                        goodCommande = true;
                    }
                }
            }

        }
        updateStatMatch();
        return (vainqueurDernierSet);
    }

    public void getInitStatJoueur() {
        this.statistiques[0] = (Statistiques) this.joueurs[0].statJoueur.clone();
        this.statistiques[1] = (Statistiques) this.joueurs[1].statJoueur.clone();
    }

    public void updateStatMatch() {

        Statistiques[] tampons = new Statistiques[] { this.statistiques[0], this.statistiques[1] };

        for (int i = 0; i < 2; i++) {// Determine les stats de chaque joeurs pendant le match. Pour les trouvers on
                                     // soustrait les stats du joueurs à ces stats d'avant match
            this.statistiques[i]
                    .setNbDoubleFautes(this.joueurs[i].statJoueur.getNbDoubleFautes() - tampons[i].getNbDoubleFautes());
            this.statistiques[i].setNbJeuGagne(this.joueurs[i].statJoueur.getNbJeuGagne() - tampons[i].getNbJeuGagne());
            this.statistiques[i].setNbJeuJoue(this.joueurs[i].statJoueur.nbJeuJoue - tampons[i].getNbJeuJoue());
            this.statistiques[i].setNbPremierService(
                    this.joueurs[i].statJoueur.getNbPremierService() - tampons[i].getNbPremierService());
            this.statistiques[i].setNbSecondService(
                    this.joueurs[i].statJoueur.getNbSecondService() - tampons[i].getNbSecondService());
            this.statistiques[i].setNbSetGagne(this.joueurs[i].statJoueur.getNbSetGagne() - tampons[i].getNbSetGagne());
            this.statistiques[i].setNbSetJoue(this.joueurs[i].statJoueur.getNbSetJoue() - tampons[i].getNbSetJoue());
            this.statistiques[i].setNbTotalPointRemporte(
                    this.joueurs[i].statJoueur.getNbTotalPointRemporte() - tampons[i].getNbTotalPointRemporte());
        }
        // Determine les stats du match. C'est la somme des stats de chaque joueur
        this.statistiques[2]
                .setNbDoubleFautes(this.statistiques[1].getNbDoubleFautes() + this.statistiques[0].getNbDoubleFautes());
        this.statistiques[2].setNbJeuGagne(this.statistiques[1].getNbJeuGagne() + this.statistiques[0].getNbJeuGagne());
        this.statistiques[2].setNbJeuJoue(this.statistiques[1].getNbJeuJoue());
        this.statistiques[2].setNbPremierService(
                this.statistiques[1].getNbPremierService() + this.statistiques[0].getNbPremierService());
        this.statistiques[2].setNbSecondService(
                this.statistiques[1].getNbSecondService() + this.statistiques[0].getNbSecondService());
        this.statistiques[2].setNbSetGagne(this.statistiques[1].getNbSetGagne() + this.statistiques[0].getNbSetGagne());
        this.statistiques[2].setNbSetJoue(this.statistiques[1].getNbSetJoue());
        this.statistiques[2].setNbTotalPointRemporte(
                this.statistiques[1].getNbTotalPointRemporte() + this.statistiques[0].getNbTotalPointRemporte());

    }

}
