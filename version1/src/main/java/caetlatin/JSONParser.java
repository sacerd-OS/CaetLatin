package caetlatin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class JSONParser {
    Gson gson;
    String json;
    InputStream path = getClass().getClassLoader().getResourceAsStream("latin.json");
    boolean found;
    ArrayList<Lemma> lemmas;

    JSONParser(){
        json = "";
        gson = new Gson();
        lemmas = parseJSON();
    }

    public void showKey(String key){
        Lemma l = this.findKey(key);

        if(l != null){
            System.out.println("\n***\n"+l.stringAssembler()+"***");

        }
        else{
            System.out.println("Item not found.");
        }
    }
    public Lemma findKey(String key){
        /*Simple linear search. May optimise in future, but currently not necessary*/
        for(Lemma lemma : lemmas){
            if(lemma.getLemma().equals(key)){
                return lemma;
            }
        }
        return null;
    }

    private ArrayList<Lemma> parseJSON(){
        try{
            json = this.read(path);
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
    private String read(InputStream i){
        Scanner s = new Scanner(i);
        String r = s.useDelimiter("\\Z").next();
        s.close();

        return r;
    }
}
