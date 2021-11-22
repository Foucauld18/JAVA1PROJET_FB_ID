package sn.projet;

public class ListeTournois {
    public Tournoi [] listeTournoi;


    public ListeTournois(){
        this.listeTournoi=null;
    }

    
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
}

