package caetlatin;

import java.util.Scanner;

public class CaetLatin {
   Scanner sc;
   boolean keepGoing; // i'm good at naming variables i promise
   JSONParser jParse;
    CaetLatin(){
        sc = new Scanner(System.in);
        keepGoing = true;
        jParse = new JSONParser();
    }
    public void viewer(){
        System.out.println("*** CaetLatin ***\n*** Version 0.1.0 ***\nPress 'q' to quit at any time.");
        while(keepGoing){
            System.out.println("\nPlease enter a word to search:");
            String key = sc.nextLine().toLowerCase();
            if(!key.equals("q"))
                jParse.showKey(key);
            else
                keepGoing = false;
        }
    }
}
