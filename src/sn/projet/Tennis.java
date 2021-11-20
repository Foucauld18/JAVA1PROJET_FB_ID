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

        InputCommande testCommande = new InputCommande();

        
        monfils.ajouterStatJoueur();
        tsonga.ajouterStatJoueur();

        boolean recommencer=true;
        while(recommencer==true){
            Match premierMatch = new Match(monfils, tsonga,NiveauMatch.Final,arbitre);
            premierMatch.jouerMatch(false);
            System.out.println("Recommencer un match? ou taper fin");
            String commande = "";
            Scanner keyboard = new Scanner(System.in);
                commande = keyboard.nextLine();
                if (commande.equals("fin")) {
                    recommencer=false;
                } 
        }

       


        

        


    }

}
