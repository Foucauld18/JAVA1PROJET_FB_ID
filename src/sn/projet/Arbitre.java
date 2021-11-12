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
public class Arbitre extends Personne{
    
    
    public Arbitre(String nomNaissance, String nomCourant, String prenom,
                    String surnom, LocalDate dateNaissance, String lieuNaissance,
                    LocalDate dateDeces, String nationalite, int taille, int poids){
        
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        
    }

    
    //public void annoncerScoreMatch()
    //public void annoncerScoreSet()
    public void annoncerScoreJeu(Jeu jeu){
        if(jeu.scoreServeur.equals(jeu.scoreJoueur1))//Egalite des scores exemple 30A
        {
            System.out.println(jeu.scoreServeur + " A");
        }
        if(jeu.scoreServeur.equals("AV")){// Avantagage Serveur = Avantage Monfils
            System.out.println("Avantage " + jeu.joueurs[0].nomCourant);
        }
        if(jeu.scoreJoueur1.equals("AV")){//Avantage Joueur
            System.out.println("Avantage " + jeu.joueurs[1].nomCourant);
        }
        if(jeu.vainqueurJeu==jeu.joueurs[0]){//Si le jeu est remporté par le serveur
            System.out.println("Jeu " + jeu.joueurs[0].nomCourant);
        }
        if(jeu.vainqueurJeu==jeu.joueurs[1]){//Si le jeu est remporté par l'autre joueur
            System.out.println("Jeu " + jeu.joueurs[1].nomCourant);
        }
        else{//Annonce du score en commencant par le serveur
            System.out.println(jeu.scoreServeur);
            System.out.println(jeu.scoreJoueur1);
        }
       
       
        
    }
}