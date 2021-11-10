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
public class Joueur extends Personne{
    
    protected String main;
    protected String sponsor;
    protected int classement;
    protected String entraineur;
    
    protected String vetement;
    protected String couleur;
    
    public static int nbJoueur = 0; // Compte le nombre de joueur
    
    public Joueur   (String nomNaissance, String nomCourant, String prenom,
                    String surnom, LocalDate dateNaissance, String lieuNaissance,
                    LocalDate dateDeces, String nationalite, int taille, int poids,
                    String main, String sponsor, String entraineur, 
                    String vetement, String couleur){
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        this.main = main;
        this.sponsor = sponsor;
        this.classement = nbJoueur + 1;
        this.entraineur = entraineur;
        
        this.vetement = vetement;
        this.couleur = couleur;
        
        nbJoueur ++;
    }
    
    
}
