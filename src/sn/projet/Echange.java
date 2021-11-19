 /*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sn.projet;


/**
 *
 * @author Foucauld
 */

public class Echange {
    protected Joueur [] joueurs;
    protected Joueur vainqueurEchange;
    protected Arbitre arbitre;
    
    /* builder */  
    public Echange(Joueur serveur, Joueur joueur1,Arbitre arbitre){
        
        this.joueurs = new Joueur [] {serveur,joueur1}; 
        this.arbitre=arbitre;
    }
    
     /* Method */
 
    public Joueur jouerEchange(){
        double probaGagnerEchange=Math.random();
        double probaReussirPremierService=Math.random();// chiffre aléatoire entre 0.0 et 1.0
        
        
        
        if (probaReussirPremierService <=0.6){//60% de chance de valider son premier service
            joueurs[0].statJoueur.setNbPremierService(joueurs[0].statJoueur.getNbPremierService()+1);
            if(probaGagnerEchange<0.6){// Si le premier service passe le serveur à 60% de chance de gagner l'echange 
                this.vainqueurEchange=joueurs[0];
                joueurs[0].statJoueur.setNbTotalPointRemporte(joueurs[0].statJoueur.getNbTotalPointRemporte()+1);
                return(joueurs[0]);
            } else this.vainqueurEchange=joueurs[1];
            joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte()+1);
            return(joueurs[1]);
           

        }
         else if ( probaReussirPremierService >0.6 && probaReussirPremierService <0.95){//Deuxième service
            Double probaReussirDeuxiemeService = Math.random();
            
            if(probaReussirDeuxiemeService <0.8){//80% de chance de reussir sont deuxième service car le joueur prendra moins de risque
                joueurs[0].statJoueur.setNbSecondService(joueurs[0].statJoueur.getNbSecondService()+1);
                if(probaGagnerEchange<0.5){// le service sera moins puissant que le premier donc 50/50 le vainquer de l'échange
                    this.vainqueurEchange=joueurs[0];
                    joueurs[0].statJoueur.setNbTotalPointRemporte(joueurs[0].statJoueur.getNbTotalPointRemporte()+1);
                    return(joueurs[0]);
                } else this.vainqueurEchange=joueurs[1];
                joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte()+1);
                return(joueurs[1]);
                
            } else this.vainqueurEchange=joueurs[1];//Deuxième Service Non Réussi
            joueurs[1].statJoueur.setNbTotalPointRemporte(joueurs[1].statJoueur.getNbTotalPointRemporte()+1);
            joueurs[0].statJoueur.setNbDoubleFautes(joueurs[0].statJoueur.getNbDoubleFautes()+1);
             return(joueurs[1]);
        } else return(this.jouerEchange());// Late on recommence

    }   
   
}

