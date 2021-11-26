package sn.projet;



public class JoueurHomme extends Joueur{

    protected Vetement vetement;
    protected Couleur couleur;
    

    public JoueurHomme() {
        

                this.vetement = Vetement.Short;
                this.couleur = couleur;
                this.nomCourant=nomNaissance;    
        
    }

    public Vetement getVetement() { return this.vetement;}

    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public String getNomNaissance() {
        return this.nomNaissance;
    }
    

    public void setVetement(Vetement vetement) {
        // TODO Auto-generated method stub
        
    }

    public void setCouleur(Couleur couleur) {
        // TODO Auto-generated method stub
        
    }

    public void setNonNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }

   
//    String nomNaissance, String prenom, String surnom, LocalDate dateNaissance, String lieuNaissance,
//             String nationalite, int taille, int poids, Main main, String sponsor,
//            String entraineur,Couleur couleur
    
//    super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, main, sponsor,
//                entraineur);
}
