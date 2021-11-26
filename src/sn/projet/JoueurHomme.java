package sn.projet;

import java.time.LocalDate;

public class JoueurHomme extends Joueur implements SpectatorInterface{

    protected Vetement vetement;
    protected Couleur couleur;
    /**
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
     * @param main
     * @param sponsor
     * @param entraineur
     * @param nbPointsClassement
     * @param couleur
     */

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
      * @param couleur
      */
    public JoueurHomme(String nomNaissance, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
             String nationalite, int taille, int poids, Main main, String sponsor,
            String entraineur,Couleur couleur) {
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, main, sponsor,
                entraineur);

                this.vetement = Vetement.Short;
                this.couleur = couleur;
                this.nomCourant=nomNaissance;
                  
        
    }

    public Vetement getVetement() { return this.vetement;}

    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public void setVetement(Vetement vetement) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setCouleur(Couleur couleur) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void applaudir(boolean cacher) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void crier(boolean cacher) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void repondreAuCri(boolean cacher) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ajouterUnBillet(Billet billet) {
        // TODO Auto-generated method stub
        
    }
    /**
     * Affiche toutes les informations du joueur
     * @param classement
     */

    public void afficherInformationsJoueurHomme(int classement){
        System.out.println("|Nom courrant: "+getNomCourant());
        afficherInformationsJoueur(classement);
        System.out.println("|Couleur du short: "+getVetement());  

    }

    

   
    
}
