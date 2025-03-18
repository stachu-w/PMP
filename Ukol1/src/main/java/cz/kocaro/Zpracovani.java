package cz.kocaro;

/**
 * Třída pro zpracování číselných údajů.
 */
public class Zpracovani {

    /**
     * Ověří, zda hodnota leží v otevřeném intervalu (bez krajních mezí).
     * @param odkud dolní mez (exclusive)
     * @param kam horní mez (exclusive)
     * @param value testovaná hodnota
     * @return true, pokud hodnota je mezi odkud a kam (bez krajních mezí)
     */
    public static boolean interval(int odkud, int kam, int value) {
        return value > odkud && value < kam;
    }

    /**
     * Vygeneruje pole hodnot v sestupném pořadí od odkud do kam s daným krokem.
     * @param kam cílová hodnota (nižší číslo)
     * @param odkud výchozí hodnota (vyšší číslo)
     * @param krok hodnota, o kterou se každým krokem snižuje
     * @return pole hodnot v sestupném pořadí
     */
    public static double[] vzorkySestupně(double kam, double odkud, double krok) {
        if (krok <= 0 || odkud < kam) return new double[0];

        int size = (int) Math.floor((odkud - kam) / krok) + 1;
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = odkud - i * krok;
        }
        return result;
    }
}
