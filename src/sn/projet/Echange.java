 /*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sn.projet;



public class Echange {
    protected Joueur serveur;
    protected Joueur joueur2;
    protected Joueur vainqueurEchange;
    
    /* builder */
    
    public Echange(Joueur serveur, Joueur joueur2){
        this.serveur=serveur;
        this.joueur2=joueur2;
        
    }
    
    /* Method */
    /**
     * @return Joueur
     * Cette Méthode renvoie le vainqeur de l'échange.
     */
    public Joueur jouerEchange(){
        Double probaReussirPremierService = 0.1;
        if (probaReussirPremierService <=0.6){//Premier Service réussi
            this.vainqueurEchange=serveur;
            return(this.serveur);

        }
        if ( probaReussirPremierService >0.6 && probaReussirPremierService <0.95){//Deuxième Service
            Double probaReussirDeuxiemeService = 0.1;
            
            if(probaReussirDeuxiemeService <0.8){//Deuxième Service Reussi
                this.vainqueurEchange=serveur;
                return(this.serveur);
                
            } else this.vainqueurEchange=joueur2;
             return(this.joueur2);//Deuxième Service Non Réussi
        } else return(this.jouerEchange());// Late on recommence



    }
    


   
   
   
}

