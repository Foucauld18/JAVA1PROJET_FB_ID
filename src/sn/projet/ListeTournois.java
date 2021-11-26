package sn.projet;
/**
 * Liste les tournois créé
 */
public class ListeTournois {
    public Tournoi [] listeTournoi;


    public ListeTournois(){
        this.listeTournoi=null;
    }
    /**
     * Ajouter un tournoi dans la liste
     * @param elementAajouter
     */
    
    public void ajouterUnTournoi (Tournoi elementAajouter) {
        Tournoi[] listeExistente = this.listeTournoi;
        int SizeArray = 0, i;
        try {
            SizeArray = listeExistente.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        Tournoi[] newListe = new Tournoi[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newListe[i] = listeExistente[i];
        }
        newListe[SizeArray] = elementAajouter;
        this.listeTournoi = newListe;
    } 
    /**
     * Affiche les tournois de la liste
     * @return le nombre de tounois dans la liste
     */

    public int afficherListeTournois(){
        System.out.println("-----Mes tournois----");
        int sizeArray;
        int nbTournoiCree;
        try{
            sizeArray=this.listeTournoi.length;
        }catch(Exception e){
            sizeArray=0;
        }
        int numero=0;
        if(sizeArray>0){
            for(int i=0;i<sizeArray;i++){
                numero++;
                System.out.println("");
                System.out.println("        Tournoi n°"+numero);
                System.out.println("-----"+this.listeTournoi[i].nomTournoi + " "+ this.listeTournoi[i].annee+ "----");
                System.out.println("Ville : "+this.listeTournoi[i].ville);
                System.out.println("Surface : "+this.listeTournoi[i].ville);
            }
            
        }
        else {
            System.out.println("");
            System.out.println("vous n'avez pas encore créé de tournoi.");
        }
            
        return(sizeArray);
        

    }
}

