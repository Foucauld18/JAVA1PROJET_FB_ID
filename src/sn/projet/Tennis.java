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
public class Tennis {
    
    
    
    public static void main(String[] args) {
        Joueur a = new Joueur("Diallo", "Ba", "Ibrahima",
                            "The goat", LocalDate.of(1999, 9, 4), "Metz",
                            LocalDate.of(2035, 1, 5), "Senegalaise", 180, 70,
                            "Gauche", "Tropico", "Poutine", 
                            "Short", "Bleu");
                
                System.out.println(a.getAge());

    
        
    }
    
    
    
    
}

    


