package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice {

    public static List<String> solution(String s, List<Character> o) {

        int i, j;
        List<String> lm = new ArrayList<>();
        String[] m = s.split("[^a-zA-Z0-9]+");

        if (s.length() == 0) { return lm; } else { lm = new ArrayList<>(Arrays.asList(m)); }

        for (i = 0; i < lm.size()-1; i++) {
            for (j = 0; j < lm.size()-1-i ; j++) {
                if (cwO(lm.get(j), lm.get(j+1), o) > 0) { String t = lm.get(j); lm.set(j, lm.get(j+1)); lm.set(j+1, t); }
            }
        }

        return lm;
    }

    public static int cwO(String m1, String m2, List<Character> o) {
        int l = Math.min(m1.length(), m2.length());
        
        for (int i = 0; i < l; i++) {
            char c1 = m1.charAt(i);
            char c2 = m2.charAt(i);
            
            if (c1 != c2) {
                int ix1 = o.indexOf(c1);
                int ix2 = o.indexOf(c2);
                
                if (ix1 != -1 && ix2 != -1) { return Integer.compare(ix1, ix2); } else if (ix1 != -1) { return -1; } else if (ix2 != -1) { return 1; } else { return -1; }
            }
        }
        
        return Integer.compare(m1.length(), m2.length());
    }  
}
