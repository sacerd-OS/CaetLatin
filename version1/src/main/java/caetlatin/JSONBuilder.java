package caetlatin;

import com.google.gson.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class JSONBuilder {
    Scanner sc;
    Gson gson;
    JSONParser jParse;
    ArrayList<Lemma> newJSON;
    final String path = "version1/src/main/java/caetlatin/latin.json";

    JSONBuilder(){
        sc = new Scanner(System.in);
        gson = new Gson();
        jParse = new JSONParser();
        newJSON = jParse.getLemmas();
    }
 
    public void buildJSON(){
        System.out.println("How many lemmas do you wish to add?");
        int num = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < num; i++){
            Lemma newLem = this.lemmaBuilder();
            if(newLem != null)
                newJSON.add(newLem);
        }
        String json = gson.toJson(newJSON);
        this.writeJSON(json);
    }

    private void writeJSON(String source){
        File file = new File(path);
        try{
            FileWriter writer = new FileWriter(file, false);
            writer.write(source);
            writer.close();
        }
        catch(Exception e){
            System.out.println("Oh god, you fucked up didn't you");
            System.exit(1);
        }
    }

    /* Why didn't I build an English dictionary. */
    private Lemma lemmaBuilder(){
        String partOfSpeech, definition, lemma;
        int numDef;

        System.out.println("Word: ");
        lemma = sc.nextLine().toLowerCase();

        if(jParse.findKey(lemma) != null){
            System.out.println("WARNING! Lemma already exists. Continue? Y/N");
            char ans = sc.nextLine().toUpperCase().charAt(0);
            if(ans == 'N'){
                return null;
            }
        }

        System.out.println("How many definitions?");
        numDef = sc.nextInt();
        sc.nextLine();
        definition = "";

        for(int i = 1; i <= numDef; i++){ // humans don't count from 0
            System.out.println("Definition number " + i + ": ");
            definition += i + ". " + sc.nextLine() + "\n";
        }

        System.out.println("Part of speech: ");
        partOfSpeech = sc.nextLine().toLowerCase();

        /* Cases for different parts of speech */
        //Noun
        if(partOfSpeech.equals("noun")){
            System.out.println("Gender: ");
            char gender = sc.nextLine().toUpperCase().charAt(0);

            System.out.println("Genitive: ");
            String genitive = sc.nextLine();

            System.out.println("Declension: ");
            String declension = sc.nextLine();

            return new Lemma(lemma, definition, partOfSpeech, gender, genitive, declension);
        }
        //Adjective
        else if(partOfSpeech.equals("adjective")){
            System.out.println("Terminations: ");
            String terminations = sc.nextLine();

            System.out.println("Declension: ");
            String declension = sc.nextLine();

            return new Lemma(lemma, definition, partOfSpeech, terminations, declension);
        }
        //Verb
        else if(partOfSpeech.equals("verb")){
            System.out.println("2nd Principle Part: ");
            String secondPP = sc.nextLine();

            System.out.println("3rd Principle Part: ");
            String thirdPP = sc.nextLine();

            System.out.println("4th Principle Part: ");
            String fourthPP = sc.nextLine();

            return new Lemma(lemma, definition, partOfSpeech, secondPP, thirdPP, fourthPP);
        }
        // Preposition, conjunction, adverb, etc...
        else{
            return new Lemma(lemma, definition, partOfSpeech);
        }
    }
}