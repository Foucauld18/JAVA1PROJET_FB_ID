package sn.projet;

public class Classement {
    protected String nom;
    protected Joueur[] joueurs;

    /* Builder */

    public Classement(String nom) {
        this.nom = nom;
        this.joueurs = null;
    }

    /* Method */

    protected void ajouterJoueurClassement(Joueur joueur) {
        Joueur[] classementActuel = this.joueurs;
        joueur.setNbPoints(0);// Nouveau joueurs à 0 point dans le classement
        int SizeArray = 0, i;
        try {
            SizeArray = classementActuel.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        Joueur[] newClassement = new Joueur[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newClassement[i] = classementActuel[i];
            classementActuel[i].setNbPoints(classementActuel[i].getNbPoints() + 1);// Ajoute un point à tous les joueurs
                                                                                   // prsent dans
            // le classement pour que le dernier joueurs ajouté sur le classement soit le
            // dernier du classement
        }
        newClassement[SizeArray] = joueur;
        this.joueurs = newClassement;

    }

    protected void afficherClassement() {
        Joueur[] classement = this.joueurs;
        int SizeArray = 0, i;

        try {
            SizeArray = classement.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        for (i = 0; i < SizeArray; i++) {
            System.out.println(classement[i].nomCourant + " " + classement[i].nbPointsClassement + " points");
        }
    }

    protected void updateClassement() {
        Joueur[] classement = this.joueurs;
        int sizeArray = 0;

        try {
            sizeArray = classement.length;
        } catch (Exception e) {
            sizeArray = 0;
        }
        System.out.println(sizeArray);
        for (int i = 1; i < sizeArray; i++) {
            Joueur cle = classement[i];
            int j = i - 1;
            while (j >= 0 && classement[j].nbPointsClassement < cle.nbPointsClassement) {
                classement[j + 1] = classement[j];
                j--;
                classement[j + 1] = cle;
            }
        }
        this.joueurs = classement;
    }

}
