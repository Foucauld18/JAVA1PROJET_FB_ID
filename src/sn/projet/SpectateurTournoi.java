/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.time.LocalDate;

/**
 *
 * @author Ibrahima
 */
public class SpectateurTournoi extends Personne implements SpectatorInterface{
    
    protected Billet [] billet;
    protected Vetement vetement;
    protected Couleur couleur;

    /*
    Constructeur Spectateur qui désigne UNE SPECTATRICE
    */

    public SpectateurTournoi(String nomNaissance, String nomCourant, String prenom,
            String surnom, LocalDate dateNaissance, String lieuNaissance,
            LocalDate dateDeces, String nationalite, int taille, int poids) {

        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance,
                lieuNaissance, dateDeces, nationalite, taille, poids);
        

    }

    /*
    Constructeur Spectateur qui désigne UN SPECTATEUR
    */

    public SpectateurTournoi(String nomNaissance, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
            LocalDate dateDeces, String nationalite, int taille, int poids) {

        super(nomNaissance, prenom, surnom, dateNaissance,
                lieuNaissance, dateDeces, nationalite, taille, poids);
        

    }
    
        
    
    public Vetement getVetement() 
    { 
        return this.vetement;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }
    /*
    public Billet getBillet() {
        return this.billet;
    }*/

    public void setVetement(Vetement vetement) {
        this.vetement = vetement;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    /*
    public void acheterBillet(int prix, String tribune, int place) {
        this.billet = new Billet(prix, tribune, place);
    }*/

    public void applaudir() 
    {
        System.out.println("CLAP CLAP CLAP !!!!!!!!");
    }

    public void crier() 
    {
        System.out.println("ALLEZ !!!");
    }

    public void huer() 
    {
        System.out.println("ouuuuuuuuuuuuuuuuuuuuhhhhhhhhhhhh !!!!! ");
    }

    public void dormir() 
    {
        System.out.println("Bonne nuit ............");
    }
    
}
