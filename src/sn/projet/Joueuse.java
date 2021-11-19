package sn.projet;

import java.time.LocalDate;

public class Joueuse extends Joueur implements SpectatorInterface{

    protected Vetement vetement;
    protected Couleur couleur;

    public Joueuse(String nomNaissance, String nomCourrant, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance, String nationalite, int taille, int poids, Main main, String sponsor,
            String entraineur,Couleur couleur) {
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, main, sponsor,
                entraineur);
        

                this.vetement = Vetement.Jupe;
                this.couleur = couleur;
                this.nomCourant=nomCourrant;
             
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
    
}
