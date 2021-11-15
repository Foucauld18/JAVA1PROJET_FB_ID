/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.time.LocalDate;

import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Ibrahima
 */
public class Tennis {

        
    public static void main(String[] args) {
        Spectatrice b = new Spectatrice("DIALLO", "Ba", "Ibahima", "The Goat", LocalDate.of(1999, 9, 4), "Dakar",
                LocalDate.of(2050, 4, 9), "Senegalaise", 180, 70, Couleur.Jaune);

        Joueur a = new Joueur("Diallo", "Ba", "Ibrahima", "The goat", LocalDate.of(1999, 9, 4), "Metz",
                LocalDate.of(2035, 1, 5), "Senegalaise", 180, 70, Main.Droite, "Tropico", "Poutine", Vetement.Short,
                Couleur.Bleu,100);

        Joueur c = new Joueur("Bergerault", "FB", "Foucauld", "The goat", LocalDate.of(1999, 9, 4), "Metz",
                LocalDate.of(2035, 1, 5), "Francaise", 180, 70, Main.Droite, "Tropico", "Poutine", Vetement.Short,
                Couleur.Bleu,200);

        Joueur d = new Joueur("FANCHON", "TF", "THIBAULT", "The goat", LocalDate.of(1999, 9, 4), "Metz",
                LocalDate.of(2035, 1, 5), "Francaise", 180, 70, Main.Droite, "Tropico", "Poutine", Vetement.Short,
                Couleur.Bleu,3000);
                Joueur e = new Joueur("FANCHON", "TF", "THIBAULT", "The goat", LocalDate.of(1999, 9, 4), "Metz",
                LocalDate.of(2035, 1, 5), "Francaise", 180, 70, Main.Droite, "Tropico", "Poutine", Vetement.Short,
                Couleur.Bleu,30);

        //Arbitre arbitre = new Arbitre("Bergerault", "FB", "Foucauld", "The goat", LocalDate.of(1999, 9, 4), "Metz",
        //LocalDate.of(2035, 1, 5), "Francaise", 180, 70);

        //Classement atp = new Classement("atp");
        //atp.ajouterJoueurClassement(a);
        //atp.ajouterJoueurClassement(c);
        //atp.ajouterJoueurClassement(d);
        //atp.ajouterJoueurClassement(e);
        

        

        // Match premierMatch = new Match(a, c, "Final",arbitre);
        // premierMatch.jouerMatch();

        // System.out.println("Score vainqueur ");

        // System.out.println(premierMatch.scoreJoueur0);
        // System.out.println("Score Perdant ");

        // System.out.println(premierMatch.scoreJoueur1);
        // System.out.println("Vainqueur");
        // System.out.println(premierMatch.vainqueurMatch.nomNaissance);
        // Jeu jeu = new Jeu(a,c,arbitre);
        // jeu.jouerJeu();
        //atp.afficherClassement();
        //atp.updateClassement();
        //System.out.println("------------------");
        //atp.afficherClassement();



        

        


    }

}
