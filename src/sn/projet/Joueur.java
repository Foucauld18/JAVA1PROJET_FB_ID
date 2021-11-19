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
public class Joueur extends Personne {
    
    protected Main main;
    protected String sponsor;
    protected int classement;
    protected int nbPointsClassement;
    protected String entraineur;
    protected int nbLitigesTotal;
    protected StatistiquesPersonnellesJoueur statJoueur;
    public static int nbJoueur = 0; // Compte le nombre de joueur
    /*
    Constructeur Joueur qui désigne un JOUEUR
    */
    public Joueur   (String nomNaissance, String prenom,
                    String surnom, LocalDate dateNaissance, String lieuNaissance,
                    String nationalite, int taille, int poids,
                    Main main, String sponsor, String entraineur){
        
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance,nationalite, taille, poids);
        this.main = main;
        this.sponsor = sponsor;
        this.classement = nbJoueur + 1;
        this.entraineur = entraineur;
        this.statJoueur=null;
    }

    public void ajouterStatJoueur(){
        StatistiquesPersonnellesJoueur statJoueur = new StatistiquesPersonnellesJoueur();
          
        this.statJoueur=statJoueur;
    }
    
    /*
    Constructeur joueur qui désigne une JOUEUSE 

    }
    
    /*
    Creation des getters et des setters
    */
    
    
    public Main getMain(){return this.main;}

    public int getNbPoints(){return this.nbPointsClassement;};

    public void setNbPoints(int nbPoints){
        this.nbPointsClassement=nbPoints;
    }
    public void applaudir() {
        System.out.println("CLAP CLAP CLAP !!!!!!!!");
    }

    public void crier() {
        System.out.println("ALLEZ !!!");
    }

    public void huer() {
        System.out.println("ouuuuuuuuuuuuuuuuuuuuhhhhhhhhhhhh !!!!! ");
    }

    public void dormir() {
        System.out.println("Bonne nuit ............");
    }
    

    public boolean demanderUneFaute(){//litige
        
        return(true);
    }

    
}
