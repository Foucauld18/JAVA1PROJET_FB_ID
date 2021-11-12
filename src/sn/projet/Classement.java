package sn.projet;

public  class Classement {
    protected String nom;
    protected Joueur [] joueurs;
    protected int nbPoints;
    protected int position;
    protected int ancienete;
    

    /*Builder*/
    
    public Classement (String nom){
        this.nom=nom;
    }

}
