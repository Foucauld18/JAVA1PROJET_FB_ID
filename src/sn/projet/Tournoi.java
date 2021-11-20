/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;
import java.util.Scanner;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Foucauld
 */
public class Tournoi {
    protected Match matchsHomme[];
    protected Match matchsFemme[];
    protected Joueuse[] joueuses;
    protected JoueurHomme[] joueurs;
    protected Arbitre[] arbitres;
    protected Spectateur[] spectateurs;
    protected Spectatrice[] spectatrices;
    protected String ville;
    protected String surface;
    protected String annee;
    protected Joueur gagnante;
    protected Joueur gagnant;

    /* Constructor */
    public Tournoi(String ville, String surface, String annee) {
        this.surface = surface;
        this.ville = ville;
        this.annee = annee;
        this.joueuses = new Joueuse[128];
        this.joueurs = new JoueurHomme[128];
        this.spectateurs = new Spectateur[500];
        this.spectatrices = new Spectatrice[500];
        this.arbitres = new Arbitre[16];
        this.matchsHomme = new Match[127];
        this.matchsFemme = new Match[127];

        this.gagnant = null;
        this.gagnante = null;
    }

    public void jouerTournois(boolean automatiqueHomme, boolean automatiqueFemme) {  
        iniTableauMatch();
        int nbMatch=32;
        int k=1;
        NiveauMatch tours [] = {NiveauMatch.premierTour,NiveauMatch.deuxiemeTour,NiveauMatch.troisiemeTour,NiveauMatch.huitiemeFinal,NiveauMatch.quartFinal,NiveauMatch.demiFinal,NiveauMatch.Final};
        while(k<8){
            boolean modeAChange=false;
            for(int i=0;i<nbMatch;i++){
                
                Match match = new Match(matchsHomme[i].jouerMatch(automatiqueHomme),matchsHomme[32+i].jouerMatch(automatiqueHomme),tours[k],arbitres[64%4]);
                ajouterMatchHomme(match);
                if(automatiqueHomme=false){
                    System.out.println("Pour simmuler les autres match de "+tours[k]+"homme taper 'auto' sinon continuer");
                    String commande = "";
                    Scanner keyboard = new Scanner(System.in);
                    commande = keyboard.nextLine();
                    if (commande.equals("auto")) {//Simulation du tour
                        automatiqueHomme=true;
                        modeAChange=true;
                    }//sinon on continue en mode manuelle
                }
                Match matchfemme = new Match(matchsFemme[i].jouerMatch(automatiqueFemme),matchsFemme[32+i].jouerMatch(automatiqueFemme),tours[k],arbitres[64%4]);
                ajouterMatchHomme(matchfemme);
                if(automatiqueFemme=false){
                    System.out.println("Pour simmuler les autres match de "+tours[k]+"femme taper 'auto' sinon continuer");
                    String commandedeux = "";
                    Scanner keyboarddeux = new Scanner(System.in);
                    commandedeux = keyboarddeux.nextLine();
                    if (commandedeux.equals("auto")) {//Simulation du tour
                        automatiqueFemme=true;
                        modeAChange=true;
                    }//sinon on continue en mode manuelle
                }
            }
            if(modeAChange==true){
                automatiqueFemme=false;
                automatiqueHomme=false;
            }
            if(automatiqueHomme==false){
                System.out.println("Pour simmuler les autres tours des hommes taper 'auto' sinon continuer");
                String commande = "";
                Scanner keyboard = new Scanner(System.in);
                commande = keyboard.nextLine();
                if (commande.equals("auto")) {//Simulation du tour
                    automatiqueHomme=true;

                }
            }
            if(automatiqueFemme==false){
                System.out.println("Pour simmuler les autres tours des femmes taper 'auto' sinon continuer");
                String commandedeux = "";
                Scanner keyboarddeux = new Scanner(System.in);
                commandedeux = keyboarddeux.nextLine();
                if (commandedeux.equals("auto")) {//Simulation du tour
                    automatiqueFemme=true;
                }
            }


            nbMatch=nbMatch/2;
            k++;
        }
        this.gagnant=this.matchsHomme[127].vainqueurMatch;
        this.gagnante=this.matchsFemme[127].vainqueurMatch; 

    }

    public void iniTableauMatch(){
        for(int i=0;i<64;i++){
            Match match = new Match(this.joueurs[i],this.joueurs[64+i],NiveauMatch.premierTour,arbitres[64%4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i],this.joueuses[64+i],NiveauMatch.premierTour,arbitres[64%4]);
            ajouterMatchFemme(matchfemme);
        }
       
    }

    public void ajouterMatchHomme(Match match) {
        int debut;
        int fin;
        switch (match.niveauMatch) {
        case premierTour:
            debut = 0;
            fin = 64;
            break;
        case deuxiemeTour:
            debut = 64;
            fin = 96;

            break;
        case troisiemeTour:
            debut = 96;
            fin = 112;

            break;
        case huitiemeFinal:
            debut = 112;
            fin = 120;

            break;
        case quartFinal:
            debut = 120;
            fin = 124;

            break;
        case demiFinal:
            debut = 124;
            fin = 126;
            break;
        case Final:
            debut = 126;
            fin = 127;
            break;
        default:
            debut = 0;
            fin = 0;
            System.out.println("Le Match n'a pas pu etre ajouté");
        }

        do {
            if (this.matchsHomme[debut] == null) {
                this.matchsHomme[debut] = match;
                break;
            }
            debut++;
        } while (debut < fin);

    };

    public void ajouterMatchFemme(Match match) {
        int debut;
        int fin;
        switch (match.niveauMatch) {
        case premierTour:
            debut = 0;
            fin = 64;
            break;
        case deuxiemeTour:
            debut = 64;
            fin = 96;

            break;
        case troisiemeTour:
            debut = 96;
            fin = 112;

            break;
        case huitiemeFinal:
            debut = 112;
            fin = 120;

            break;
        case quartFinal:
            debut = 120;
            fin = 124;

            break;
        case demiFinal:
            debut = 124;
            fin = 126;
            break;
        case Final:
            debut = 126;
            fin = 127;
            break;
        default:
            debut = 0;
            fin = 0;
            System.out.println("Le Match n'a pas pu etre ajouté");
        }

        do {
            if (this.matchsFemme[debut] == null) {
                this.matchsFemme[debut] = match;
                break;
            }
            debut++;
        } while (debut < fin);

    };

    public void ajouterArbitre(Arbitre arbitre) {
        int i = 0;
        do {
            if (this.arbitres[i] == null) {
                this.arbitres[i] = arbitre;
                break;
            }
            i++;
        } while (i < 16);
        if (i == 16) {
            System.out.println("Il y a suffisament d'arbitre sur le tournois");
        }

    };

    public void ajouterJoueurHomme(JoueurHomme joueur) {
        int i = 0;
        do {
            if (this.joueurs[i] == null) {
                this.joueurs[i] = joueur;
                break;
            }
            i++;
        } while (i < 128);
        if (i == 128) {
            System.out.println("Le tableau homme simple est complet");
        }

    };

    public void ajouterJoueuse(Joueuse joueuse) {
        int i = 0;
        do {
            if (this.joueuses[i] == null) {
                this.joueuses[i] = joueuse;
                break;
            }
            i++;
        } while (i < 128);
        if (i == 128) {
            System.out.println("Le tableau femme simple est complet");
        }

    };

    public void afficherJoueurs() {
        for (int i = 0; i < 128; i++) {
            try {
                System.out.println(this.joueurs[i].nomCourant);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void afficherJoueuses() {
        for (int i = 0; i < 128; i++) {
            try {
                System.out.println(this.joueuses[i].nomCourant);
            } catch (Exception e) {
                break;
            }
        }
    }

    public Joueuse[] getJoueuses() {
        return this.joueuses;
    }

    public void setJoueuses(Joueuse[] joueuses) {
        this.joueuses = joueuses;
    }

    public JoueurHomme[] getJoueurHommes() {
        return this.joueurs;
    }

    public void setJoueurHommes(JoueurHomme[] joueurHommes) {
        this.joueurs = joueurHommes;
    }

    public Arbitre[] getArbitres() {
        return this.arbitres;
    }

    public void setArbitres(Arbitre[] arbitres) {
        this.arbitres = arbitres;
    }

    public Spectateur[] getSpectateurs() {
        return this.spectateurs;
    }

    public void setSpectateurs(Spectateur[] spectateurs) {
        this.spectateurs = spectateurs;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getSurface() {
        return this.surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Joueuse getGagnante() {
        return this.gagnante;
    }

    public void setGagnante(Joueuse gagnante) {
        this.gagnante = gagnante;
    }

    public JoueurHomme getGagnant() {
        return this.gagnant;
    }

    public void setGagnant(JoueurHomme gagnant) {
        this.gagnant = gagnant;
    }
}