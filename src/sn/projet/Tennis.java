/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Ibrahima
 */
public class Tennis {

        
    public static void main(String[] args) {
       
        
        JoueurHomme monfils = new JoueurHomme("Monfils", "Gael", "gab", LocalDate.of(1995, 1, 5),"Paris", "Français", 180, 70, Main.Droite, "Nike", "Amelie", Couleur.Bleu);
        JoueurHomme tsonga = new JoueurHomme("Tsonga", "Joe Wilfrid", "Joe", LocalDate.of(1994, 1, 5),"Paris",  "Français", 180, 70, Main.Droite, "Nike", "Amelie", Couleur.Vert);
        Joueuse serena = new Joueuse("anjndsi", "Williams","Serena", "sw", LocalDate.of(1994, 1, 5), "New-york","Américaine", 170, 69, Main.Gauche, "Adidas", "dad", Couleur.Marron);
        Joueuse venus = new Joueuse("anjndsi", "Williams","Venus", "sw", LocalDate.of(1994, 1, 5), "New-york","Américaine", 170, 69, Main.Gauche, "Adidas", "dad", Couleur.Rose);
        Arbitre arbitre = new Arbitre("Bergerault", "Foucauld", "The goat", LocalDate.of(1999, 9, 4), "Metz", "Francaise", 180, 70);

       

        
        monfils.ajouterStatJoueur();
        tsonga.ajouterStatJoueur();
        Tournoi rolandgarros = new Tournoi("Paris","Terre Battue","2021");

        for(int i=0;i<128;i++){
            JoueurHomme joueur1 = new JoueurHomme("Monfils"+String.valueOf(i), "Gael", "gab", LocalDate.of(1995, 1, 5),"Paris", "Français", i, 70, Main.Droite, "Nike", "Amelie", Couleur.Bleu);
            Joueuse joueuse1 = new Joueuse("anjndsi", "Williams","Serena", "sw", LocalDate.of(1994, 1, 5), "New-york","Américaine", i, 69, Main.Gauche, "Adidas", "dad", Couleur.Marron);
            Classement.ATP.ajouterJoueurClassement(joueur1);
            Classement.WTA.ajouterJoueurClassement(joueuse1);
            joueur1.ajouterStatJoueur();
            joueuse1.ajouterStatJoueur();
            rolandgarros.ajouterJoueurHomme(joueur1);
            rolandgarros.ajouterJoueuse(joueuse1);
        }
        for(int i=0;i<16;i++){
            Arbitre arbitre1 = new Arbitre("Bergerault", "Foucauld", "The goat", LocalDate.of(1999, 9, 4), "Metz", "Francaise", i, 70);
            rolandgarros.ajouterArbitre(arbitre1);
        }

        rolandgarros.jouerTournois(true, true);
        rolandgarros.afficherMatchTournoi();
        System.out.println("Vainqueur "+rolandgarros.gagnant.getNomCourant()+" vainqueuse "+rolandgarros.getGagnante().getNomCourant());
        Classement.ATP.afficherClassement();
        System.out.println("Classement Vainqueur ");
        System.out.println(Classement.ATP.obtenirClassementJoueur(rolandgarros.gagnant));
        
        

        

       


        

        


    }

}
