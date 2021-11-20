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
       
        
        JoueurHomme monfils = new JoueurHomme("Monfils", "Gael", "gab", LocalDate.of(1995, 1, 5),"Paris", "Français", 180, 70, Main.Droite, "Nike", "Amelie", Couleur.Bleu);
        JoueurHomme tsonga = new JoueurHomme("Tsonga", "Joe Wilfrid", "Joe", LocalDate.of(1994, 1, 5),"Paris",  "Français", 180, 70, Main.Droite, "Nike", "Amelie", Couleur.Vert);
        Joueuse serena = new Joueuse("anjndsi", "Williams","Serena", "sw", LocalDate.of(1994, 1, 5), "New-york","Américaine", 170, 69, Main.Gauche, "Adidas", "dad", Couleur.Marron);
        Joueuse venus = new Joueuse("anjndsi", "Williams","Venus", "sw", LocalDate.of(1994, 1, 5), "New-york","Américaine", 170, 69, Main.Gauche, "Adidas", "dad", Couleur.Rose);
        Arbitre arbitre = new Arbitre("Bergerault", "Foucauld", "The goat", LocalDate.of(1999, 9, 4), "Metz", "Francaise", 180, 70);



        
        Classement.ATP.ajouterJoueurClassement(monfils);
        Classement.ATP.ajouterJoueurClassement(tsonga);
        Classement.WTA.ajouterJoueurClassement(serena);
        Classement.WTA.ajouterJoueurClassement(venus);
        monfils.ajouterStatJoueur();
        tsonga.ajouterStatJoueur();


        StatistiquesPersonnellesJoueur test = new StatistiquesPersonnellesJoueur();
        System.out.println(monfils.statJoueur.nbDoubleFautes);



        Match premierMatch = new Match(monfils, tsonga,NiveauMatch.Final,arbitre);
        premierMatch.jouerMatch();

        System.out.println("Score "+premierMatch.joueurs[0].nomCourant+" "+premierMatch.scoreJoueur0+ " nb jeux service Gagnant "+premierMatch.joueurs[0].statJoueur.getJeuServiceGagne());


        System.out.println("    -");
        System.out.println("Score "+premierMatch.joueurs[1].nomCourant+" "+premierMatch.scoreJoueur1+ " nb jeux service Gagnant "+premierMatch.joueurs[1].statJoueur.getJeuServiceGagne());

        System.out.println();
        System.out.println("Le Vainqueur est "+premierMatch.vainqueurMatch.nomCourant );
        
        
        Classement.ATP.afficherClassement();
        Classement.ATP.updateClassement();
        System.out.println("------------------");
        Classement.ATP.afficherClassement();
        System.out.println("Stat monfils");
        monfils.statJoueur.afficherStat();
        System.out.println("Stat tsonga");
        tsonga.statJoueur.afficherStat();
        System.out.println("Stat Match");
        premierMatch.statistiques[2].afficherStat();
        System.out.println("Stat Match a");
        premierMatch.statistiques[0].afficherStat();
        System.out.println("Stat Match c");
        premierMatch.statistiques[1].afficherStat();
        System.out.println(premierMatch.categorie);




        

        


    }

}
