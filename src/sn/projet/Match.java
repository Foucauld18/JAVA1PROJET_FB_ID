/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.util.Scanner;

import java.security.DrbgParameters.NextBytes;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/**
 *
 * @author Foucauld18
 * 
 */
public class Match {
    protected CategorieMatch categorie;
    protected Joueur[] joueurs;
    protected Arbitre arbitre;
    protected int scoreJoueur0;
    protected int scoreJoueur1;
    protected Set sets[];
    protected Statistiques[] statistiques;

    protected Joueur vainqueurMatch;
    protected Joueur perdantMatch;
    protected NiveauMatch niveauMatch;

    /**
     * 
     * @param joueura
     * @param joueurb
     * @param niveauMatch 1er tour, 2ème tour ... final
     * @param arbitre
     */
    public Match(Joueur joueura, Joueur joueurb, NiveauMatch niveauMatch, Arbitre arbitre) {

        if (joueura instanceof JoueurHomme) {
            if (joueurb instanceof JoueurHomme) {
                this.categorie = CategorieMatch.simple_Homme;
            } else
                System.exit(1);

        } else if (joueura instanceof Joueuse) {
            if (joueurb instanceof Joueuse) {
                this.categorie = CategorieMatch.simple_Femme;
            } else
                System.exit(1);
        } else {
            System.exit(1);
        }

        Double aleatoire = Math.random();
        Joueur joueur0, joueur1;
        if (aleatoire < 0.500001) {// Designe le premier serveur. Le premier Serveur du match est par la suite le
                                   // joueur0
            joueur0 = joueura;
            joueur1 = joueurb;
        } else {
            joueur0 = joueurb;
            joueur1 = joueura;
        }
        this.joueurs = new Joueur[] { joueur0, joueur1 };
        this.niveauMatch = niveauMatch;
        this.scoreJoueur0 = 0;
        this.scoreJoueur1 = 0;
        this.arbitre = arbitre;
        this.vainqueurMatch = null;
        this.perdantMatch = null;
        Statistiques statJoueur0Match = new Statistiques();
        Statistiques statJoueur1Match = new Statistiques();
        Statistiques statMatch = new Statistiques();
        this.statistiques = new Statistiques[] { statJoueur0Match, statJoueur1Match, statMatch };

    }

    /**
     * 
     * @param vainqueurDernierSet
     * @return Permet de mettre à jour le score du match
     */

    /**
     * tgtgbtbt
     * 
     * @param vainqueurDernierSet frfr
     */
    public void SetMatchResultat(Joueur vainqueurDernierSet) {

        if (joueurs[0] == vainqueurDernierSet) {
            this.scoreJoueur0 += 1;
            if (this.scoreJoueur0 > 2 && this.categorie == CategorieMatch.simple_Homme) {
                this.vainqueurMatch = joueurs[0];
                this.perdantMatch = joueurs[1];
            }
            if (this.scoreJoueur0 > 1 && this.categorie == CategorieMatch.simple_Femme) {
                this.vainqueurMatch = joueurs[0];
                this.perdantMatch = joueurs[1];
            }

        } else {
            this.scoreJoueur1 += 1;
            if (this.scoreJoueur1 > 2 && this.categorie == CategorieMatch.simple_Homme) {
                this.vainqueurMatch = joueurs[1];
                this.perdantMatch = joueurs[0];
            }
            if (this.scoreJoueur1 > 1 && this.categorie == CategorieMatch.simple_Femme) {
                this.vainqueurMatch = joueurs[1];
                this.perdantMatch = joueurs[0];
            }

        }

    }

    /**
     * 
     * @param newSet
     * @return Permet d'ajouter un set à un match
     */

    public void ajouterUnSet(Set newSet) {
        Set[] listeSets = this.sets;
        int SizeArray = 0, i;
        try {
            SizeArray = listeSets.length;
        } catch (Exception e) {
            SizeArray = 0;
        }

        Set[] newListeSets = new Set[SizeArray + 1];
        for (i = 0; i < SizeArray; i++) {
            newListeSets[i] = listeSets[i];
        }
        newListeSets[SizeArray] = newSet;
        this.sets = newListeSets;
    }

    /**
     * Ajoute un certain nombre point au vainqueur d'un match pour mettre à jour le
     * classement ATP et WTA.
     */
    public void modifierClassementVainqueurMatch() {
        int valeurMatch = 0;
        switch (this.niveauMatch) {
        case premierTour:
            valeurMatch = 5;
            break;
        case deuxiemeTour:
            valeurMatch = 10;
            break;
        case troisiemeTour:
            valeurMatch = 15;
            break;
        case huitiemeFinal:
            valeurMatch = 20;
            break;
        case quartFinal:
            valeurMatch = 30;
            break;
        case demiFinal:
            valeurMatch = 40;
            break;
        case Final:
            valeurMatch = 50;
            break;
        default:
            valeurMatch = 0;// Match amicale

        }
        this.vainqueurMatch.setNbPoints(this.vainqueurMatch.getNbPoints() + valeurMatch);

    }

    /**
     * 
     * @return Vainqueur du match
     */
    public Joueur jouerMatch(boolean tournoisAutomatique) {
        boolean matchAutomatique = true;
        boolean afficherDetailMatch =false;
        if (tournoisAutomatique == false) {//si on n'est pas dans un tournois simulé automatiquement
            //procédure pour savoir si on simule le match ou si on y joue en manuel
            boolean goodCommande = false;
            while (goodCommande == false) {//repose la question si le input ne correspond pas à l'une des deux possibilité
                System.out.println(
                        "Pour jouer automatiquement ce match taper 'auto'. Pour jouer manuellement ce match taper 'manuel' ");

                String commande = "";
                Scanner keyboard = new Scanner(System.in);
                commande = keyboard.nextLine();
                if (commande.equals("auto")) {//Simulation du match
                    goodCommande = true;
                } else if (commande.equals("manuel")) {//match manuel
                    goodCommande = true;
                    matchAutomatique = false;
                }

            }
            if(matchAutomatique==true && tournoisAutomatique==false){//si le match est simulation est-ce que l'on affiche le détait
                String commandeDeux = "";
                System.out.println("Pour afficher le detail du match taper afficher");
                Scanner keyboardDeux = new Scanner(System.in);
                commandeDeux = keyboardDeux.nextLine();
                if (commandeDeux.equals("afficher")){
                    afficherDetailMatch=true;//oui on affiche les details
                }else{
                    afficherDetailMatch=false;//non on n'affiche pas les détails
                }
            }
           

        }

        getInitStatJoueur();//On memorise les stats du joueur avant le match pour ensuite determiner ces stats après le match
        boolean matchIsFinished = false;
        Joueur vainqueurDernierSet = null;//au debut du match il n'y a pas encore de vainqueur
        int compteurSet = 0;
        while (matchIsFinished == false) {
            // STAT NOMBRE DE SET JOUE
            joueurs[0].statJoueur.setNbSetJoue(joueurs[0].statJoueur.getNbSetJoue() + 1);
            joueurs[1].statJoueur.setNbSetJoue(joueurs[1].statJoueur.getNbSetJoue() + 1);
            compteurSet++;
            //Creation d'un set
            Set set = new Set(joueurs[0], joueurs[1], this.arbitre);
            ajouterUnSet(set);

            if (matchAutomatique == true) {//si le match est automatique on joue le set en automatique
                vainqueurDernierSet = set.jouerSet(compteurSet, this.categorie, true,afficherDetailMatch);
                SetMatchResultat(vainqueurDernierSet);
                arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1, null, afficherDetailMatch);
              
                
                
            } else {//si le match est manuel on joue le set en manuel
                vainqueurDernierSet = set.jouerSet(compteurSet, this.categorie, false,afficherDetailMatch);
                SetMatchResultat(vainqueurDernierSet);
                arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1, null, true);
            }

            if (this.vainqueurMatch == vainqueurDernierSet) {//Si le match a un vainquer
                matchIsFinished = true;//alors le match est termine
                
                if(tournoisAutomatique==true){//si nous sommes un tournois automatique on afffiche pas le score du match
                    arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1,
                    vainqueurDernierSet, false);
                }
                else{//si ce n'est pas un tournois automatique on annonce le score et le vainqueur
                    afficherScoreMatch();
                    arbitre.annoncerScoreMatch(joueurs[0], joueurs[1], this.scoreJoueur0, this.scoreJoueur1,
                        vainqueurDernierSet, true);
                }
                
                if (this.vainqueurMatch == joueurs[0])// Stat vainqueur match
                {
                    joueurs[0].statJoueur.SetNbMatchGagne(joueurs[0].statJoueur.getNbMatchGagne() + 1);
                } else {
                    joueurs[1].statJoueur.SetNbMatchGagne(joueurs[1].statJoueur.getNbMatchGagne() + 1);
                }
            }

            if (matchAutomatique == false && matchIsFinished == false) {//Procédure pour demander si on simule la fin du match
                boolean goodCommande = false;
                while (goodCommande == false) {
                    System.out.println("Pour simuler la fin du match taper 'fin' sinon continuer!");
                    String commande = "";
                    Scanner keyboard = new Scanner(System.in);
                    commande = keyboard.nextLine();
                    if (commande.equals("fin")) {//oui on simule la fin du match
                        goodCommande = true;
                        matchAutomatique = true;
                    } else {//non on ne simule pas la fin du match
                        goodCommande = true;
                    }
                }
            }

        }
        updateStatMatch();
        return (vainqueurDernierSet);
    }

    public void getInitStatJoueur() {
        this.statistiques[0] = (Statistiques) this.joueurs[0].statJoueur.clone();
        this.statistiques[1] = (Statistiques) this.joueurs[1].statJoueur.clone();
    }

    public void updateStatMatch() {


        Statistiques[] tampons = new Statistiques[] { this.statistiques[0], this.statistiques[1] };

        for (int i = 0; i < 2; i++) {// Determine les stats de chaque joeurs pendant le match. Pour les trouvers on
                                     // soustrait les stats du joueurs à ces stats d'avant match
            this.statistiques[i]
                    .setNbDoubleFautes(this.joueurs[i].statJoueur.getNbDoubleFautes() - tampons[i].getNbDoubleFautes());
            this.statistiques[i].setNbJeuGagne(this.joueurs[i].statJoueur.getNbJeuGagne() - tampons[i].getNbJeuGagne());
            this.statistiques[i].setNbJeuJoue(this.joueurs[i].statJoueur.nbJeuJoue - tampons[i].getNbJeuJoue());
            this.statistiques[i].setNbPremierService(
                    this.joueurs[i].statJoueur.getNbPremierService() - tampons[i].getNbPremierService());
            this.statistiques[i].setNbSecondService(
                    this.joueurs[i].statJoueur.getNbSecondService() - tampons[i].getNbSecondService());
            this.statistiques[i].setNbSetGagne(this.joueurs[i].statJoueur.getNbSetGagne() - tampons[i].getNbSetGagne());
            this.statistiques[i].setNbSetJoue(this.joueurs[i].statJoueur.getNbSetJoue() - tampons[i].getNbSetJoue());
            this.statistiques[i].setNbTotalPointRemporte(
                    this.joueurs[i].statJoueur.getNbTotalPointRemporte() - tampons[i].getNbTotalPointRemporte());
        }
        // Determine les stats du match. C'est la somme des stats de chaque joueur
        this.statistiques[2]
                .setNbDoubleFautes(this.statistiques[1].getNbDoubleFautes() + this.statistiques[0].getNbDoubleFautes());
        this.statistiques[2].setNbJeuGagne(this.statistiques[1].getNbJeuGagne() + this.statistiques[0].getNbJeuGagne());
        this.statistiques[2].setNbJeuJoue(this.statistiques[1].getNbJeuJoue());
        this.statistiques[2].setNbPremierService(
                this.statistiques[1].getNbPremierService() + this.statistiques[0].getNbPremierService());
        this.statistiques[2].setNbSecondService(
                this.statistiques[1].getNbSecondService() + this.statistiques[0].getNbSecondService());
        this.statistiques[2].setNbSetGagne(this.statistiques[1].getNbSetGagne() + this.statistiques[0].getNbSetGagne());
        this.statistiques[2].setNbSetJoue(this.statistiques[1].getNbSetJoue());
        this.statistiques[2].setNbTotalPointRemporte(
                this.statistiques[1].getNbTotalPointRemporte() + this.statistiques[0].getNbTotalPointRemporte());

    }

    public void afficherScoreMatch(){
        int nbSet;
        try {
            nbSet = this.sets.length;
        } catch (Exception e) {
            nbSet = 0;
        }
        int longeurNom0 = this.joueurs[0].nomCourant.length();
        int longeurNom1 = this.joueurs[1].nomCourant.length();
        
        if(longeurNom0>longeurNom1){//aligner les scores en fonctions de la longeurs des noms
            System.out.println("");
            System.out.print(this.joueurs[0].nomCourant+" |");
            
            for(int i=0;i<nbSet;i++){
                System.out.print(sets[i].scoreSetJoueur0+"|");
                
            }
            if(this.joueurs[0]==this.vainqueurMatch){
                System.out.print("V");
            }
            System.out.println("");
            System.out.print(this.joueurs[1].nomCourant);
            for(int i=0;i<longeurNom0-longeurNom1;i++){//permet d'aligner les scores
                System.out.print(" ");
            }
            System.out.print(" |");
            for(int i=0;i<nbSet;i++){
                System.out.print(sets[i].scoreSetJoueur1+"|");
            }
            if(this.joueurs[1]==this.vainqueurMatch){
                System.out.print("V");
            }
           
        } else{
            System.out.println("");
            System.out.print(this.joueurs[0].nomCourant);
            for(int i=0;i<longeurNom1-longeurNom0;i++){//permet d'aligner les scores
                System.out.print(" ");
            }
            System.out.print(" |");
            
            for(int i=0;i<nbSet;i++){
                System.out.print(sets[i].scoreSetJoueur0+"|");
                
            }
            if(this.joueurs[0]==this.vainqueurMatch){
                System.out.print("V");
            }
            System.out.println("");
            System.out.print(this.joueurs[1].nomCourant+" |");
            
            for(int i=0;i<nbSet;i++){
                System.out.print(sets[i].scoreSetJoueur1+"|");
            }
            if(this.joueurs[1]==this.vainqueurMatch){
                System.out.print("V");
            }
        }
         
    }
}
