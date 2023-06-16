package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        List<String> listeTrier = new ArrayList<>();
        List<String> mots = new ArrayList<>();
        List<String> inconnus = new ArrayList<>();

        if (str.length() == 0) {
            return List.of();
        }

        mots = new ArrayList<>(Arrays.asList(str.split("[^a-zA-Z0-9]+")));
        inconnus.addAll(mots);

        for (char car : ordre) {
            for (String mot : mots) {
                if (car == mot.charAt(0)) {
                    listeTrier.add(mot);
                    inconnus.remove(mot);
                }
            }
        }

        listeTrier.addAll(inconnus);

        return listeTrier;
    }

}