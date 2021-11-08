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
public class JoueurTennis extends Personne{
   
    private int classement = 0;
    private String entraineur, sponsor;
    private boolean main;
    
    
    public JoueurTennis(int classement, String entraineur, String sponsor, String nomNaissance, String prenom, String surnom, String genre, String dateNaissance, String dateDeces, String lieuNaissance, String nationalite, int poids, int taille, String jour, String mois, String annee){
        super(nomNaissance, prenom, surnom, genre, dateNaissance, dateDeces, lieuNaissance,nationalite, poids, taille, jour, mois, annee);
        this.classement = classement;
        this.entraineur = entraineur;
        this.sponsor = sponsor;   
    }
    
    public int getClassement(){return this.classement;}
    
    public int setClassement(){return this.classement++;}
}
