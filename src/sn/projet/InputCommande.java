package sn.projet;
import java.util.Scanner;

public class InputCommande {
    boolean affichage;
    String commande;
 
    /*Consructor*/
    public InputCommande(){
        this.commande=null;
        this.affichage=false;
    }

    /*Methods*/


    public boolean isAffichage() {
        return this.affichage;
    }

    public boolean getAffichage() {
        return this.affichage;
    }

    public void setAffichage(boolean affichage) {
        this.affichage = affichage;
    }

    public String getCommande() {
        return this.commande;
    }

    public void setCommande() {
        String commande ="";
        Scanner keyboard = new Scanner (System.in);
        commande = keyboard.nextLine();
        this.commande = commande;
    }



}

