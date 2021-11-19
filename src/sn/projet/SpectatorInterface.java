package sn.projet;

public interface SpectatorInterface
{

    public Vetement getVetement();

    public Couleur getCouleur();

    /*public Billet getBillet();*/

    public void setVetement(Vetement vetement); 

    public void setCouleur(Couleur couleur);

    /*public void acheterBillet(int prix, String tribune, int place);*/

    public void applaudir();

    public void crier();

    public void huer();

    public void dormir();
    

}
