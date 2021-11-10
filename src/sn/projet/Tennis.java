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
        premierMatch.SetResultat(numero2);

        Echange test = new Echange(numero1,numero2);
        test.jouerEchange();

        Jeu premierJeu = new Jeu(numero1,numero2);
        premierJeu.jouerJeu();

        System.out.println("Le vainqueur est : ");

        System.out.println(premierJeu.jouerJeu().nomNaissance);
        
        System.out.println("Le score du perdant est de  ");

        System.out.println(premierJeu.scoreJoueur2);
        
    }
    
    
    
    
}

    


