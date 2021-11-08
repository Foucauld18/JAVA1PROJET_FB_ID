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
public class Personne {
    protected String nomNaissance, genre, dateNaissance, lieuNaissance, dateDeces;
    String nomCourant, prenom, surnom, nationalite, jour, mois;
    int taille, poids;
    protected String annee;
    
    /**
    Création d'un constructeur Personne 
    * ne contenant pas la variable nomCourant
    */
    public Personne(String nomNaissance, String prenom, String surnom, String genre, String dateNaissance, String dateDeces, String lieuNaissance, String nationalite, int poids, int taille, String jour, String mois, String annee ){
        this.annee = annee;
        this.nomNaissance = nomNaissance;
        this.dateDeces = jour + "/" + mois + "/" + annee;
        this.dateNaissance = jour + "/" + mois + "/" + annee;
        this.genre = genre;
        this.nationalite = nationalite;
        this.poids = poids; //en kg
        this.surnom = surnom;
        this.taille = taille; // en cm
        this.prenom = prenom;
        this.lieuNaissance = lieuNaissance;
        
    }
    
    /**
    Création d'un constructeur Personne 
    * contenant la variable nomCourant
    */
    public Personne(String nomNaissance, String nomCourant, String prenom, String surnom, String genre, String dateNaissance, String dateDeces, String lieuNaissance, String nationalite, int poids, int taille, String jour, String mois, String annee ){
        this.annee = annee;
        this.nomNaissance = nomNaissance;
        this.dateDeces = jour + "/" + mois + "/" + annee;
        this.dateNaissance = jour + "/" + mois + "/" + annee;
        this.genre = genre;
        this.nationalite = nationalite;
        this.poids = poids;
        this.surnom = surnom;
        this.taille = taille;
        this.prenom = prenom;
        this.lieuNaissance = lieuNaissance;
        this.nomCourant = nomCourant;
    }
    
    //Creation des getters et setters
    
    
    //Creation de la fonction pour l'age
    public void getAge(){
            int year = Integer.parseInt(annee);
            int age = 2021 - year;
            System.out.println(age);
            
        }
    
    
   
}
