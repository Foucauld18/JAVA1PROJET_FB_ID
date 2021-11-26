package sn.projet;
import java.time.LocalDate;
import java.util.Scanner;

public class UiTennis {

    public UiTennis(){};

    public void lancerUi(){
        ListeTournois listeTournoisJouee=new ListeTournois();
        Tournoi tournoi= new Tournoi(" ", " ", " ", " ");
        int indexTournois=-1;
        boolean boucleSimulateur=true;
        int nbTournoiCree=0;
        while(boucleSimulateur==true){
            
            
            nbTournoiCree = listeTournoisJouee.afficherListeTournois();
            if(nbTournoiCree>0){
                System.out.println("Pour créer un autre tournois taper 'creer' ou '0', pour séléctionner un tournois existant taper le numero du tournoi, pour Quitter taper 'quitter");
                

            } else{
                System.out.println("Pour continuer, créer un nouveau tournois taper 'creer',  sinon quitter en tapant 'quitter'");
            }





         

        boolean goodCommande = false;
        while (goodCommande == false) {
            System.out.println("");

            String commande = "";
            Scanner keyboard = new Scanner(System.in);
            commande = keyboard.nextLine();

            if (commande.equals("creer")||commande.equals("0")) {

                System.out.println("Entrer le nom du tournoi");
                String nomTournoi = "";
                Scanner keyboard2 = new Scanner(System.in);
                nomTournoi = keyboard2.nextLine();

                System.out.println("Entrer la ville du tournoi");
                String villeTournoi = "";
                Scanner keyboard3 = new Scanner(System.in);
                villeTournoi = keyboard3.nextLine();

                System.out.println("Entrer l'annee du tournoi'");
                String anneeTournoi = "";
                Scanner keyboard4 = new Scanner(System.in);
                anneeTournoi = keyboard4.nextLine();

                System.out.println("Entrer la surface du tournoi");
                String surfaceTournoi = "";
                Scanner keyboard5 = new Scanner(System.in);
                surfaceTournoi = keyboard5.nextLine();
                goodCommande = true;
                tournoi = new Tournoi(nomTournoi, villeTournoi, surfaceTournoi, anneeTournoi);
                listeTournoisJouee.ajouterUnTournoi(tournoi);
                for(int i=0;i<16;i++){//appeler methode qui genere des arbitres
                    Arbitre arbitre1 = new Arbitre("Bergerault", "Foucauld", "The goat", LocalDate.of(1999, 9, 4), "Metz", "Francaise", i, 70);
                    tournoi.ajouterArbitre(arbitre1);
                }
                indexTournois++;
            } else if (commande.equals("quitter")) {
                System.exit(0);
            } else{
                
                try{
                    indexTournois=Integer.valueOf(commande)-1;
                } catch(Exception e){
                    indexTournois=-1;
                    System.out.println("La commande entrée n'est pas bonne");
                }
                if(nbTournoiCree>0 && indexTournois<nbTournoiCree && indexTournois>-1){
                    goodCommande=true;
                    
                }
            }
        }//fin while
        
        if(listeTournoisJouee.listeTournoi[indexTournois].joueurs[127]==null || listeTournoisJouee.listeTournoi[indexTournois].joueuses[127]==null){
        System.out.println("1 - Pour générer automatiquement les joueurs et les joueuses taper 'auto' ");
        System.out.println("2 - Pour créer un ou plusieurs joueurs manuellement taper 'manuel' ");
        System.out.println("3 - Pour quitter taper 'quitter' ");
        goodCommande = false;
        while (goodCommande == false) {
            String commande = "";
            Scanner keyboard = new Scanner(System.in);
            commande = keyboard.nextLine();
            if(commande.equals("auto")||commande.equals("1")){
                goodCommande=true;
                //temporaire
                for(int i=0;i<128;i++){
                    JoueurHomme joueur1 = new JoueurHomme("Monfils"+String.valueOf(i), "Gael", "gab", LocalDate.of(1995, 1, 5),"Paris", "Français", i, 70, Main.Droite, "Nike", "Amelie", Couleur.Bleu);
                    Joueuse joueuse1 = new Joueuse("anjndsi", "Williams","Serena", "sw", LocalDate.of(1994, 1, 5), "New-york","Américaine", i, 69, Main.Gauche, "Adidas", "dad", Couleur.Marron);
                    Classement.ATP.ajouterJoueurClassement(joueur1);
                    Classement.WTA.ajouterJoueurClassement(joueuse1);
                    joueur1.ajouterStatJoueur();
                    joueuse1.ajouterStatJoueur();
                    tournoi.ajouterJoueurHomme(joueur1);
                    tournoi.ajouterJoueuse(joueuse1);
                }
                //Tu supprime le for au dessus et tu met ta foonction. Elle doit creer 128 joueurs et 128 joueuses.
                //paour chaque joueur il faut faire les ligne de code en dessous 2 pour les hommes et 2 pour les femmes
                /*
                joueur1.ajouterStatJoueur();
                    joueuse1.ajouterStatJoueur();
                    tournoi.ajouterJoueurHomme(joueur1);
                    tournoi.ajouterJoueuse(joueuse1);
                    */
                
            }else if(commande.equals("manuel")||commande.equals("2") ){
                goodCommande=true;
                boolean arretModeManuel=false;
                while(arretModeManuel==false){

                
                System.out.println("Pour ajouter un joueur taper 'h', pour ajouter une joueuse taper 'f', pour générer un joueur automatiquement appuyer sur entrer");
                String genre = "";
                genre = keyboard.nextLine();
                if(genre.equals("h")&&tournoi.joueurs[127]==null){
                    tournoi.creerManuellementUnJoueur();
                }else if(genre.equals("f")&&tournoi.joueuses[127]==null){
                    tournoi.creerManuellementUneJoueuse();
                }else{
                    //fonction auto
                }

                if(tournoi.joueurs[127]!=null){
                    System.out.println("Il n'y a plus de place pour le tounoi homme");
                } else if(tournoi.joueuses[127]!=null) {
                    System.out.println("Il n'y a plus de place pour le tounoi femme");}

                System.out.println("Pour créer un autre joueur/joueuse taper 'creer' sinon appuyer sur entre pour générer les autres joueurs du tounois ");
                arretModeManuel=true;
                String nouveau = "";
                nouveau = keyboard.nextLine();
                if(nouveau.equals("creer")){
                    arretModeManuel=false;
                }
            }}

            else if (commande.equals("quitter")||commande.equals("1")) {
                System.exit(0);
            }
           
        
        } 
        }

        

        listeTournoisJouee.listeTournoi[indexTournois].iniTableauMatch();
        Billetterie billetterie = new Billetterie(tournoi);
        billetterie.genererBilletsTournois();
        tournoi.setBilletterieTournoi(billetterie);

        

            String commande = "";
            Scanner keyboardenter = new Scanner(System.in);
            
        boolean boucle=true;
        while(boucle==true){
            System.out.println("---------------------------------------------------------- "+ listeTournoisJouee.listeTournoi[indexTournois].nomTournoi+" ----------------------------------------------------------");
            System.out.println("1- Jouer Tournois  | 2 Afficher Résultat Tournois | 3 - Afficher Classement ATP/WTA | 4- Obtenir informations sur la Billetterie | 5- Listes des participants & informations | 6-Gérer les Spéctateurs 7- Retour au Menu Tournois | 8- Quitter");
            System.out.println("");
            System.out.println("Entrer le numéro correspondant à ce que vous souhaiter faire");
            commande = keyboardenter.nextLine();
            int choix;
            int choixDeux=0;
            int choixTrois=0;
            int choixQuatre=0;
            int choixCinq=0;
            int choixSix=0;
            int classement;
            Match matchSelect;
            String commande1="";
            String commande2="";
            String commande3="";
            boolean boucleDeux=true;
            boolean boucleTrois=true;
            NiveauMatch tours[] = { NiveauMatch.premierTour, NiveauMatch.deuxiemeTour, NiveauMatch.troisiemeTour,
                NiveauMatch.huitiemeFinal, NiveauMatch.quartFinal, NiveauMatch.demiFinal, NiveauMatch.Final };
            try{
                choix=Integer.valueOf(commande);
            }catch(Exception e){
                choix=7;
            }
            switch(choix){
                case 1://jouer tournois
                System.out.println("---------------------------------------------------------- Jouer Tournoi ----------------------------------------------------------");
                boucleDeux=true;
                while(boucleDeux==true){
                    boucleDeux=false;
                    System.out.println("1- Générer Automatiquement le tournoi homme et joueur celui des femmes");
                    System.out.println("2- jouer le tournoi homme et générer automatiquement celui des femmes");
                    System.out.println("3- Générer Automatiquement le tournoi homme & femme");
                    System.out.println("4- jouer les tournoi homme et femme");
                    System.out.println("5- Revenir au menu précédent");
                    commande = keyboardenter.nextLine();
                    try{
                        choixDeux=Integer.valueOf(commande);
                    }catch(Exception e){
                        choixDeux=7;//boucler
                    }
                    switch(choixDeux){
                        case 1:listeTournoisJouee.listeTournoi[indexTournois].jouerTournois(true, false);
                    break;
                    case 2:listeTournoisJouee.listeTournoi[indexTournois].jouerTournois(false, true);
                    break;
                    case 3:listeTournoisJouee.listeTournoi[indexTournois].jouerTournois(true, true);
                    break;
                    case 4:listeTournoisJouee.listeTournoi[indexTournois].jouerTournois(false, false);
                    break;
                    case 5:
                    break;
                    default:boucleDeux=true;//Le choix ne correspond à la demande on redemande
                    }
                }
                
                break;
                case 2://Afficher resultats tournois
                System.out.println("------------------------------------------Afficher les résultats du Tournoi ----------------------------------------------");
                boucleDeux=true;
                while(boucleDeux==true){
                    
                    System.out.println("---------- Résutat " + tournoi.ville+" "+tournoi.annee+" ----------");
                    System.out.println("1- Afficher résultat tournoi Homme simple");
                    System.out.println("2- Afficher résultat tournoi Femme simple");
                    System.out.println("3- Menu Précédent");

                    commande = keyboardenter.nextLine();
                    try{
                        choixDeux=Integer.valueOf(commande);
                    }catch(Exception e){
                        choixDeux=7;//boucler
                    }
                    switch(choixDeux){
                    case 1://afficher tournoi Homme
                    listeTournoisJouee.listeTournoi[indexTournois].afficherMatchTournoi("h");
                    boucleTrois=true;
                    while(boucleTrois==true){
                        
                        System.out.println("--------------------");
                        System.out.println("1 - Pour retourner au menu précédent, taper 'menu' ");
                        System.out.println("2 - Pour afficher le détail d'un match appuyer sur entrer");
                        commande = keyboardenter.nextLine();
                        if(commande.equals("menu")||commande.equals("1")){
                            boucleTrois=false;
                        }else{
                            
                            do{
                                System.out.println("Quelle est le tour de votre match? taper 1 pour le premier tour [...] taper 7 pour la final");
                                commande1 = keyboardenter.nextLine();
                                try{
                                    choixTrois=Integer.valueOf(commande1);
                                }catch(Exception e){
                                    choixTrois=7;//boucler
                                }
                            } while(choixTrois<1||choixTrois>7);

                            listeTournoisJouee.listeTournoi[indexTournois].afficherMatchTour(tours[choixTrois-1],"homme");
                            
                            do{
                                System.out.println("Quelle est le numero de votre match? ");
                                commande1 = keyboardenter.nextLine();
                                try{
                                    choixQuatre=Integer.valueOf(commande1);
                                }catch(Exception e){
                                    choixQuatre=7;//boucler
                                }
                            } while(choixQuatre<1||choixQuatre>listeTournoisJouee.listeTournoi[indexTournois].index(choixTrois-1,"fin"));
                             matchSelect =listeTournoisJouee.listeTournoi[indexTournois].selectionnerUnMatch(choixTrois,choixQuatre,"h");
                            matchSelect.afficherInfomationMatch();
                            if(matchSelect.vainqueurMatch!=null){

                            
                            do{
                                System.out.println("1- Avoir plus d'information sur joueur le  1 | 2- Avoir plus d'information sur le joueur 2 | 3- Menu précédent");
                                commande1 = keyboardenter.nextLine();
                                try{
                                    choixTrois=Integer.valueOf(commande1);
                                }catch(Exception e){
                                    choixTrois=7;//boucler
                                }
                            } while(choixTrois<1||choixTrois>3);
                            if(choixTrois==3 ){

                            }
                            else{
                                System.out.println("");
                                
                                classement=Classement.ATP.obtenirClassementJoueur(matchSelect.joueurs[choixTrois-1]);
                                if(classement>0){
                                    System.out.println("-------- Informations Joueur--------");
                                    matchSelect.joueurs[choixTrois].afficherInformationsJoueur(classement);
                                    System.out.println("");
                                System.out.println("-------- Statistiques Personnel Joueur--------");
                                matchSelect.joueurs[choixTrois].statJoueur.afficherStat();
                                }
                                
                                
                            }
                        }else {System.out.println("Impossible de voir plus de détail sur ce match car il n'a pas encore été joué");

                    }}
                    }
                    break;
                     case 2://afficher tournoi femme
                     listeTournoisJouee.listeTournoi[indexTournois].afficherMatchTournoi("f");
                     boucleTrois=true;
                    while(boucleTrois==true){
                        
                        System.out.println("--------------------");
                        System.out.println("1 - Pour retourner au menu précédent, taper 'menu' ");
                        System.out.println("2 - Pour afficher le détail d'un match appuyer sur entrer");
                        commande = keyboardenter.nextLine();
                        if(commande.equals("menu")||commande.equals("1")){
                            boucleTrois=false;
                        }else{
                            
                            do{
                                System.out.println("Quelle est le tour de votre match? taper 1 pour le premier tour [...] taper 7 pour la final");
                                commande1 = keyboardenter.nextLine();
                                try{
                                    choixTrois=Integer.valueOf(commande1);
                                }catch(Exception e){
                                    choixTrois=7;//boucler
                                }
                            } while(choixTrois<1||choixTrois>7);

                            listeTournoisJouee.listeTournoi[indexTournois].afficherMatchTour(tours[choixTrois-1],"femme");
                            
                            do{
                                System.out.println("Quelle est le numero de votre match? ");
                                commande1 = keyboardenter.nextLine();
                                try{
                                    choixQuatre=Integer.valueOf(commande1);
                                }catch(Exception e){
                                    choixQuatre=7;//boucler
                                }
                            } while(choixQuatre<1||choixQuatre>listeTournoisJouee.listeTournoi[indexTournois].index(choixTrois-1,"fin"));
                             matchSelect =listeTournoisJouee.listeTournoi[indexTournois].selectionnerUnMatch(choixTrois,choixQuatre,"f");
                            matchSelect.afficherInfomationMatch();

                            if(matchSelect.vainqueurMatch!=null){

                            
                            do{
                                System.out.println("1- Avoir plus d'information sur joueur le  1 | 2- Avoir plus d'information sur le joueur 2 | 3- Menu précédent");
                                commande1 = keyboardenter.nextLine();
                                try{
                                    choixTrois=Integer.valueOf(commande1);
                                }catch(Exception e){
                                    choixTrois=7;//boucler
                                }
                            } while(choixTrois<1||choixTrois>3);
                            if(choixTrois==3 ){

                            }
                            else{
                                System.out.println("");
                                System.out.println("-------- Informations Joueuse--------");
                                classement=Classement.WTA.obtenirClassementJoueur(matchSelect.joueurs[choixTrois-1]);
                                if(classement>0){
                                    matchSelect.joueurs[choixTrois].afficherInformationsJoueur(classement);
                                    System.out.println("");
                                System.out.println("-------- Statistiques Personnel Joueuse--------");
                                matchSelect.joueurs[choixTrois].statJoueur.afficherStat();
                                }
                                
                                
                            }
                        }else {System.out.println("Impossible de voir plus de détail sur ce match car il n'a pas encore été joué");

                        }}
                    }
                    break;
                    case 3: boucleDeux=false;
                    break;
                    default : boucleDeux=true;

                    }
                    

                }
               

                break;
                case 3://Affciher ATP/WTA
                System.out.println("-------------------------------------------------------Classement ATP/WTA ------------------------------------------------------");
                boucleDeux=true;
                while(boucleDeux==true){
                    
                    System.out.println("---------- Classement Joueurs ----------");
                    System.out.println("1- ATP");
                    System.out.println("2- WTA");
                    System.out.println("3- Menu précedent");
                    System.out.println("Quelle classment souhaiter vous consulter");

                    commande = keyboardenter.nextLine();
                    try{
                        choixDeux=Integer.valueOf(commande);
                    }catch(Exception e){
                        choixDeux=7;//boucler
                    }
                    switch(choixDeux){
                    case 1:
                    Classement.ATP.updateClassement();
                    Classement.ATP.afficherClassement();
                    boucleTrois=true;
                    while(boucleTrois==true){
                        boucleTrois=false;
                        System.out.println("--------------------");
                        System.out.println("Taper 0 pour aller au menu précédent ou taper le numéro d'un joueur pour obtenir plus d'informations sur lui. ");
                        commande = keyboardenter.nextLine();
                        try{
                            choixTrois=Integer.valueOf(commande);
                        }catch(Exception e){
                            choixTrois=-1;//boucler
                        }
                        switch(choixDeux){
                        case -1://reposer question
                        boucleTrois=true;
                        break;
                        case 0://menu précédent
                        boucleDeux=true;
                        break;
                        default : 
                        if(choixTrois<128 && choixTrois>0){//0<choix trois<128
                            System.out.println("");
                            System.out.println("-------- Informations Joueurs--------");
                            Classement.ATP.joueurs[choixTrois-1].afficherInformationsJoueur(Classement.ATP.obtenirClassementJoueur(Classement.ATP.joueurs[choixTrois-1]));
                            System.out.println("");
                            System.out.println("-------- Statistiques Personnel Joueur--------");
                            Classement.ATP.joueurs[choixTrois-1].statJoueur.afficherStat();
                        }else if (choixTrois==0){}
                        else{
                            System.out.println("Aucun joueur ne correspond à ce numéro.");
                            boucleTrois=true;
                        }
    
                        
                        
    
                    }}
                    break;
                    case 2:
                     Classement.WTA.updateClassement();
                     Classement.WTA.afficherClassement();
                     boucleTrois=true;
                    while(boucleTrois==true){
                        boucleTrois=false;
                        System.out.println("--------------------");
                        System.out.println("Taper 0 pour aller au menu précédent ou taper le numéro d'un joueur pour obtenir plus d'informations sur lui. ");
                        commande = keyboardenter.nextLine();
                        try{
                            choixTrois=Integer.valueOf(commande);
                        }catch(Exception e){
                            choixTrois=-1;//boucler
                        }
                        switch(choixDeux){
                        case -1://reposer question
                        boucleTrois=true;
                        break;
                        case 0://menu précédent
                        boucleDeux=true;
                        break;
                        default : 
                        if(choixTrois<128 && choixTrois>0){//0<choix trois<128
                            System.out.println("");
                            System.out.println("-------- Informations Joueurs--------");
                            Classement.WTA.joueurs[choixTrois-1].afficherInformationsJoueur(Classement.WTA.obtenirClassementJoueur(Classement.WTA.joueurs[choixTrois-1]));
                            System.out.println("");
                            System.out.println("-------- Statistiques Personnel Joueur--------");
                            Classement.WTA.joueurs[choixTrois-1].statJoueur.afficherStat();
                        }else if (choixTrois==0){}
                        else{
                            System.out.println("Aucun joueur ne correspond à ce numéro.");
                            boucleTrois=true;
                        }
    
                        
                        
    
                    }}
                    break;
                    case 3: 
                    boucleDeux=false;
                    break;
                    default : boucleDeux=true;
                    }
                }
                break;
                case 4://afficher information billeterie
                System.out.println("---------------------------------------------------------- Billetterie ----------------------------------------------------------");
                listeTournoisJouee.listeTournoi[indexTournois].billetterie.afficherInformationsBilletterie();
                break;
                case 5://aficher liste des participants
                System.out.println("---------------------------------------------------------- Participants ----------------------------------------------------------");
                boucleDeux=true;
                while(boucleDeux==true){
                    boucleDeux=false;
                    System.out.println("---------- Listes Participants " + tournoi.ville+" "+tournoi.annee+" ----------");
                    System.out.println("1- Afficher la liste des joueurs participants");
                    System.out.println("2- Afficher la liste des joueuses participantes");
                    System.out.println("3- Menu Précédent");
                    commande = keyboardenter.nextLine();
                    try{
                        choixDeux=Integer.valueOf(commande);
                    }catch(Exception e){
                        choixDeux=7;//boucler
                    }
                    switch(choixDeux){
                    case 1://hommes
                    System.out.println("--------------------------------------------Hommes ----------------------------------------------");
                    listeTournoisJouee.listeTournoi[indexTournois].afficherJoueurs();
                    boucleTrois=true;
                    while(boucleTrois==true){
                        boucleTrois=false;
                        System.out.println("--------------------");
                        System.out.println("Taper 0 pour aller au menu précédent ou taper le numéro d'un joueur pour obtenir plus d'informations sur lui. ");
                        commande = keyboardenter.nextLine();
                        try{
                            choixTrois=Integer.valueOf(commande);
                        }catch(Exception e){
                            choixTrois=-1;//boucler
                        }
                        switch(choixDeux){
                        case -1://reposer question
                        boucleTrois=true;
                        break;
                        case 0://menu précédent
                        boucleTrois=false;
                        break;
                        default : 
                        if(choixTrois<128 && choixTrois>0){//0<choix trois<128
                            System.out.println("");
                            System.out.println("-------- Informations Joueurs--------");
                            listeTournoisJouee.listeTournoi[indexTournois].joueurs[choixTrois-1].afficherInformationsJoueurHomme(Classement.ATP.obtenirClassementJoueur(listeTournoisJouee.listeTournoi[indexTournois].joueurs[choixTrois-1]));
                            System.out.println("");
                            System.out.println("-------- Statistiques Personnel Joueur--------");
                            listeTournoisJouee.listeTournoi[indexTournois].joueurs[choixTrois-1].statJoueur.afficherStat();
                        } else if (choixTrois==0){}
                        else
                        {
                            System.out.println("Aucun joueur ne correspond à ce numéro.");
                            boucleTrois=true;
                        }
    
                        
                        
    
                    }}
                    break;
                    case 2://femmes
                    System.out.println("----------------------------------------------Femmes----------------------------------------------");
                    listeTournoisJouee.listeTournoi[indexTournois].afficherJoueuses();
                    boucleTrois=true;
                    while(boucleTrois==true){
                        boucleTrois=false;
                        System.out.println("--------------------");
                        System.out.println("Taper 0 pour aller au menu précédent ou taper le numéro d'un joueur pour obtenir plus d'informations sur lui. ");
                        commande = keyboardenter.nextLine();
                        try{
                            choixTrois=Integer.valueOf(commande);
                        }catch(Exception e){
                            choixTrois=-1;//boucler
                        }
                        switch(choixDeux){
                        case -1://reposer question
                        boucleTrois=true;
                        break;
                        case 0://menu précédent
                        boucleTrois=false;
                        break;
                        default : 
                        if(choixTrois<128 && choixTrois>0){//0<choix trois<128
                            System.out.println("");
                            System.out.println("-------- Informations Joueurs--------");
                            listeTournoisJouee.listeTournoi[indexTournois].joueuses[choixTrois-1].afficherInformationsJoueuse(Classement.WTA.obtenirClassementJoueur(listeTournoisJouee.listeTournoi[indexTournois].joueuses[choixTrois-1]));
                            System.out.println("");
                            System.out.println("-------- Statistiques Personnel Joueur--------");
                            listeTournoisJouee.listeTournoi[indexTournois].joueuses[choixTrois-1].statJoueur.afficherStat();
                        }else if (choixTrois==0){}
                        else{
                            System.out.println("Aucun joueur ne correspond à ce numéro.");
                            boucleTrois=true;
                        }
    
                        
                        
    
                    }}
                    break;
                    case 3: break;//retour
                    default : boucleDeux=true;

                    }
                    

                }
                break;
                case 6://Gérer les Spectateurs
                System.out.println("---------------------------------------------------------- Gestion des Spéctateurs ----------------------------------------------------------");
                    boucleDeux=true;
                    while(boucleDeux==true){
                        System.out.println("1- Créer un spectateur | 2- Afficher la liste des spectateurs | 3- Générer automatiquement des Spéctateurs | 4- Menu Précédent");
                        commande = keyboardenter.nextLine();
                        try{
                            choixDeux=Integer.valueOf(commande);
                        }catch(Exception e){
                            choixDeux=-1;//boucler
                        }
                        switch(choixDeux){
                        case 1:
                        
                        do{
                            System.out.println("Quelle est le tour du match auquel vous voulez ajouter un spectateur? taper 1 pour le premier tour [...] taper 7 pour la final");
                            commande1 = keyboardenter.nextLine();
                            try{
                                choixTrois=Integer.valueOf(commande1);
                            }catch(Exception e){
                                choixTrois=7;//boucler
                            }
                        } while(choixTrois<1||choixTrois>7);
                        int sexe=0;
                        do{
                        System.out.println("1- Tournoi Homme | 2- Tournois Femme");
                        commande1 = keyboardenter.nextLine();
                        
                        try{
                            sexe=Integer.valueOf(commande1);
                        }catch(Exception e){
                            sexe=7;//boucler
                        }
                    } while(sexe<1||sexe >2);


                        listeTournoisJouee.listeTournoi[indexTournois].afficherMatchTour(tours[choixTrois-1],"homme");
                        
                        do{
                            System.out.println("Quelle est le numero de votre match? ");
                            commande1 = keyboardenter.nextLine();
                            try{
                                choixQuatre=Integer.valueOf(commande1);
                            }catch(Exception e){
                                choixQuatre=7;//boucler
                            }
                        } while(choixQuatre<1||choixQuatre>listeTournoisJouee.listeTournoi[indexTournois].index(choixTrois-1,"fin"));
                        if(sexe==1){
                            matchSelect =listeTournoisJouee.listeTournoi[indexTournois].selectionnerUnMatch(choixTrois,choixQuatre,"h");
                        }else{
                            matchSelect =listeTournoisJouee.listeTournoi[indexTournois].selectionnerUnMatch(choixTrois,choixQuatre,"f");
                        }
                        
                        matchSelect.afficherInfomationMatch();
                        if(matchSelect.vainqueurMatch==null){
                            listeTournoisJouee.listeTournoi[indexTournois].creerManuellementUnSpectateur(matchSelect);
                        }else{
                            System.out.println("Vous ne pouvez pas ajouter de spéctateur à ce match car il a déjà eu lieu.");
                        }
                        
                        break;
                        case 2:
                        listeTournoisJouee.listeTournoi[indexTournois].billetterie.afficherSpectateursEtBillets();
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("1- Acheter un billet pour un spectateur 2- Menu précédent ");
                        
                        do{
                            commande = keyboardenter.nextLine();
                            try{
                                choixCinq=Integer.valueOf(commande);
                            }catch(Exception e){
                                choixCinq=7;//boucler
                            }
                        } while(choixCinq<1||choixQuatre>2);
                        if(choixCinq==1){
                            System.out.println("A quel spectateur souhaitez-vous acheté un billet? Entrer son numéro.");
                            commande = keyboardenter.nextLine();
                            do{
                                commande = keyboardenter.nextLine();
                                try{
                                    choixSix=Integer.valueOf(commande);
                                }catch(Exception e){
                                    choixCinq=listeTournoisJouee.listeTournoi[indexTournois].billetterie.getNbSpectateur();//boucler
                                }
                            } while(choixSix<1||choixSix>listeTournoisJouee.listeTournoi[indexTournois].billetterie.getNbSpectateur());

                            do{
                                System.out.println("Quelle est le tour du match auquel vous voulez ajouter ce spectateur? taper 1 pour le premier tour [...] taper 7 pour la final");
                                commande1 = keyboardenter.nextLine();
                                try{
                                    choixTrois=Integer.valueOf(commande1);
                                }catch(Exception e){
                                    choixTrois=7;//boucler
                                }
                            } while(choixTrois<1||choixTrois>7);

                            sexe=0;
                            do{
                            System.out.println("1- Tournoi Homme | 2- Tournois Femme");
                            commande1 = keyboardenter.nextLine();
                            
                            try{
                                sexe=Integer.valueOf(commande1);
                            }catch(Exception e){
                                sexe=7;//boucler
                            }
                        } while(sexe<1||sexe >2);
                        do{
                            System.out.println("Quelle est le numero de votre match? ");
                            commande1 = keyboardenter.nextLine();
                            try{
                                choixQuatre=Integer.valueOf(commande1);
                            }catch(Exception e){
                                choixQuatre=7;//boucler
                            }
                        } while(choixQuatre<1||choixQuatre>listeTournoisJouee.listeTournoi[indexTournois].index(choixTrois-1,"fin"));
                        if(sexe==1){
                             matchSelect =listeTournoisJouee.listeTournoi[indexTournois].selectionnerUnMatch(choixTrois,choixQuatre,"h");
                        }else{
                             matchSelect =listeTournoisJouee.listeTournoi[indexTournois].selectionnerUnMatch(choixTrois,choixQuatre,"f");
                        }
                        matchSelect.afficherInfomationMatch();
                        
                        if(matchSelect.vainqueurMatch==null){
                            listeTournoisJouee.listeTournoi[indexTournois].billetterie.acheterBillet(listeTournoisJouee.listeTournoi[indexTournois].billetterie.selectSpectateur(choixSix), matchSelect);
                        }else{
                            System.out.println("Vous ne pouvez pas ajouter de spéctateur à ce match car il a déjà eu lieu.");
                        }
                    }
                        break;
                        case 3:
                        break;
                        case 4://retour menu
                        boucleDeux=false;
                        break;
                        default:
                    }}

                    
                    
                break;
               
                
                case 7:boucle=false;
                break;
                case 8: 
                boucleSimulateur=false; 
                System.exit(0);
                break;
                default : 
            }

        }

        





        System.out.println(tournoi.nomTournoi);
        System.out.println(tournoi.joueurs[0]);
    }
    
}
    }

    

