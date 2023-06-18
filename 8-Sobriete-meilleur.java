package exercice;

import java.util.ArrayList;
import java.util.List;

public class Sobriete {
    
    public static List<String> solution(String str, List<Character> ordre) {
        String[] rep;
        List<String> reponse = new ArrayList<>();

        rep = str.split("\\s+|'");

        for (int i = 0; i < ordre.size(); i++) {
            char initial = ordre.get(i);
            for (int j = 0; j < rep.length; j++) {
                if (initial == rep[j].charAt(0)) {
                    String mot = rep[j];
                    reponse.add(mot);
                }
            }
        }

        for (int i = 0; i < rep.length; i++) {
            String mot = rep[i];
            if (!reponse.contains(mot)) {
                reponse.add(mot);
            }
        }

        return reponse;
    }
}