/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.time.LocalDate;

/**
 *
 * @author Ibrahima
 */
public class SpectateurTournoi extends Personne implements SpectatorInterface{
    
    protected Billet [] billets;
    protected Vetement vetement;
    protected Couleur couleur;

    /*
    Constructeur 
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
     */

    public SpectateurTournoi(String nomNaissance, String prenom,
            String surnom, LocalDate dateNaissance, String lieuNaissance,
            String nationalite, int taille, int poids) {

        super(nomNaissance,  prenom, surnom, dateNaissance,
                lieuNaissance,  nationalite, taille, poids);
        

    }

  
    /**
     * Ajoute un billet dans la liste de billets du spéctateur
     */
    public void ajouterUnBillet(Billet billet) {
        Billet[] listeBillets = this.billets;
        int SizeArray = 0, i;
        try {
            SizeArray = listeBillets.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        Billet [] newListeBillets = new Billet[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newListeBillets[i] = listeBillets[i];
        }
        newListeBillets[SizeArray] = billet;
        this.billets = newListeBillets;
    }    
    
    public Vetement getVetement() 
    { 
        return this.vetement;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }
    /*
    public Billet getBillet() {
        return this.billet;
    }*/

    public void setVetement(Vetement vetement) {
        this.vetement = vetement;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    
    public void applaudir(boolean cacher) 
    {
        if(cacher==true){
            System.out.println("CLAP CLAP CLAP !!!!!!!!");
        }
        
    }

    public void crier(boolean cacher) 
    {
        if(cacher==false){
            System.out.println("Po po po po po popopo po lalala");
        }
        
        

    }
    public void repondreAuCri(boolean cacher){
        if(cacher==false){
            System.out.println("Holllezzzz");
        }
    }
/**
 * Affiche les billets qu'a le spéctateur
 */
    public void afficherBilletsSpectateur(){
        int sizeArray=0;
        try{
            sizeArray=this.billets.length;
        }catch(Exception e){
            sizeArray=0;
        }
        if(sizeArray>0){
            for(Billet billet : this.billets){
                System.out.print(" | "+billet.match.niveauMatch+" : "+billet.match.joueurs[0].nomCourant+" - "+ billet.match.joueurs[0].nomCourant+ " | ");
            }
            
        }


}

    
    
}
