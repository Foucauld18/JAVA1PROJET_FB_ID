
package sn.projet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PersonneAleatoire {
    private static String pathCSV="/Users/foucauldbglt/listePersonne.csv";

    
    public Joueuse genererJoueuse(){
        Joueuse joueuse = null;
        int ligneAleatoire = nbAleatoireBorne(0, 500);
        
        
        try
        {
            Main main[]= new Main[] {Main.Droite,Main.Gauche};
            Couleur couleurs[]= new Couleur[] {Couleur.Bleu,Couleur.Marron,Couleur.Vert,Couleur.Rose,Couleur.Jaune,Couleur.Orange};
            
                
           
            String nom="",prenom="",nationalite="",sponsor="",lieuNaissance="",surnom="",entraineur="",prenomf="";
            //csv file containing data

            //create BufferedReader to read csv file
            BufferedReader br = new BufferedReader( new FileReader(pathCSV));
            String strLine = "";
            StringTokenizer st = null;
            int lineNumber = 0, tokenNumber = 0;
            

            //read comma separated file line by line
            while( (strLine = br.readLine()) != null)
            {
                
                lineNumber++;
                if(lineNumber==ligneAleatoire){
               
                
                st = new StringTokenizer(strLine, ",");
                nom = st.nextToken();
                prenom = st.nextToken();
                prenomf=st.nextToken();
                surnom = st.nextToken();
                lieuNaissance = st.nextToken();
                entraineur=st.nextToken();
                
                nationalite = st.nextToken();
                sponsor = st.nextToken();
                
                
                
                break;
                }
            }
                
                
            LocalDate dateAnniversaire=LocalDate.of(nbAleatoireBorne(1980,2004),nbAleatoireBorne(1, 12),nbAleatoireBorne(1, 30));
            joueuse = new Joueuse(nom,prenomf,nom,surnom,dateAnniversaire,lieuNaissance,nationalite,nbAleatoireBorne(160, 200),nbAleatoireBorne(60, 80),main[nbAleatoireBorne(0,1)],sponsor,entraineur,couleurs[nbAleatoireBorne(0,5)]) ;
           return(joueuse);
        }catch(Exception e){
            
        }
        return(joueuse);
    }

  
    
    public JoueurHomme genererJoueurHomme(){
        
        JoueurHomme newJoueurHomme=null;
        
        
        int ligneAleatoire = nbAleatoireBorne(0, 500);
        
        
        try
        {
            Main main[]= new Main[] {Main.Droite,Main.Gauche};
            Couleur couleurs[]= new Couleur[] {Couleur.Bleu,Couleur.Marron,Couleur.Vert,Couleur.Rose,Couleur.Jaune,Couleur.Orange};
            
                
           
            String nom="",prenom="",nationalite="",sponsor="",lieuNaissance="",surnom="",entraineur="",prenomf="";
            //csv file containing data

            //create BufferedReader to read csv file
            BufferedReader br = new BufferedReader( new FileReader(pathCSV));
            String strLine = "";
            StringTokenizer st = null;
            int lineNumber = 0, tokenNumber = 0;
            

            //read comma separated file line by line
            while( (strLine = br.readLine()) != null)
            {
                
                lineNumber++;
                if(lineNumber==ligneAleatoire){
               
                
                st = new StringTokenizer(strLine, ",");
                nom = st.nextToken();
                prenom = st.nextToken();
                prenomf=st.nextToken();
                surnom = st.nextToken();
                lieuNaissance = st.nextToken();
                entraineur=st.nextToken();
                
                nationalite = st.nextToken();
                sponsor = st.nextToken();
                
                
                
                break;
                }
            }
                
                
            LocalDate dateAnniversaire=LocalDate.of(nbAleatoireBorne(1980,2004),nbAleatoireBorne(1, 12),nbAleatoireBorne(1, 30));
            newJoueurHomme = new JoueurHomme(nom,prenom,surnom,dateAnniversaire,lieuNaissance,nationalite,nbAleatoireBorne(160, 200),nbAleatoireBorne(60, 100),main[nbAleatoireBorne(0,1)],sponsor,entraineur,couleurs[nbAleatoireBorne(0,5)]) ;
           return(newJoueurHomme);
        }catch(Exception e){
            
        }
        return(newJoueurHomme);
    }

    public int nbAleatoireBorne(int min,int max){
        return(min + (int)(Math.random() * (max - min))+1);
    }

    public Spectateur genererSpectateur(){
        Spectateur spectateur=null;
        int ligneAleatoire = nbAleatoireBorne(0, 500);
        
        
        try
        {
            Main main[]= new Main[] {Main.Droite,Main.Gauche};
            Couleur couleurs[]= new Couleur[] {Couleur.Bleu,Couleur.Marron,Couleur.Vert,Couleur.Rose,Couleur.Jaune,Couleur.Orange};
            
                
           
            String nom="",prenom="",nationalite="",sponsor="",lieuNaissance="",surnom="",entraineur="",prenomf="";
            //csv file containing data

            //create BufferedReader to read csv file
            BufferedReader br = new BufferedReader( new FileReader(pathCSV));
            String strLine = "";
            StringTokenizer st = null;
            int lineNumber = 0, tokenNumber = 0;
            

            //read comma separated file line by line
            while( (strLine = br.readLine()) != null)
            {
                
                lineNumber++;
                if(lineNumber==ligneAleatoire){
               
                
                st = new StringTokenizer(strLine, ",");
                nom = st.nextToken();
                prenom = st.nextToken();
                prenomf=st.nextToken();
                surnom = st.nextToken();
                lieuNaissance = st.nextToken();
                entraineur=st.nextToken();
                nationalite = st.nextToken();
                sponsor = st.nextToken();
                
                
                
                break;
                }
            }
                
                
            LocalDate dateAnniversaire=LocalDate.of(nbAleatoireBorne(1980,2004),nbAleatoireBorne(1, 12),nbAleatoireBorne(1, 30));
            if(ligneAleatoire>250){
                spectateur = new Spectateur(nom,prenomf,surnom,dateAnniversaire,lieuNaissance,nationalite,nbAleatoireBorne(160, 200),nbAleatoireBorne(60, 100),couleurs[nbAleatoireBorne(0,5)]) ;
          
            }else{
                spectateur = new Spectateur(nom,prenom,surnom,dateAnniversaire,lieuNaissance,nationalite,nbAleatoireBorne(160, 200),nbAleatoireBorne(60, 100),couleurs[nbAleatoireBorne(0,5)]) ;
            }
           
           return(spectateur);
        }catch(Exception e){
            
        }
        return (spectateur);
    }
}
