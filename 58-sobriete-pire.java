package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {

    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> lstMots = new ArrayList<>();
        String[] mots = texte.split("[^a-zA-Z0-9]+");

        for (char car : ordre) {
            for (String mot : mots) {
                if (!mot.isEmpty()) {
                
                if (mot.charAt(0) == car) {
                    lstMots.add(mot);
                }
            }
            }
        }

        if (lstMots.size() < mots.length) {
            for (String mot : mots) {
                if (!lstMots.contains(mot)) {
                    lstMots.add(mot);
                }
            }
        }

        return lstMots;
    }
}
