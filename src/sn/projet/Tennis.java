/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Ibrahima
 */
public class Tennis {
    public static int getYears(Date d) {
        Calendar curr = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(d);
        int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        curr.add(Calendar.YEAR, - yeardiff);
        if (birth.after(curr)) {
            yeardiff = yeardiff - 1;
        }
        return yeardiff;
    }
    
    public static void main(String[] args) {
        //        Joueur a = new Joueur("Diallo", "Ba", "Ibrahima",
        //                    "The goat", new Date(23,2,1998), "Metz",
        //                    new Date(19,11,2019), "Senegalaise", 180, 70,
        //                    "Gauche", "Tropico", "Poutine", 
        //                    "Short", "Bleu");
        //        
        //        System.out.println(a.getDateNaissance());
        
        
        Calendar curr = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.set(1999, 9, 4);
        System.out.println(birth.getTime());

    
        
    }
    
    
    
    
}

    


