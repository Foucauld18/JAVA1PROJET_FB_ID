/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sn.projet;

import java.util.Scanner;

/**
 *
 * @author Foucauld
 */

public class Echange {
    protected Joueur[] joueurs;
    protected Joueur vainqueurEchange;
    protected Arbitre arbitre;

    /* builder */
    public Echange(Joueur serveur, Joueur joueur1, Arbitre arbitre) {

        this.joueurs = new Joueur[] { serveur, joueur1 };
        this.arbitre = arbitre;
    }

    /* Method */

    public Joueur jouerEchange(boolean echangeAutomatique) {
        if (echangeAutomatique == true) {
            double probaGagnerEchange = Math.random();
            double probaReussirPremierService = Math.random();// chiffre aléatoire entre 0.0 et 1.0

            if (probaReussirPremierService <= 0.6) {// 60% de chance de valider son premier service
                joueurs[0].statJoueur.setNbPremierService(joueurs[0].statJoueur.getNbPremierService() + 1);
                if (probaGagnerEchange < 0.6) {// Si le premier service passe le serveur à 60% de chance de gagner
                                               // l'echange
                    this.vainqueurEchange = joueurs[0];
                    joueurs[0].statJoueur.setNbTotalPointRemporte(joueurs[0].statJoueur.getNbTotalPointRemporte() + 1);
                    return (joueurs[0]);
                } else
                    this.vainqueurEchange = joueurs[1];
                joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte() + 1);
                return (joueurs[1]);

            } else if (probaReussirPremierService > 0.6 && probaReussirPremierService < 0.95) {// Deuxième service
                Double probaReussirDeuxiemeService = Math.random();

                if (probaReussirDeuxiemeService < 0.8) {// 80% de chance de reussir sont deuxième service car le joueur
                                                        // prendra moins de risque
                    joueurs[0].statJoueur.setNbSecondService(joueurs[0].statJoueur.getNbSecondService() + 1);
                    if (probaGagnerEchange < 0.5) {// le service sera moins puissant que le premier donc 50/50 le
                                                   // vainquer de l'échange
                        this.vainqueurEchange = joueurs[0];
                        joueurs[0].statJoueur
                                .setNbTotalPointRemporte(joueurs[0].statJoueur.getNbTotalPointRemporte() + 1);
                        return (joueurs[0]);
                    } else
                        this.vainqueurEchange = joueurs[1];
                    joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte() + 1);
                    return (joueurs[1]);

                } else
                    this.vainqueurEchange = joueurs[1];// Deuxième Service Non Réussi
                joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte() + 1);
                joueurs[0].statJoueur.setNbDoubleFautes(joueurs[0].statJoueur.getNbDoubleFautes() + 1);
                return (joueurs[1]);
            } else
                return (this.jouerEchange(true));// Late on recommence

        } else {
            boolean goodCommande = false;
            while (goodCommande == false) {
                System.out
                        .println("Jouer echange : taper le numéro qui correspond à l'action que vous voulez faire : ");
                System.out.println(
                        "1- Reussir premier servie | 2-Reussir deuxieme service | 3- Faire une double faute | autre Faire un ace");
                String commande = "";
                Scanner keyboard = new Scanner(System.in);
                commande = keyboard.nextLine();
                String affichage;
                switch (commande) {
                case "1":
                    joueurs[0].statJoueur.setNbPremierService(joueurs[0].statJoueur.getNbPremierService() + 1);
                    affichage = "Félicitations vous venez de réussir votre premier service, comment souhaiter vous finir l'echange?";

                    break;
                case "2":
                    joueurs[0].statJoueur.setNbSecondService(joueurs[0].statJoueur.getNbSecondService() + 1);
                    affichage = "Félicitations vous venez de réussir votre deuxieme service, comment souhaiter vous finir l'echange?";
                    break;
                case "3":
                    joueurs[0].statJoueur.setNbDoubleFautes(joueurs[0].statJoueur.getNbDoubleFautes() + 1);
                    joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte() + 1);
                    return (joueurs[1]);
                default:
                    joueurs[0].statJoueur.setNbPremierService(joueurs[0].statJoueur.getNbPremierService() + 1);
                    joueurs[0].statJoueur.setNbTotalPointRemporte(joueurs[0].statJoueur.getNbTotalPointRemporte() + 1);// faire
                                                                                                                       // un
                                                                                                                       // ace
                    return (joueurs[0]);
                }
                System.out.println(affichage);
                System.out.println("1-Gagner Echange | 2-Perdre Echange | Autre : Aleatoire");
                commande = keyboard.nextLine();
                switch (commande) {
                case "1":
                    joueurs[0].statJoueur.setNbTotalPointRemporte(joueurs[0].statJoueur.getNbTotalPointRemporte() + 1);
                    return (joueurs[0]);
                case "2":
                    joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte() + 1);
                    return (joueurs[1]);
                default:
                    double probaGagnerEchange = Math.random();
                    if (probaGagnerEchange < 0.5) {
                        joueurs[0].statJoueur
                                .setNbTotalPointRemporte(joueurs[0].statJoueur.getNbTotalPointRemporte() + 1);
                        return (joueurs[0]);
                    } else {
                        joueurs[1].statJoueur
                                .setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte() + 1);
                        return (joueurs[1]);
                    }
                }

            }
        }
        return vainqueurEchange;

    }
}
