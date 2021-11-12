 /*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sn.projet;
import static java.lang.Math.sqrt;

/**
 *
 * @author Foucauld
 */



public class Echange {
    protected Joueur [] joueurs;
    protected Joueur vainqueurEchange;
    protected Double aleatoire;
    protected Double aleatoire2;
    
    /* builder */
    
    public Echange(Joueur serveur, Joueur joueur1){
        this.joueurs = new Joueur [] {serveur,joueur1};
        
    }
    
    /* Method */
    /**
     * @return Joueur
     * Cette Méthode renvoie le vainqueur de l'échange.
     * Les "probas" de cette méthode sont complètement aléatoire cependant elle avantage le serveur comme il est statistiquement prouvé qu'un joueur est meilleur sur son service
     */
    public Joueur jouerEchange(){
        double probaGagnerEchange=Math.random();
        double probaReussirPremierService=Math.random();// chiffre aléatoire entre 0.0 et 1.0
        this.aleatoire=probaReussirPremierService; 
        if (probaReussirPremierService <=0.6){//60% de chance de valider son premier service
            if(probaGagnerEchange<0.6){// Si le premier service passe le serveur à 60% de chance de gagner l'echange 
                this.vainqueurEchange=joueurs[0];
                return(joueurs[0]);
            } else this.vainqueurEchange=joueurs[1];
            return(joueurs[1]);
           

        }
        if ( probaReussirPremierService >0.6 && probaReussirPremierService <0.95){//Deuxième service
            Double probaReussirDeuxiemeService = Math.random();
            this.aleatoire2=probaReussirDeuxiemeService;
            
            if(probaReussirDeuxiemeService <0.8){//80% de chance de reussir sont deuxième service car le joueur prendra moins de risque
                if(probaGagnerEchange<0.5){// le service sera moins puissant que le premier donc 50/50 le vainquer de l'échange
                    this.vainqueurEchange=joueurs[0];
                    return(joueurs[0]);
                } else this.vainqueurEchange=joueurs[1];
                return(joueurs[1]);
                
            } else this.vainqueurEchange=joueurs[1];
             return(joueurs[1]);//Deuxième Service Non Réussi
        } else return(this.jouerEchange());// Late on recommence



    }
    


   
   
   
}

