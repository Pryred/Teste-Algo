package exercice;

import java.util.List;
import java.util.ArrayList;

public class simplicite_pire {
    public static List<String> solution(String str, List<Character> ordre) {
        String[] split = str.split(" ");
        List<String> result = new ArrayList<>();

        for (char c : ordre) {
            for (String word : split) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == c) {
                        result.add(word);
                        break;
                    }
                }
            }
        }

        return result;
    }
}