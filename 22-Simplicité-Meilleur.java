package exercice;

import java.util.*;

public class SimpleM {
    public static List<String> solution(String texte, List<Character> ordre) {
        //Dictionnaire
    	Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < ordre.size(); i++) {
            orderMap.put(ordre.get(i), i);
        }
        
        // Sépare les mots de la liste à chaque espace
        String[] words = texte.split("\\s+");
        
        // Trie les mots 2 à 2 en fonction de l'ordre donnée dans le dictionnaire
        Arrays.sort(words, (word1, word2) -> {
            int minLength = Math.min(word1.length(), word2.length());
            for (int i = 0; i < minLength; i++) {
                char char1 = word1.charAt(i);
                char char2 = word2.charAt(i);
                
                // Si l'initiale n'est pas dans le dictionnaire, va à la fin de la liste
                int order1;
                if (orderMap.containsKey(char1)) {
                    order1 = orderMap.get(char1);
                } else {
                    order1 = Integer.MAX_VALUE;
                }
                int order2;
                if (orderMap.containsKey(char2)) {
                    order2 = orderMap.get(char2);
                } else {
                    order2 = Integer.MAX_VALUE;
                }
                
                if (order1 != order2) {
                    return order1 - order2;
                }
            }
            return word1.length() - word2.length();
        });
        
        // Retourne l'arrayList de mots triés
        return Arrays.asList(words);
    }
}
