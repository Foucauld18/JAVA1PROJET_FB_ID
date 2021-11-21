/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.time.LocalDate;

/**
 *
 * @author Ibrahima
 */
public class Arbitre extends Personne {

    public Arbitre(String nomNaissance, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
            String nationalite, int taille, int poids) {
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids);

    }

    public void annoncerScoreMatch(Joueur joueur0, Joueur joueur1, int scoreJoueur0, int scoreJoueur1,
            Joueur vainqueurMatch, boolean parle) {
        if (parle == true) {// L'arbitre annonce
            if (vainqueurMatch != null) {
                System.out.println("Vainqueur du Match " + vainqueurMatch.nomCourant);
                return;
            }
            if (scoreJoueur0 < scoreJoueur1) {// Joueur1 est en train de gagner
                System.out.println(joueur1.nomCourant + " mène " + scoreJoueur1 + " set à " + scoreJoueur0);
            } else if (scoreJoueur0 > scoreJoueur1) {// JoueurO est en train de gagner
                System.out.println(joueur0.nomCourant + " mène " + scoreJoueur0 + " set à " + scoreJoueur1);
            } else {// égalité des joueurs
                System.out.println(scoreJoueur0 + " set partout ");
            }
        }

    }

    public void annoncerScoreSet(Joueur joueur0, Joueur joueur1, int scoreJoueur0, int scoreJoueur1,
            Joueur vainqueurSet, boolean parle) {
        if (parle == true) {// L'arbitre annonce
            if (vainqueurSet != null) {
                System.out.println("Set " + vainqueurSet.nomCourant);
                return;
            }
            if (scoreJoueur0 < scoreJoueur1) {// Joueur1 est en train de gagner
                System.out.println(joueur1.nomCourant + " mène " + scoreJoueur1 + " jeux à " + scoreJoueur0);
            } else if (scoreJoueur0 > scoreJoueur1) {// JoueurO est en train de gagner
                System.out.println(joueur0.nomCourant + " mène " + scoreJoueur0 + " jeux à " + scoreJoueur1);
            } else {// égalité des joueurs
                System.out.println(scoreJoueur0 + " jeux partout ");
            }
        }

    }

    public void annoncerScoreJeu(String scoreServeur, String scoreJoueur1, String serveur, String joueur1,
            String vainqueurJeu, boolean parle) {
        
        if (parle == true) {// L'arbitre annonce
            System.out.println("------------");
            
            if (vainqueurJeu == serveur) {// Si le jeu est remporté par le serveur
                System.out.println("Jeu " + serveur);
                return;
            }
            if (vainqueurJeu == joueur1) {// Si le jeu est remporté par l'autre joueur
                System.out.println("Jeu " + joueur1);
                return;
            }
            if (scoreServeur.equals(scoreJoueur1))// Egalite des scores exemple 30A
            {
                System.out.println(scoreServeur + " A");
                return;
            }
            if (scoreServeur.equals("AV")) {// Avantagage Serveur = Avantage Monfils
                System.out.println("Avantage " + serveur);
                return;

            }
            if (scoreJoueur1.equals("AV")) {// Avantage Joueur
                System.out.println("Avantage " + joueur1);
                return;
            }

            // Annonce du score en commencant par le serveur
            System.out.println(scoreServeur);
            System.out.println(scoreJoueur1);

        }
    }

}