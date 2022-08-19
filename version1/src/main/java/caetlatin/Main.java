package caetlatin;
class Main{
    public static void main(String args[]){
        boolean build = false; // true = enter build mode; false = enter dictionary mode

        if(build){
            JSONBuilder j = new JSONBuilder();
            j.buildJSON();
        }

        else{
            CaetLatin caet = new CaetLatin();
            caet.viewer();
        }
    }
}