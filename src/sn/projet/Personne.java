/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;
import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author Ibrahima
 */
public abstract class Personne {
    protected String nomNaissance;
    protected String nomCourant;
    protected String prenom;
    protected String surnom;
    protected Date dateNaissance;
    protected String lieuNaissance;
    protected Date dateDeces;
    protected String nationalite;
    protected int taille;
    protected int poids;
    
    /**
    Création d'un constructeur Personne 
    * ne contenant pas la variable nomCourant
    */
    public Personne(String nomNaissance, String nomCourant, String prenom,
                    String surnom, Date dateNaissance, String lieuNaissance,
                    Date dateDeces, String nationalite, int taille, int poids){
        this.nomNaissance = nomNaissance;
        this.nomCourant = nomCourant;
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
    
    public String getNomNaissance() {return this.nomNaissance;}

    
    public String getNomCourant() {return this.nomCourant;}
    
    public String getPrenom() {return this.prenom;}
    
    public String getSurnom() {return this.surnom;}
    
    public Date getDateNaissance() {return this.dateNaissance;}
    
    
    public String getLieuNaissance() {return this.lieuNaissance;}

    public Date getDateDeces() {return this.dateDeces;}
    
    public String getNationalite() {return this.nationalite;}
    
    public int getTaille() {return this.taille;}
    
    public int getPoids() {return this.poids;}
    
    public int getAge(){
        LocalDate now = LocalDate.now();
        int age = now.getYear() - this.getDateNaissance().getYear();
        if(now.getMonthValue() - this.getDateNaissance().getMonth() < 0){age--;}
        else if(now.getMonthValue() - this.getDateNaissance().getMonth() == 0){
            if(now.getDayOfMonth() - this.getDateNaissance().getDay()< 0){age--;}
        }
        return age;
    }
    
    
    
    
   
}
