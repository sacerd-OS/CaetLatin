package caetlatin;
public class Lemma {
    String lemma, definition, partOfSpeech;
    String genitive, declension, terminations;
    char gender; // M, F, N baby
    String secondPP, thirdPP, fourthPP; // PP = principle parts

    /* Thank the Latinists of the world after you read this mess of constructors. All of these forms are necessary to spell a word correctly.
     * And for irregulars? Good luck. Those are impossible.
     * Ultimately, I don't believe constructor overload is necessary with the JSON, but I've included them just in case I modify the program.
     * Because man was this a pain to write.*/
    // Other / Generic
    Lemma(String lemma, String definition, String partOfSpeech){
        this.lemma = lemma;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
    }
    // Noun
    Lemma(String lemma, String definition, String partOfSpeech, char gender, String genitive, String declension){
        this.lemma = lemma;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.gender = gender;
        this.genitive = genitive;
        this.declension = declension;
    }

    //Adjective
    Lemma(String lemma, String definition, String partOfSpeech, String terminations, String declension){
        this.lemma = lemma;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.terminations = terminations;
        this.declension = declension;
    }

    // Verb
    Lemma(String lemma, String definition, String partOfSpeech, String secondPP, String thirdPP, String fourthPP){
        this.lemma = lemma;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.secondPP = secondPP;
        this.thirdPP = thirdPP;
        this.fourthPP = fourthPP;
    }

    public String stringAssembler(){
        if(this.partOfSpeech.equals("noun")){
            return this.getPartOfSpeech() + "\n" + this.getLemma() + ", " + this.getGenitive() + " - " + this.getGender() + " (" + this.getDeclension() + ")\n" + this.getDefinition();
        }
        else if(this.partOfSpeech.equals("adjective")){
            return this.getPartOfSpeech() + "\n" + this.getLemma() + ", " + this.getTerminations() + " (" + this.getDeclension() + ")\n" + this.getDefinition();
        }
        else if(this.partOfSpeech.equals("verb")){
            return this.getPartOfSpeech() + "\n" + this.getLemma() + ", " + this.get2ndPP() + ", " + this.get3rdPP() + ", " + this.get4thPP() + "\n" + this.getDefinition();
        }
        else{
            return this.getPartOfSpeech() + "\n" + this.getLemma() +" \n" + this.getDefinition();
        }
        // there was a joke here but the code wouldnt compile if i kept it :(
    }

    /* Why didn't I major in another language
     * Again, probably not necessary (to be public) because of how the code is currently written
     * But if I want to make them public in the future, it'd be a pain to change.
     * I should also make setters, but this class is already so long for no reason
     */
    public String getLemma(){
        return lemma;
    }

    public String getDefinition(){
        return definition;
    }
    public String getPartOfSpeech(){
        return partOfSpeech;
    }

    public String getGenitive(){
        return genitive;
    }

    public String getTerminations(){
        return terminations;
    }
    
    public String getDeclension(){
        return declension;
    }

    public char getGender(){
        return gender;
    }

    public String get2ndPP(){
        return secondPP;
    }

    public String get3rdPP(){
        return thirdPP;
    }

    public String get4thPP(){
        return fourthPP;
    }
}
