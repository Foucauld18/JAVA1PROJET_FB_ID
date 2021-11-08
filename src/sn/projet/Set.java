/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

/**
 *
 * @author Ibrahima
 */
public class Set {
    protected Arbitre [] arbitres;
    protected Joueur[] equipe1;
    protected Joueur[] equipe2;
    protected Spectateur[] spectateurs;
    
    public Set(Arbitre [] arbitres, Joueur [] equipe1, Joueur [] equipe2, Spectateur [] spectateurs){
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
    }
    
    
    
    
}
