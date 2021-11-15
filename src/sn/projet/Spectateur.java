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
public class Spectateur extends SpectateurTournoi {
    
    protected Vetement vetement;
    protected Couleur couleur;

    public Spectateur(String nomNaissance, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
    LocalDate dateDeces, String nationalite, int taille, int poids, Couleur couleur){
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids);
        
        this.vetement = vetement.Chemise;
    }

    public Vetement getVetement() { return this.vetement;}

    public Couleur getCouleur() {
        return this.couleur;
    }

    
    
    
    
   
}


