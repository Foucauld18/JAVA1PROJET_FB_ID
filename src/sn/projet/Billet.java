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
class Billet {
    protected int prix;
    protected String tribune;
    protected int place;
    
    public static int nbBillet = 0; // Compte le nombre de billet vendu
    
    public Billet(int prix, String tribune, int place){
        this.prix = prix;
        this.tribune = tribune;
        this.place = place;
        
        nbBillet++;
    }
    
    
    public int getPrix() {
        return this.prix;
    }

    
    public String getTribune() {
        return this.tribune;
    }

    
    public int getPlace() {
        return this.place;
    }
}
