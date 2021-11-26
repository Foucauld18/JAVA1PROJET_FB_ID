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
     * @param main
     * @param sponsor
     * @param entraineur
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
    /**
     * Permet d'initialiser les stats d'un joueur
     */

    public void ajouterStatJoueur(){
        if(this.statJoueur==null){
            StatistiquesPersonnellesJoueur statJoueur = new StatistiquesPersonnellesJoueur();
          
            this.statJoueur=statJoueur;
        }//sinon les stats existe déjà.
       
    }
    
   
    
    
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
    /**
     * Affiche toutes les informations du joueurs
     * @param classement atp ou WTA
     */
    public void afficherInformationsJoueur(int classement){
        if(this.nomNaissance.equals("Inconnu Homme")||this.nomNaissance.equals("Inconnu Femme")){
            System.out.println("Ce joueur n'existe pas!");
        } else{
            System.out.println("|Nom de Naissance: "+getNomNaissance());
            System.out.println("|Prénom: "+getPrenom());
            System.out.println("|Surnom: "+getSurnom());
            System.out.println("|Age: "+getAge()+" ans");
            System.out.println("|Entraineur: "+this.entraineur);
            System.out.println("|Classement: "+classement +" mondiale");
            System.out.println("|Nombre de points au classement: "+getNbPoints());
            System.out.println("|Nationalité: "+getNationalite());
            System.out.println("|Taille: "+getTaille()+" cm");
            System.out.println("|Poids: "+getPoids()+"kg");
            System.out.println("|Sponsor(s): "+this.sponsor);
            System.out.println("|Main: "+getMain());
            System.out.println("|Date de naissance: "+getDateNaissance());
            System.out.println("|Lieu de naissance: "+getLieuNaissance());
        }
        
        
    }

    
}
