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


        System.out.println("Le vainqueur est : ");

        System.out.println(premierMatch.vainqueurMatch);

        System.out.println("Le score du gagnant est de  ");

        System.out.println(premierMatch.scoreJoueur1);
        
        System.out.println("Le score du perdant est de  ");

        System.out.println(premierMatch.scoreJoueur2);
        
    }
    
    
    
    
}

    


