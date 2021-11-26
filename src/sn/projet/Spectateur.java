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
    /**
     * 
     * @param nomNaissance
     * @param prenom
     * @param surnom
     * @param dateNaissance
     * @param lieuNaissance
     * @param nationalite
     * @param taille
     * @param poids
     * @param couleur
     */

    public Spectateur(String nomNaissance, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
    String nationalite, int taille, int poids, Couleur couleur){
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids);
        this.couleur=couleur;
        this.vetement = vetement.Chemise;
        this.nomCourant=nomNaissance;
    }

    public Vetement getVetement() { return this.vetement;}

    public Couleur getCouleur() {
        return this.couleur;
    }

    
}


