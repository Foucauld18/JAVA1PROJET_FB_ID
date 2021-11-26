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
public class Spectatrice extends SpectateurTournoi {

    protected Vetement vetement;
    protected Couleur couleur;
    /**
     * 
     * @param nomNaissance
     * @param nomCourant
     * @param prenom
     * @param surnom
     * @param dateNaissance
     * @param lieuNaissance
     * @param nationalite
     * @param taille
     * @param poids
     * @param couleur
     */

    public Spectatrice (String nomNaissance, String nomCourant, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
     String nationalite, int taille, int poids, Couleur couleur){
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids);
        this.couleur=couleur;
        this.vetement = vetement.Lunette;
        this.nomNaissance=nomCourant;
        
    }

    public Vetement getVetement() { return this.vetement;}

    public Couleur getCouleur() {
        return this.couleur;
    }
    
}
