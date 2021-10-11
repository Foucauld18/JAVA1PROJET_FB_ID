/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1projet_fb_id;
import java.time.LocalDate;




/**
 *
 * @author foucauldbglt
 */
public class Personne {
    
    protected String nomNaissance, lieuNaissance;
    protected LocalDate dateNaissance, dateDeces;
    String nomCourant, prenom, surnom, nationalite;
    Float taille, poids;
    
    public Personne(String nomNaissance){
    this.nomNaissance = nomNaissance;
    }
    
    
    public String getnomNaissance(){return this.nomNaissance;}
    
    public String getlieuNaissance(){return this.lieuNaissance;}
    
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
