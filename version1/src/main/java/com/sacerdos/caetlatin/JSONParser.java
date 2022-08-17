package com.sacerdos.caetlatin;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.*;

public class JSONParser {
    Gson gson;
    String path, json;
    boolean found;

    JSONParser(){
        path = "version1/src/main/java/com/sacerdos/caetlatin/latin.json";
        json = "";
        gson = new Gson();
        found = false;
    }

    public void parseJSON(String key){
        try{
            json = Files.readString(Paths.get(path));
        }
        catch(Exception e){
                System.out.println("Don't you just hate errors? This one has to do with file reading. Did you delete my JSON file?");
                System.exit(1);
        }
        Lemma[] lemmas = gson.fromJson(json, Lemma[].class);

        for(Lemma lemma : lemmas){
            if(lemma.getLemma().equals(key)){
                System.out.println("\n***\n"+lemma.stringAssembler()+"\n***");
                found = true;
            }
        }
        if(!found){
            System.out.println("\nItem not found.");
        }
    }   
}
