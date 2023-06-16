import java.util.List;
import java.util.ArrayList;

public class sobrietemeilleur {
	/**
     * Trie les mots d'une phrase selon un ordre spécifié en utilisant le tri fusion.
     *
     * @param pfPhrase La chaîne de caractères contenant les mots à trier.
     * @param pfOrdre  La liste des caractères spécifiant l'ordre de tri.
     * @return Une liste contenant les mots triés selon l'ordre spécifié.
     */
	public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = diviserMots(str);
        triFusion(mots, ordre);
        
        return mots;
    }

    /**
	 * Divise une chaîne de caractères en mots individuels.
	 *
	 * @param pfPhrase La chaîne de caractères à diviser en mots.
	 * @return Une liste contenant les mots individuels extraits de la phrase.
	 */
	public static List<String> diviserMots(String pfPhrase) {
		List<String> mots = new ArrayList<>();
		StringBuilder motActuel = new StringBuilder();

		for (int i = 0; i < pfPhrase.length(); i++) {
			char charSuivant = pfPhrase.charAt(i);
			if (Character.isLetter(charSuivant)) {
				motActuel.append(charSuivant);
			} else if (motActuel.length() > 0) {
				mots.add(motActuel.toString());
				motActuel.setLength(0);
			}
		}

		if (motActuel.length() > 0) {
			mots.add(motActuel.toString());
		}
		return mots;
	}

    /**
     * Trie une liste de mots selon l'ordre spécifié en utilisant le tri fusion.
     *
     * @param mots     La liste de mots à trier.
     * @param pfOrdre  La liste des caractères spécifiant l'ordre de tri.
     */
    private static void triFusion(List<String> mots, List<Character> pfOrdre) {
        if (mots.size() <= 1) {
            return;
        }
        int milieu = mots.size() / 2;
        List<String> moitieGauche = new ArrayList<>(mots.subList(0, milieu));
        List<String> moitieDroite = new ArrayList<>(mots.subList(milieu, mots.size()));
        triFusion(moitieGauche, pfOrdre);
        triFusion(moitieDroite, pfOrdre);
        fusionner(moitieGauche, moitieDroite, mots, pfOrdre);
    }

    /**
     * Fusionne deux moitiés triées d'une liste de mots en utilisant l'ordre spécifié.
     *
     * @param moitieGauche   La moitié gauche triée.
     * @param moitieDroite   La moitié droite triée.
     * @param mots           La liste de mots à fusionner.
     * @param pfOrdre        La liste des caractères spécifiant l'ordre de tri.
     */
    private static void fusionner(List<String> moitieGauche, List<String> moitieDroite,
                                  List<String> mots, List<Character> pfOrdre) {
        int indexGauche = 0;
        int indexDroite = 0;
        int indexMots = 0;

        while (indexGauche < moitieGauche.size() && indexDroite < moitieDroite.size()) {
            String motGauche = moitieGauche.get(indexGauche);
            String motDroite = moitieDroite.get(indexDroite);

            char charGauche = motGauche.charAt(0);
            char charDroite = motDroite.charAt(0);

            int indexOrdreGauche = pfOrdre.indexOf(charGauche);
            int indexOrdreDroite = pfOrdre.indexOf(charDroite);

            if (indexOrdreGauche <= indexOrdreDroite) {
                mots.set(indexMots, motGauche);
                indexGauche++;
            } else {
                mots.set(indexMots, motDroite);
                indexDroite++;
            }
            indexMots++;
        }
        while (indexGauche < moitieGauche.size()) {
            mots.set(indexMots, moitieGauche.get(indexGauche));
            indexGauche++;
            indexMots++;
        }
        while (indexDroite < moitieDroite.size()) {
            mots.set(indexMots, moitieDroite.get(indexDroite));
            indexDroite++;
            indexMots++;
        }
    }
}