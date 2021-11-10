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
        Spectateur b = new Spectateur("DIALLO", "Ba", "Ibahima", "The Goat", LocalDate.of(1999, 9, 4), "Dakar",
                LocalDate.of(2050, 4, 9), "Senegalaise", 180, 70, "Short", "Rouge");

        Joueur a = new Joueur("Diallo", "Ba", "Ibrahima", "The goat", LocalDate.of(1999, 9, 4), "Metz",
                LocalDate.of(2035, 1, 5), "Senegalaise", 180, 70, Main.Droite, "Tropico", "Poutine", Vetement.Chemise,
                Couleur.Bleu);

        Joueur c = new Joueur("Bergerault", "FB", "Foucauld", "The goat", LocalDate.of(1999, 9, 4), "Metz",
                LocalDate.of(2035, 1, 5), "Francaise", 180, 70, Main.Droite, "Tropico", "Poutine", Vetement.Chemise,
                Couleur.Bleu);

        Match premierMatch = new Match("homme", a, c, "Final");
        premierMatch.jouerMatch();

        System.out.println("Score vainqueur ");

        System.out.println(premierMatch.scoreJoueur1);
        System.out.println("Score Perdant ");

        System.out.println(premierMatch.scoreJoueur2);
        System.out.println("Vainqueur");

        System.out.println(premierMatch.vainqueurMatch.nomNaissance);

    }

}
