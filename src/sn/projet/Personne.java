/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;
import java.time.LocalDate;


 /**
  * abstract
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
    Création d'un constructeur Personne 
    *contenant la variable nomCourant qui désigne si un 
    * personnage féminin est mariée ou non
     * @param nomNaissance
     * @param nomCourant
     * @param prenom
     * @param surnom
     * @param dateNaissance
     * @param lieuNaissance
     * 
     * @param nationalite
     * @param taille
     * @param poids
    */
    public Personne(String nomNaissance, String prenom,
                    String surnom, LocalDate dateNaissance, String lieuNaissance,
                    String nationalite, int taille, int poids){
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
    
   
    

    
    //Creation des getters et setters
    
    public String getNomNaissance() {return this.nomNaissance;}

    
    public String getNomCourant() {return this.nomCourant;}
    
    public String getPrenom() {return this.prenom;}
    
    public String getSurnom() {return this.surnom;}
    
    public LocalDate getDateNaissance() {return this.dateNaissance;}
    
    
    public String getLieuNaissance() {return this.lieuNaissance;}

    public LocalDate getDateDeces() {return this.dateDeces;}
    
    public String getNationalite() {return this.nationalite;}
    
    public int getTaille() {return this.taille;}
    
    public int getPoids() {return this.poids;}
    
    
    
    
    
    
    // Méthode pour avoir l'age
    public int getAge(){
        LocalDate now = LocalDate.now();
        int age = now.getYear() - this.getDateNaissance().getYear();
        return age;
    }
    
    
    
    
   
}
