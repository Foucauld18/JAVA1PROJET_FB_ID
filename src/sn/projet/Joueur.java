/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;


public class Joueur extends Personne{
    int classement;
    public static int nbjoueur=0;
    public Joueur(int classement,String nomNaissance){
        super( nomNaissance);
        nbjoueur++;
        this.classement = classement;
    }
}

