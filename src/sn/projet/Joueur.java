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
public class Joueur extends Personne implements SpectatorInterface{
    
    protected Main main;
    protected String sponsor;
    protected int classement;
    protected int nbPointsClassement;
    protected String entraineur;
    public Object vetement;
    protected int nbLitigesTotal;
    protected Couleur couleur;
    protected StatistiquesPersonnellesJoueur statJoueur;
    public static int nbJoueur = 0; // Compte le nombre de joueur
    /*
    Constructeur Joueur qui désigne un JOUEUR
    */
    public Joueur   (String nomNaissance, String prenom,
                    String surnom, LocalDate dateNaissance, String lieuNaissance,
                    LocalDate dateDeces, String nationalite, int taille, int poids,
                    Main main, String sponsor, String entraineur, int nbPointsClassement){
        super(nomNaissance, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        this.main = main;
        this.sponsor = sponsor;
        this.classement = nbJoueur + 1;
        this.entraineur = entraineur;
        this.nbPointsClassement=nbPointsClassement;
        this.nbLitigesTotal=0;
      
        

        
        nbJoueur ++;
    }

    public void ajouterStatJoueur(){
        StatistiquesPersonnellesJoueur statJoueur = new StatistiquesPersonnellesJoueur();
          
        this.statJoueur=statJoueur;
    }
    
    /*
    Constructeur joueur qui désigne une JOUEUSE 
    */
    public Joueur(String nomNaissance, String nomCourant, String prenom,
                    String surnom, LocalDate dateNaissance, String lieuNaissance,
                    LocalDate dateDeces, String nationalite, int taille, int poids,
                    Main main, String sponsor, String entraineur, 
                    Vetement vetement, Couleur couleur, int nbPointsClassement){
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        
        this.main = main;
        this.sponsor = sponsor;
        this.classement = nbJoueur + 1;
        this.entraineur = entraineur;
        this.nbPointsClassement=nbPointsClassement;
        
        
        
        nbJoueur ++;
        
    }
    
    /*
    Creation des getters et des setters
    */
    
    
    public Main getMain(){return this.main;}

    public int getNbPoints(){return this.nbPointsClassement;};

    public void setNbPoints(int nbPoints){
        this.nbPointsClassement=nbPoints;
    }


    
    public Vetement getVetement() 
    { 
        return (Vetement) this.vetement;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }
    /*
    public Billet getBillet() {
        return this.billet;
    }*/

    public void setVetement(Vetement vetement) {
        this.vetement = vetement;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    /*
    public void acheterBillet(int prix, String tribune, int place) {
        this.billet = new Billet(prix, tribune, place);
    }*/

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
