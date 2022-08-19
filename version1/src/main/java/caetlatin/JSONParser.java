package caetlatin;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class JSONParser {
    Gson gson;
    String json;
    final String path = "version1/src/main/java/caetlatin/latin.json";
    boolean found;
    ArrayList<Lemma> lemmas;

    JSONParser(){
        json = "";
        gson = new Gson();
        lemmas = parseJSON();
    }

    public void findKey(String key){
        found = false;

        /*Simple linear search. May optimise in future, but currently not necessary*/
        for(Lemma lemma : lemmas){
            if(lemma.getLemma().equals(key)){
                System.out.println("\n***\n"+lemma.stringAssembler()+"***");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("\nItem not found.");
        }
    }

    private ArrayList<Lemma> parseJSON(){
        try{
            json = Files.readString(Paths.get(path));
        }
        catch(Exception e){
                System.out.println("Don't you just hate errors? This one has to do with file reading. Did you delete my JSON file?");
                System.exit(1);
        }
        ArrayList<Lemma> lemmas = gson.fromJson(json, new TypeToken<ArrayList<Lemma>>() {}.getType());

        return lemmas;
    }
    
    public ArrayList<Lemma> getLemmas(){
        return lemmas;
    }
}
