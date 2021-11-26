package sn.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class personne_aleatoire {

    public final ArrayList<JoueurHomme> nomJoueur = new ArrayList<JoueurHomme>();
    
    public ArrayList<JoueurHomme> save (){
        
    Path pathToFile = Paths.get("C:\\Users\\Ibrahima\\Desktop\\FakeNameGenerator.com_0c9da99d.csv");
    {
        try(BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.UTF_8))
        {
            String line =br.readLine() ;
            while(line !=null ) //lecture ligne par ligne
            {
                String[] attributes = line.split(",");//creation d'un tableau d'attribut
                JoueurHomme c = new JoueurHomme();
                c.setNomNaissance(attributes[1]);
                //c.setPrenom(attributes[1]);
                //c.setSurnom(attributes[3]);
                //c.setLieuNaissance(attributes[4]);
                //c.setDateNaissance(LocalDate(attributes));
                //c.setLieuNaissance(attributes[10]);
                nomJoueur.add(c);
                line = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
        return nomJoueur;
        
    
    }
    
}




    

