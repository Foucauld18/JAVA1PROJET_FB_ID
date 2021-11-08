/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.util.Date;

/**
 *
 * @author Ibrahima
 */
public class Spectateur extends Personne {
    protected String vetement;
    protected String couleur;
    protected Billet billet;
    
     public Spectateur(String nomNaissance, String nomCourant, String prenom,
                    String surnom, Date dateNaissance, String lieuNaissance,
                    Date dateDeces, String nationalite, int taille, int poids,
                    String vetement, String couleur){
        
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        this.vetement = vetement;
        this.couleur = couleur;
    
    }
     
     public String getVetement() {
        return this.vetement;
    }
     
     public String getCouleur() {
        return this.couleur;
    }
     
    public Billet getBillet(){
        return this.billet;
    }
    
    public void setVetement(String vetement) {
        this.vetement = vetement;
    }
     
   public void setCouleur(String couleur) {
        this.couleur = couleur; 
    }
   
   public void acheterBillet(int prix, String tribune, int place){
        this.billet = new Billet(prix, tribune, place);
    }
   
   public void applaudir(){
        System.out.println("CLAP CLAP CLAP");
    }
   
    public void crier(){
        System.out.println("ALLEZ !!!");
    }
    
    public void huer(){
        System.out.println("BOOOOOOOOOOO !!!! NUL !");
    }
    
    
   
}


