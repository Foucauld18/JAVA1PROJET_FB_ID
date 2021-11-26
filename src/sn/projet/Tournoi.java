/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.projet;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Foucauld
 */
public class Tournoi {
    protected Match matchsHomme[];
    protected String nomTournoi;
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
    protected Billetterie billetterie;

    /* Constructor */
    public Tournoi(String nomTournoi,String ville, String surface, String annee) {
        this.nomTournoi=nomTournoi;
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
        for(int i=0;i<128;i++){
            this.joueurs[i]=null;
            this.joueuses[i]=null;
        }

        this.gagnant = null;
        this.gagnante = null;
    }

    public void jouerTournois(boolean automatiqueHomme, boolean automatiqueFemme) {
        
        iniTableauMatch();
       
        int k = 1;
        int compteurMatch=64;
        
        NiveauMatch tours[] = { NiveauMatch.premierTour, NiveauMatch.deuxiemeTour, NiveauMatch.troisiemeTour,
                NiveauMatch.huitiemeFinal, NiveauMatch.quartFinal, NiveauMatch.demiFinal, NiveauMatch.Final };
        while (k < 7) {
            int debut;
            int fin;
            switch (tours[k]) {
            case deuxiemeTour:
                debut = 0 ;
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
                this.matchsHomme[compteurMatch].setJoueursMatch(joueur1, joueur2);
                this.matchsHomme[compteurMatch].setArbitre(arbitres[i%16]);
                

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

                this.matchsFemme[compteurMatch].setJoueursMatch(joueur1, joueur2);
                this.matchsFemme[compteurMatch].setArbitre(arbitres[i%16]);

                compteurbis++;
                if (k == 6) {//Jouer les finales
                    matchsHomme[126].jouerMatch(automatiqueHomme);
                    matchsFemme[126].jouerMatch(automatiqueFemme);
                }
                
                compteurMatch++;
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
            if(k==1){
                afficherMatchTour(tours[0],"homme");
            }
            afficherMatchTour(tours[k],"homme");
            k++;
            
        }

        this.gagnant = this.matchsHomme[126].vainqueurMatch;
        this.gagnante = this.matchsFemme[126].vainqueurMatch;

    }

    public void iniTableauMatch() {

        for (int i = 0; i < 64; i++) {
            Match match = new Match(this.joueurs[i], this.joueurs[64 + i], NiveauMatch.premierTour, arbitres[i % 16]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(this.joueuses[i], this.joueuses[64 + i], NiveauMatch.premierTour,
                    arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        JoueurHomme joueurInconnu= new JoueurHomme("Inconnu Homme", " ", " ", LocalDate.of(1994, 1, 5)," ",  " ", 0 , 0 , Main.Droite, " ", " ", Couleur.Vert);
        Joueuse joueuseInconnu = new Joueuse(" ", "Inconnu Femme"," ", " ", LocalDate.of(1994, 1, 5), " "," ", 0 , 0 , Main.Gauche, " ", " ", Couleur.Marron);

        for (int i = 0; i < 32; i++) {
            Match match = new Match(joueurInconnu, joueurInconnu, NiveauMatch.deuxiemeTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(joueuseInconnu,joueuseInconnu, NiveauMatch.deuxiemeTour,arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0; i < 16; i++) {
            Match match = new Match(joueurInconnu, joueurInconnu, NiveauMatch.troisiemeTour, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(joueuseInconnu,joueuseInconnu, NiveauMatch.troisiemeTour,arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0 ; i < 8; i++) {
            Match match = new Match(joueurInconnu, joueurInconnu, NiveauMatch.huitiemeFinal, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(joueuseInconnu,joueuseInconnu, NiveauMatch.huitiemeFinal,arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0 ; i < 4; i++) {
            Match match = new Match(joueurInconnu, joueurInconnu, NiveauMatch.quartFinal, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(joueuseInconnu,joueuseInconnu, NiveauMatch.quartFinal,arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }
        for (int i = 0 ; i < 2; i++) {
            Match match = new Match(joueurInconnu, joueurInconnu, NiveauMatch.demiFinal,arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(joueuseInconnu,joueuseInconnu, NiveauMatch.demiFinal,arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);
        }

        Match match = new Match(joueurInconnu, joueurInconnu, NiveauMatch.Final, arbitres[64 % 4]);
            ajouterMatchHomme(match);
            Match matchfemme = new Match(joueuseInconnu,joueuseInconnu, NiveauMatch.Final,arbitres[64 % 4]);
            ajouterMatchFemme(matchfemme);

    }
 
    public void afficherMatchTournoi(String genre) {
        NiveauMatch tours[] = { NiveauMatch.premierTour, NiveauMatch.deuxiemeTour, NiveauMatch.troisiemeTour,
                NiveauMatch.huitiemeFinal, NiveauMatch.quartFinal, NiveauMatch.demiFinal, NiveauMatch.Final };

        if (genre.equals("h")) {//afficher hommes
            for (int i = 0 ; i < 7; i++) {
                System.out.println("");
                System.out.println("-----------------" + tours[i] + "Hommes" + "-----------------");
                afficherMatchTour(tours[i], "homme");
            }
        } else if (genre.equals("f")) {//afficher femmes
            for (int i = 0 ; i < 7; i++) {
                System.out.println("");
                System.out.println("-----------------" + tours[i] + "Femmes" + "-----------------");
                afficherMatchTour(tours[i], "femme");
            }
        } else {
            for (int i = 0 ; i < 7; i++) {//afficher les deux
                System.out.println("");
                System.out.println("-----------------" + tours[i] + "Hommes" + "-----------------");
                afficherMatchTour(tours[i], "homme");
            }
            for (int i = 0 ; i < 7; i++) {
                System.out.println("");
                System.out.println("-----------------" + tours[i] + "Femmes" + "-----------------");
                afficherMatchTour(tours[i], "femme");
            }
        }

    }
    /**
     * @param tour
     * @param categorie homme , femme ou autre
     * @return affiche les match du tours homme,femme ou les deux
     */

    public void afficherMatchTour(NiveauMatch tour, String categorie ) {
        int debut;
        int fin;
        switch (tour) {
        case premierTour:
        System.out.println("");
            debut = 0 ;
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
            debut = 0 ;
            fin = 0 ;
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
            debut = 0 ;
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
            debut = 0 ;
            fin = 0 ;
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
            debut = 0 ;
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
            debut = 0 ;
            fin = 0 ;
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
        int i = 0 ;
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
        int i = 0 ;
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
        int i = 0 ;
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
        for (int i = 0 ; i < 128; i++) {
            try {
                System.out.println(i+1+"- "+this.joueurs[i].prenom+" "+this.joueurs[i].nomCourant);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void afficherJoueuses() {
        for (int i = 0 ; i < 128; i++) {
            try {
                System.out.println(i+1+"- "+this.joueuses[i].prenom+" "+this.joueuses[i].nomCourant);
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

    public void setBilletterieTournoi(Billetterie billetterie){
        this.billetterie=billetterie;

    }

    public Match selectionnerUnMatch(int niveau,int numero,String genre){
        NiveauMatch tours[] = { NiveauMatch.premierTour, NiveauMatch.deuxiemeTour, NiveauMatch.troisiemeTour,
            NiveauMatch.huitiemeFinal, NiveauMatch.quartFinal, NiveauMatch.demiFinal, NiveauMatch.Final };
        int debut;
        int fin;
        switch (tours[niveau-1]) {
        case premierTour:
            debut = 0 ;
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
            fin = 0 ;
            System.out.println("Le Match n'a pas pu etre ajouté");
        }
        int index=debut+numero-1;
        if(genre.equals("h")){

            if(index>=debut && index<fin){
                return(this.matchsHomme[index]);

            }else{//le numero ne correspond pas un match de se tour la
                return null;
            }

        }else {
            if(index>=debut && index<fin){
                return(this.matchsFemme[index]);

            }else{//le numero ne correspond pas un match de se tour la
                return null;
            }
        }
    }
    public int index(int niveau,String position){
        NiveauMatch tours[] = { NiveauMatch.premierTour, NiveauMatch.deuxiemeTour, NiveauMatch.troisiemeTour,
            NiveauMatch.huitiemeFinal, NiveauMatch.quartFinal, NiveauMatch.demiFinal, NiveauMatch.Final };
        int debut;
        int fin;
        switch (tours[niveau]) {
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
            fin = 0 ;
            System.out.println("Le Match n'a pas pu etre ajouté");
        }
        if(position.equals("fin")){
            return(fin);
        }else{
            return(debut);
        }
    }

    public void creerManuellementUnJoueur(){
        System.out.println("Entrer le nom du joueur");
        String nom = "";
        Scanner keyboard = new Scanner(System.in);
        nom = keyboard.nextLine();

        System.out.println("Entrer le prenom du joueur");
        String prenom = "";
        prenom = keyboard.nextLine();

        System.out.println("Entrer le surnom du joueur");
        String surnom = "";
        surnom = keyboard.nextLine();
        int anneeNaissance;
        int jourNaissance;
        int moisNaissance;
        do{
            System.out.println("Entrer l'annee de naissance du joueur");
            String anneeNaissancestr = "";
            anneeNaissancestr= keyboard.nextLine();
            try{
                anneeNaissance=Integer.valueOf(anneeNaissancestr);
            }catch(Exception e) {
                anneeNaissance=-1;
            }
        }while(anneeNaissance<0 );

        do{
            System.out.println("Entrer le mois de naissance du joueur");
            String moisNaissancestr = "";
            moisNaissancestr= keyboard.nextLine();
            try{
                moisNaissance=Integer.valueOf(moisNaissancestr);
            }catch(Exception e) {
                moisNaissance=-1;
            }
        }while(moisNaissance<1 || moisNaissance>12);

        do{
            System.out.println("Entrer le jour de naissance du joueur");
            String jourNaissancestr = "";
            jourNaissancestr= keyboard.nextLine();
            try{
                jourNaissance=Integer.valueOf(jourNaissancestr);
            }catch(Exception e) {
                jourNaissance=-1;
            }
        }while(jourNaissance<1 || jourNaissance>31);

        
        LocalDate dateNaissance = LocalDate.of(anneeNaissance, moisNaissance, jourNaissance);

        System.out.println("Entrer le lieu de naissance du joueur");
        String lieuNaissance = "";
        lieuNaissance = keyboard.nextLine();
        System.out.println("Entrer la nationalite du joueur");
        String nationalite= "";
        nationalite = keyboard.nextLine();
        System.out.println("Entrer la taille du joueur en cm");
        int taille;
        do{
            String taillestr = "";
            taillestr = keyboard.nextLine();
            try{
                taille = Integer.valueOf(taillestr);
            }catch(Exception e){
                System.out.println("Ceci ne correpond pas à une taille en cm");
                taille=-1;
            }
            
        }while(taille<0  );
        
        System.out.println("Entrer la masse du joueur en kg");
        String poidsstr= "";
        int poids;
        do{
            poidsstr = keyboard.nextLine();
            try{
                poids=Integer.valueOf(poidsstr);
            }catch(Exception e){
                poids=-1;
            }
             
        }while(poids<0 );
        
        System.out.println("Entrer la main du joueur. taper 'gauche' si il est gaucher, 'droite' si il est droitier.");
        String mainstr= "";
        mainstr = keyboard.nextLine();
        Main main;
        if(mainstr.equals("gauche")){
            main=Main.Gauche;
        } else{
            main=Main.Droite;
        }
        System.out.println("Entrer le ou les sponsor(s) du joueur");
        String sponsor= "";
        sponsor = keyboard.nextLine();

        System.out.println("Entrer le nom de son entraineur");
        String entraineur= "";
         entraineur = keyboard.nextLine();

        System.out.println("Entrer la couleur de son short. Vous avez le choix entre : 'bleu', 'orange' , 'vert','marron','rose' et 'jaune'");
        String couleurstr= "";
        couleurstr = keyboard.nextLine();
        Couleur couleur;
        switch(couleurstr){
            case "bleu":
            couleur=Couleur.Bleu;
            break;
            case "marron":
            couleur=Couleur.Marron;
            break;
            case "vert":
            couleur=Couleur.Vert;
            break;
            case "rose":
            couleur=Couleur.Rose;
            break;
            case "jaune":
            couleur=Couleur.Jaune;
            break;
            case "orange":
            couleur=Couleur.Orange;
            break;
            default:
            couleur=Couleur.Orange;
            
        }

        ajouterJoueurHomme(new JoueurHomme(nom, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, main, sponsor, entraineur, couleur));


    } 

public void creerManuellementUneJoueuse(){
    System.out.println("Entrer le nom de Naissance de la joueuse");
    String nom = "";
    Scanner keyboard = new Scanner(System.in);
    nom = keyboard.nextLine();

    System.out.println("Entrer le Nom courrant de la joueuse");
    String nomCourrant = "";
    nomCourrant = keyboard.nextLine();

    System.out.println("Entrer le prenom de la joueuse");
    String prenom = "";
    prenom = keyboard.nextLine();

    System.out.println("Entrer le surnom de la joueuse");
    String surnom = "";
    surnom = keyboard.nextLine();
    int anneeNaissance;
    int jourNaissance;
    int moisNaissance;
    do{
        System.out.println("Entrer l'annee de naissance de la joueuse");
        String anneeNaissancestr = "";
        anneeNaissancestr= keyboard.nextLine();
        try{
            anneeNaissance=Integer.valueOf(anneeNaissancestr);
        }catch(Exception e) {
            anneeNaissance=-1;
        }
    }while(anneeNaissance<0 );

    do{
        System.out.println("Entrer le mois de naissance de la joueuse");
        String moisNaissancestr = "";
        moisNaissancestr= keyboard.nextLine();
        try{
            moisNaissance=Integer.valueOf(moisNaissancestr);
        }catch(Exception e) {
            moisNaissance=-1;
        }
    }while(moisNaissance<1 || moisNaissance>12);

    do{
        System.out.println("Entrer le jour de naissance de la joueuse");
        String jourNaissancestr = "";
        jourNaissancestr= keyboard.nextLine();
        try{
            jourNaissance=Integer.valueOf(jourNaissancestr);
        }catch(Exception e) {
            jourNaissance=-1;
        }
    }while(jourNaissance<1 || jourNaissance>31);

    
    LocalDate dateNaissance = LocalDate.of(anneeNaissance, moisNaissance, jourNaissance);

    System.out.println("Entrer le lieu de naissance de la joueuse");
    String lieuNaissance = "";
    lieuNaissance = keyboard.nextLine();
    System.out.println("Entrer la nationalite de la joueuse");
    String nationalite= "";
    nationalite = keyboard.nextLine();
    System.out.println("Entrer la taille de la joueuse en cm");
    int taille;
    do{
        String taillestr = "";
        taillestr = keyboard.nextLine();
        try{
            taille = Integer.valueOf(taillestr);
        }catch(Exception e){
            System.out.println("Ceci ne correpond pas à une taille en cm");
            taille=-1;
        }
        
    }while(taille<0  );
    
    System.out.println("Entrer la masse de la joueuse en kg");
    String poidsstr= "";
    int poids;
    do{
        poidsstr = keyboard.nextLine();
        try{
            poids=Integer.valueOf(poidsstr);
        }catch(Exception e){
            poids=-1;
        }
         
    }while(poids<0 );
    
    System.out.println("Entrer la main de la joueuse. taper 'gauche' si elle est gauchere, entrer si elle est droitiere.");
    String mainstr= "";
    mainstr = keyboard.nextLine();
    Main main;
    if(mainstr.equals("gauche")){
        main=Main.Gauche;
    } else{
        main=Main.Droite;
    }
    System.out.println("Entrer le ou les sponsor(s) de la joueuse");
    String sponsor= "";
    sponsor = keyboard.nextLine();

    System.out.println("Entrer le nom de son entraineur");
    String entraineur= "";
     entraineur = keyboard.nextLine();

    System.out.println("Entrer la couleur de sa Jupe. Vous avez le choix entre : 'bleu', 'orange' , 'vert','marron','rose' et 'jaune'");
    String couleurstr= "";
    couleurstr = keyboard.nextLine();
    Couleur couleur;
    switch(couleurstr){
        case "bleu":
        couleur=Couleur.Bleu;
        break;
        case "marron":
        couleur=Couleur.Marron;
        break;
        case "vert":
        couleur=Couleur.Vert;
        break;
        case "rose":
        couleur=Couleur.Rose;
        break;
        case "jaune":
        couleur=Couleur.Jaune;
        break;
        case "orange":
        couleur=Couleur.Orange;
        break;
        default:
        couleur=Couleur.Orange;
        
    }

    ajouterJoueuse(new Joueuse(nom, nomCourrant, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, main, sponsor, entraineur, couleur));


} 



public void creerManuellementUnSpectateur(Match match){
    System.out.println("Entrer le nom du Spectateur");
        String nom = "";
        Scanner keyboard = new Scanner(System.in);
        nom = keyboard.nextLine();

        System.out.println("Entrer le prenom du Spectateur");
        String prenom = "";
        prenom = keyboard.nextLine();

        System.out.println("Entrer le surnom du Spectateurr");
        String surnom = "";
        surnom = keyboard.nextLine();
        int anneeNaissance;
        int jourNaissance;
        int moisNaissance;
        do{
            System.out.println("Entrer l'annee de naissance du Spectateur");
            String anneeNaissancestr = "";
            anneeNaissancestr= keyboard.nextLine();
            try{
                anneeNaissance=Integer.valueOf(anneeNaissancestr);
            }catch(Exception e) {
                anneeNaissance=-1;
            }
        }while(anneeNaissance<0 );

        do{
            System.out.println("Entrer le mois de naissance du Spectateur");
            String moisNaissancestr = "";
            moisNaissancestr= keyboard.nextLine();
            try{
                moisNaissance=Integer.valueOf(moisNaissancestr);
            }catch(Exception e) {
                moisNaissance=-1;
            }
        }while(moisNaissance<1 || moisNaissance>12);

        do{
            System.out.println("Entrer le jour de naissance du Spectateur");
            String jourNaissancestr = "";
            jourNaissancestr= keyboard.nextLine();
            try{
                jourNaissance=Integer.valueOf(jourNaissancestr);
            }catch(Exception e) {
                jourNaissance=-1;
            }
        }while(jourNaissance<1 || jourNaissance>31);

        
        LocalDate dateNaissance = LocalDate.of(anneeNaissance, moisNaissance, jourNaissance);

        System.out.println("Entrer le lieu de naissance du Spectateur");
        String lieuNaissance = "";
        lieuNaissance = keyboard.nextLine();
        System.out.println("Entrer la nationalite du Spectateur");
        String nationalite= "";
        nationalite = keyboard.nextLine();
        System.out.println("Entrer la taille du Spectateur en cm");
        int taille;
        do{
            String taillestr = "";
            taillestr = keyboard.nextLine();
            try{
                taille = Integer.valueOf(taillestr);
            }catch(Exception e){
                System.out.println("Ceci ne correpond pas à une taille en cm");
                taille=-1;
            }
            
        }while(taille<0  );
        
        System.out.println("Entrer la masse du Spectateur en kg");
        String poidsstr= "";
        int poids;
        do{
            poidsstr = keyboard.nextLine();
            try{
                poids=Integer.valueOf(poidsstr);
            }catch(Exception e){
                poids=-1;
            }
             
        }while(poids<0 );
        
       

        System.out.println("Entrer la couleur de sa chemise. Vous avez le choix entre : 'bleu', 'orange' , 'verte','marron','rose' et 'jaune'");
        String couleurstr= "";
        couleurstr = keyboard.nextLine();
        Couleur couleur;
        switch(couleurstr){
            case "bleu":
            couleur=Couleur.Bleu;
            break;
            case "marron":
            couleur=Couleur.Marron;
            break;
            case "verte":
            couleur=Couleur.Vert;
            break;
            case "rose":
            couleur=Couleur.Rose;
            break;
            case "jaune":
            couleur=Couleur.Jaune;
            break;
            case "orange":
            couleur=Couleur.Orange;
            break;
            default:
            couleur=Couleur.Orange;
            
        }

        this.billetterie.acheterBillet(new SpectateurTournoi(nom, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids), match);
        
       


    } 

    public void genererLeResteDesJoueurs(String genre){
        int nbJoueurDejaPresent=0;
        int nbJoueurs=0;
        JoueurHomme joueur =null;
        Joueuse joueuse=null;
        PersonneAleatoire generateur = new PersonneAleatoire();
        if(genre.equals("homme")){
            
            for(Joueur joueurTournois : this.joueurs){
                if(joueurTournois==null){
                    break;
                }else{
                    nbJoueurDejaPresent++;
                }
            }
            nbJoueurs=128-nbJoueurDejaPresent;
            
        
            for(int i = nbJoueurDejaPresent;i<nbJoueurDejaPresent+nbJoueurs;i++){
                try{
                    joueur=generateur.genererJoueurHomme();
                    joueur.ajouterStatJoueur();
                    Classement.ATP.ajouterJoueurClassement(joueur);
                    ajouterJoueurHomme(joueur);
                }catch(Exception e){
                    i--;
                }
                
                

            }
        } else{
            for(Joueur joueurTournois : this.joueuses){
                if(joueurTournois==null){
                    break;
                }else{
                    nbJoueurDejaPresent++;
                }
            }
            nbJoueurs=128-nbJoueurDejaPresent;
            
        
            for(int i = nbJoueurDejaPresent;i<nbJoueurDejaPresent+nbJoueurs;i++){
                try{
                    joueuse=generateur.genererJoueuse();
                    joueuse.ajouterStatJoueur();
                    Classement.WTA.ajouterJoueurClassement(joueuse);
                    ajouterJoueuse(joueuse);
                    
                }catch(Exception e){
                    i--;
                }
             
                
            }
        }

    }
}