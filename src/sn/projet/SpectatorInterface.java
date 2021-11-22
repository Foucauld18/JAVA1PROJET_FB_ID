package sn.projet;

public interface SpectatorInterface
{

    public void ajouterUnBillet(Billet billet);

    public Vetement getVetement();

    public Couleur getCouleur();

    /*public Billet getBillet();*/

    public void setVetement(Vetement vetement); 

    public void setCouleur(Couleur couleur);

    /*public void acheterBillet(int prix, String tribune, int place);*/

    public void applaudir(boolean cacher);

    public void crier(boolean cacher);
    public void repondreAuCri(boolean cacher);
    

}
