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
        rolandgarros.ajouterJoueurHomme(monfils);
        System.out.println(rolandgarros.getJoueurHommes());
        // for(int i=0;i<12;i++){
        //     System.out.println(rolandgarros.getJoueurHommes()[i].nomCourant);
        // }
        rolandgarros.afficherJoueurs();
        //System.out.println(rolandgarros.getJoueurHommes());


       


        

        


    }

}
