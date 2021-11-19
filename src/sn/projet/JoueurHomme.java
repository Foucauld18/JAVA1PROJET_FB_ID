package sn.projet;

import java.time.LocalDate;

public class JoueurHomme extends Joueur{

    protected Vetement vetement;
    protected Couleur couleur;

    public JoueurHomme(String nomNaissance, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
            LocalDate dateDeces, String nationalite, int taille, int poids, Main main, String sponsor,
            String entraineur, int nbPointsClassement) {
        super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids, main, sponsor,
                entraineur, nbPointsClassement);

                this.vetement = vetement.Chemise;
                this.couleur = couleur.Vert;
                this.main = main;
                this.sponsor = sponsor;
                this.classement = nbJoueur + 1;
                this.entraineur = entraineur;
                this.nbPointsClassement=nbPointsClassement;
                nbJoueur ++;
        
    }

    public Vetement getVetement() { return this.vetement;}

    public Couleur getCouleur() {
        return this.couleur;
    }

   
    
}
