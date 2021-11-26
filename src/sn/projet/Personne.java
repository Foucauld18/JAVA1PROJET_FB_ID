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
public abstract class Personne {

    protected String nomNaissance;
    protected String nomCourant;
    protected String prenom;
    protected String surnom;
    protected LocalDate dateNaissance;
    protected String lieuNaissance;
    protected LocalDate dateDeces;
    protected String nationalite;
    protected int taille;
    protected int poids;

    /**
     * Création d'un constructeur Personne contenant la variable nomCourant qui
     * désigne si un personnage féminin est mariée ou non
     *
     * 
     */
    public Personne() {
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
        this.surnom = surnom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.dateDeces = null;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
    }

    /**
     * Création d'un constructeur Personne ne contenant pas la variable
     * nomCourant
     *
     * @param nomNaissance
     * @param prenom
     * @param surnom
     * @param dateNaissance
     * @param lieuNaissance
     * @param dateDeces
     * @param nationalite
     * @param taille
     * @param poids
     */
    public Personne(String nomNaissance, String prenom,
            String surnom, LocalDate dateNaissance, String lieuNaissance,
            LocalDate dateDeces, String nationalite, int taille, int poids) {
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
        this.surnom = surnom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.dateDeces = dateDeces;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
    }

    //Creation des getters et setters
    public String getNomNaissance() {
        return this.nomNaissance;
    }

    public String getNomCourant() {
        return this.nomCourant;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getSurnom() {
        return this.surnom;
    }

    public LocalDate getDateNaissance() {
        return this.dateNaissance;
    }

    public String getLieuNaissance() {
        return this.lieuNaissance;
    }

    public LocalDate getDateDeces() {
        return this.dateDeces;
    }

    public String getNationalite() {
        return this.nationalite;
    }

    public int getTaille() {
        return this.taille;
    }

    public int getPoids() {
        return this.poids;
    }

    /**
     * @param nomNaissance the nomNaissance to set
     */
    public void setNomNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }

    /**
     * @param nomCourant the nomCourant to set
     */
    public void setNomCourant(String nomCourant) {
        this.nomCourant = nomCourant;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @param surnom the surnom to set
     */
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @param lieuNaissance the lieuNaissance to set
     */
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * @param dateDeces the dateDeces to set
     */
    public void setDateDeces(LocalDate dateDeces) {
        this.dateDeces = dateDeces;
    }

    /**
     * @param nationalite the nationalite to set
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * @param taille the taille to set
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * @param poids the poids to set
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    // Méthode pour avoir l'age
    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - this.getDateNaissance().getYear();
        return age;
    }

}
