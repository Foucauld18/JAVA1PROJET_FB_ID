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
public class Arbitre extends Personne{
    
    
    public Arbitre(String nomNaissance, String nomCourant, String prenom,
                    String surnom, LocalDate dateNaissance, String lieuNaissance,
                    LocalDate dateDeces, String nationalite, int taille, int poids){
        
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        
    }
    
    //public void annoncerScoreMatch()
    //public void annoncerScoreSet()
}