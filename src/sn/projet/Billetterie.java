package sn.projet;

public class Billetterie {
    protected Tournoi tournoi;
    protected int nbBilletVendu;
    protected int nbSpectateur;
    protected Match [] matchs;
    protected SpectateurTournoi[]spectateurs;
    protected int totalGain;
    protected String [] tribune;
    

    /**Constructeur */
    public Billetterie(Tournoi tournoi){
        this.tournoi=tournoi;
        this.nbBilletVendu=0;
        this.nbSpectateur=0;
        this.totalGain=0;
        this.matchs = new Match [254];
        for(int i=0;i<127;i++){
            matchs[i]=tournoi.matchsHomme[i];
            matchs[i+127]=tournoi.matchsFemme[i];
        }
        this.tribune= new String [] {"A,B,C,D"};
        
        this.spectateurs=null;
    }
    /**Methods */

    /**
     * 
     * @param match
     * @return integer Prix du billet de ce match
     */

    public int getPrixBilletMatch(Match match){
        int valeurMatch = 0;
        switch (match.niveauMatch) {
        case premierTour:
            valeurMatch = 10;
            break;
        case deuxiemeTour:
            valeurMatch = 20;
            break;
        case troisiemeTour:
            valeurMatch = 30;
            break;
        case huitiemeFinal:
            valeurMatch = 40;
            break;
        case quartFinal:
            valeurMatch = 60;
            break;
        case demiFinal:
            valeurMatch = 80;
            break;
        case Final:
            valeurMatch = 120;
            break;
        default:
            valeurMatch = 0;// Match amicale

        }
        return(valeurMatch);
    }

    public void creerBilletsMatch(Match match){
        for(int i=0;i<4;i++){
            for(int k=1;k<31;k++){
                Billet billet = new Billet(getPrixBilletMatch(match), this.tribune[i],k, match);
                match.ajouterUnBillet(billet);
            }
        }
    }
    public void ajouterUnSpectateur(SpectateurTournoi spectateur) {
        SpectateurTournoi[] listeSpectateurs = this.spectateurs;
        int SizeArray = 0, i;
        try {
            SizeArray = listeSpectateurs.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        SpectateurTournoi[] newListeSpectateurs = new SpectateurTournoi[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newListeSpectateurs[i] = listeSpectateurs[i];
            if(listeSpectateurs[i]==spectateur){//Le spectateur est déja dans la liste des spectateur
                return;
            }
        }
        newListeSpectateurs[SizeArray] = spectateur;
        this.spectateurs = newListeSpectateurs;
    } 

    public void acheterBillet(SpectateurTournoi spectateur,Match match) {
        boolean matchIsInBilletterie=false;
        for(Match matchBilletterie : this.matchs){
            if(matchBilletterie==match){
                matchIsInBilletterie=true;
                break;
            }
            if(matchIsInBilletterie==false){
                System.out.println("Ce match n'est pas en vente sur cette billetterie");
                return;
            }
        }
        
        boolean billetAchete=false;
        for (Billet billet : match.billets){
            if(billet.getTitulaire()==null){
                billet.setTitulaire(spectateur.prenom+" "+spectateur.nomCourant);
                billetAchete=true;
                spectateur.ajouterUnBillet(billet);
                this.totalGain+=billet.getPrix();
                this.nbBilletVendu+=1;
                ajouterUnSpectateur(spectateur);
                updateNbSpectateur();
                match.ajouterUnSpectateur(spectateur);
                break;
            } 
        } 

        if(billetAchete==false){
            System.out.println("Il n'y a pas/plus de billet en vente pour ce match");
            
        }
      
    }

    public void updateNbSpectateur(){
        int nbSpectateur;
        try {
            nbSpectateur = this.spectateurs.length;
        } catch (Exception e) {
            nbSpectateur = 0;
        }
        this.nbSpectateur=nbSpectateur;
    }

    public void genererBilletsTournois(){
        for(int i=0;i<254;i++){
            creerBilletsMatch(this.matchs[i]);
        }
    }
    public Tournoi getTournoi() {
        return this.tournoi;
    }


    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    public int getNbBilletVendu() {
        return this.nbBilletVendu;
    }

    public void setNbBilletVendu(int nbBilletVendu) {
        this.nbBilletVendu = nbBilletVendu;
    }

    public int getNbSpectateur() {
        return this.nbSpectateur;
    }

    public void setNbSpectateur(int nbSpectateur) {
        this.nbSpectateur = nbSpectateur;
    }

    public Match[] getMatchs() {
        return this.matchs;
    }

    public void setMatchs(Match[] matchs) {
        this.matchs = matchs;
    }

    public SpectateurTournoi[] getSpectateurs() {
        return this.spectateurs;
    }

   

    public int getTotalGain() {
        return this.totalGain;
    }

    public void setTotalGain(int totalGain) {
        this.totalGain = totalGain;
    }

}
