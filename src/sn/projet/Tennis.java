/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;




/**
 *
 * @author Ibrahima
 */
public class Tennis {
 
    public static void main(String[] args) {
        
        Joueur numero1 = new Joueur(1,"Bergerault");
        Joueur numero2 = new Joueur(2,"LJ");
        

        Match premierMatch = new Match("homme",numero1,numero2,"Final");
        premierMatch.jouerMatch();

        Echange test = new Echange(numero1,numero2);
        test.jouerEchange();

        Jeu premierJeu = new Jeu(numero1,numero2);
        premierJeu.jouerJeu();

        Set premierSet= new Set(numero1,numero2);
        premierSet.jouerSet();


        System.out.println("Probas Premier Service ");

        System.out.println(test.aleatoire);

        System.out.println("Probas Deuxième service ");

        System.out.println(test.aleatoire2);
        
        System.out.println("Vainquer echange ");

        System.out.println(test.vainqueurEchange.nomNaissance);

        System.out.println("_______________________________________________________________ ");
        System.out.println("Score vainqueur ");

        System.out.println(premierMatch.scoreJoueur1);
        System.out.println("Score Perdant ");

        System.out.println(premierMatch.scoreJoueur2);
        System.out.println("Vainqueur");

        System.out.println(premierMatch.vainqueurMatch.nomNaissance);
        
    }
    
    
    
    
}

    


