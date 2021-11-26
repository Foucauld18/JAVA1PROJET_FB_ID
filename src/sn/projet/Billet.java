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
    protected String titulaire;
    protected Match match;
     // Compte le nombre de billet vendu
     /**
      * 
      * @param prix
      * @param tribune
      * @param place
      * @param match
      */
    
    public Billet(int prix, String tribune, int place,Match match){
        this.prix = prix;
        this.tribune = tribune;
        this.place = place;
        this.titulaire=null;
        this.match = match;
    }
    


    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getTribune() {
        return this.tribune;
    }

    public void setTribune(String tribune) {
        this.tribune = tribune;
    }

    public int getPlace() {
        return this.place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getTitulaire() {
        return this.titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public Match getMatch() {
        return this.match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
    
    
}
