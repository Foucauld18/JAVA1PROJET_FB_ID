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
        int k = 1;

        NiveauMatch tours[] = { NiveauMatch.premierTour, NiveauMatch.deuxiemeTour, NiveauMatch.troisiemeTour,
                NiveauMatch.huitiemeFinal, NiveauMatch.quartFinal, NiveauMatch.demiFinal, NiveauMatch.Final };
        while (k < 7) {
            int debut;
            int fin;
            switch (tours[k]) {
            case deuxiemeTour:
                debut = 0;
                fin = 32;
                break;
            case troisiemeTour:
                debut = 64;
                fin = 80;

                break;
            case huitiemeFinal:
                debut = 96;
                fin = 104;

                break;
            case quartFinal:
                debut = 112;
                fin = 116;

                break;
            case demiFinal:
                debut = 120;
                fin = 122;

                break;
            case Final:
                debut = 124;
                fin = 125;
                break;
            default:
                debut = 126;
                fin = 127;

            }

            boolean modeAChangeHomme = false;
            boolean mondeAchangeFemme = false;

            int compteurbis = 0;
            for (int i = debut; i < fin; i++) {
                Joueur joueur1;
                Joueur joueur2;
                joueur1 = matchsHomme[i].jouerMatch(automatiqueHomme);

                if (automatiqueHomme == false) {
                    System.out.println(
                            "Pour simmuler les autres match de " + tours[k] + "homme taper 'auto' sinon continuer");
                    String commande = "";
                    Scanner keyboard = new Scanner(System.in);
                    commande = keyboard.nextLine();
                    if (commande.equals("auto")) {// Simulation du tour
                        automatiqueHomme = true;
                        modeAChangeHomme = true;
                    } // sinon on continue en mode manuelle
                }

                joueur2 = matchsHomme[fin + compteurbis].jouerMatch(automatiqueHomme);

                if (automatiqueHomme == false) {
                    System.out.println(
                            "Pour simmuler les autres match de " + tours[k] + "homme taper 'auto' sinon continuer");
                    String commande = "";
                    Scanner keyboard = new Scanner(System.in);
                    commande = keyboard.nextLine();
                    if (commande.equals("auto")) {// Simulation du tour
                        automatiqueHomme = true;
                        modeAChangeHomme = true;
                    } // sinon on continue en mode manuelle
                }

                Match match = new Match(joueur1, joueur2, tours[k], arbitres[64 % 4]);
                ajouterMatchHomme(match);

                joueur1 = matchsFemme[i].jouerMatch(automatiqueFemme);

                if (automatiqueFemme == false) {
                    System.out.println(
                            "Pour simmuler les autres match de " + tours[k] + "femme taper 'auto' sinon continuer");
                    String commandedeux = "";
                    Scanner keyboarddeux = new Scanner(System.in);
                    commandedeux = keyboarddeux.nextLine();
                    if (commandedeux.equals("auto")) {// Simulation du tour
                        automatiqueFemme = true;
                        mondeAchangeFemme = true;
                    } // sinon on continue en mode manuelle
                }
                joueur2 = matchsFemme[fin + compteurbis].jouerMatch(automatiqueFemme);

                if (automatiqueFemme == false) {
                    System.out.println(
                            "Pour simmuler les autres match de " + tours[k] + "femme taper 'auto' sinon continuer");
                    String commandedeux = "";
                    Scanner keyboarddeux = new Scanner(System.in);
                    commandedeux = keyboarddeux.nextLine();
                    if (commandedeux.equals("auto")) {// Simulation du tour
                        automatiqueFemme = true;
                        mondeAchangeFemme = true;
                    } // sinon on continue en mode manuelle
                }

                Match matchfemme = new Match(joueur1, joueur2, tours[k], arbitres[64 % 4]);
                ajouterMatchFemme(matchfemme);

                compteurbis++;
                if (k == 6) {
                    match.jouerMatch(automatiqueHomme);
                    matchfemme.jouerMatch(automatiqueFemme);
                }

            }
         

            if (modeAChangeHomme == true) {

                automatiqueHomme = false;
            } else if (mondeAchangeFemme == true) {
                automatiqueFemme = false;
            }
            if (automatiqueHomme == false) {
                System.out.println("Pour simmuler la fin du tounois des hommes taper 'auto' sinon continuer");
                String commande = "";
                Scanner keyboard = new Scanner(System.in);
                commande = keyboard.nextLine();
                if (commande.equals("auto")) {// Simulation du tour
                    automatiqueHomme = true;

                }
            }
            if (automatiqueFemme == false) {
                System.out.println("Pour simmuler la fin du tournois des femmes taper 'auto' sinon continuer");
                String commandedeux = "";
                Scanner keyboarddeux = new Scanner(System.in);
                commandedeux = keyboarddeux.nextLine();
                if (commandedeux.equals("auto")) {// Simulation du tour
                    automatiqueFemme = true;
                }
            }

            k++;
        }

        this.gagnant = this.matchsHomme[126].vainqueurMatch;
        this.gagnante = this.matchsFemme[126].vainqueurMatch;

    }

    public void iniTableauMatch() {

        for (int i = 0; i < 64; i++) {
            Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                    arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        JoueurHomme joueurInconnu= new JoueurHomme("Inconnu Homme", " ", " ", LocalDate.of(1994, 1, 5)," ",  " ", 0, 0, Main.Droite, " ", " ", Couleur.Vert);
        Joueuse joueuseInconnu = new Joueuse(" ", "Inconnu Femme"," ", " ", LocalDate.of(1994, 1, 5), " "," ", 0, 0, Main.Gauche, " ", " ", Couleur.Marron);

        for (int i = 0; i < 32; i++) {
            Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                    arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0; i < 16; i++) {
            Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                    arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0; i < 8; i++) {
            Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                    arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0; i < 4; i++) {
            Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                    arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0; i < 2; i++) {
            Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                    arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }

        Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
        Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);

    }
    public void afficherMatchTournoi(){
        NiveauMatch tours[] = { NiveauMatch.premierTour, NiveauMatch.deuxiemeTour, NiveauMatch.troisiemeTour,
            NiveauMatch.huitiemeFinal, NiveauMatch.quartFinal, NiveauMatch.demiFinal, NiveauMatch.Final };
        
            for(int i=0;i<7;i++){
            System.out.println("");
            System.out.println("--------------"+tours[i]+"--------------");
            afficherMatchTour(tours[i],"homme");
            }
            
            for(int i=0;i<7;i++){
                System.out.println("");
                System.out.println("--------------"+tours[i]+"--------------");
                afficherMatchTour(tours[i],"femme");
        }

    }

    public void afficherMatchTour(NiveauMatch tour, String categorie ) {
        int debut;
        int fin;
        switch (tour) {
        case premierTour:
        System.out.println("");
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
        int numeroMatch=1;
        System.out.println("");
        if(categorie.equals("homme")){
            do {
            
                if (this.matchsHomme[debut] == null) {
                    break;
                }
                
                System.out.print(tour+" simple homme match n° "+numeroMatch);
                this.matchsHomme[debut].afficherScoreMatch(7);
                System.out.println("");
                System.out.println("");
                numeroMatch++;
    
                debut++;
            } while (debut < fin);
        }else if (categorie.equals("femme")){
                do {
                
                    if (this.matchsFemme[debut] == null) {
                        break;
                    }
                    
                    System.out.print(tour+" simple femme match n° "+numeroMatch);
                    this.matchsFemme[debut].afficherScoreMatch(7);
                    System.out.println("");
                    System.out.println("");
                    numeroMatch++;
        
                    debut++;
                } while (debut < fin);
        }else{
            int debut2=debut;
            int fin2=fin;
            System.out.print("------------Simple Homme------------");
            do {
            
                if (this.matchsHomme[debut] == null) {
                    break;
                }
                
                System.out.print(tour+" simple homme match n° "+numeroMatch);
                this.matchsHomme[debut].afficherScoreMatch(7);
                System.out.println("");
                System.out.println("");
                numeroMatch++;
                debut++;
            } while (debut < fin);

            System.out.print("------------Simple Femme------------");
           numeroMatch=1;
            do {
                
                if (this.matchsFemme[debut2] == null) {
                    break;
                }
                
                System.out.print(tour+" simple femme match n° "+numeroMatch);
                this.matchsFemme[debut2].afficherScoreMatch(7);
                System.out.println("");
                System.out.println("");
                numeroMatch++;
    
                debut2++;
            } while (debut2 < fin2);
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

    public Joueur getGagnante() {
        return this.gagnante;
    }

    public void setGagnante(Joueur gagnante) {
        this.gagnante = gagnante;
    }

    public Joueur getGagnant() {
        return this.gagnant;
    }

    public void setGagnant(Joueur gagnant) {
        this.gagnant = gagnant;
    }
}