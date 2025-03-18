package cz.kocaro;

/**
 * Třída pro výpočet slovního hodnocení z průměru známek.
 */
public class VyhodnoceniProspechu {

    private static final String[] SLOVNI_HODNOCENI = {
            "výborně", "chvalitebně", "dobře", "dostatečně", "nedostatečně"
    };

    /**
     * Vrátí slovní hodnocení na základě známek.
     *
     * @param znamky pole známek (povolené hodnoty: 1–5)
     * @return slovní hodnocení
     * @throws IllegalArgumentException pokud jsou známky nevalidní (null, prázdné pole, nebo známky mimo rozsah 1–5)
     */
    public String prospech(int[] znamky) {
        if (znamky == null || znamky.length == 0) {
            throw new IllegalArgumentException("Známky nesmí být null nebo prázdné.");
        }

        double prumer = vypocitatPrumer(znamky);
        int index = (int) Math.round(prumer) - 1;

        if (index < 0 || index >= SLOVNI_HODNOCENI.length) {
            throw new IllegalArgumentException("Průměr známek je mimo platný rozsah (1–5).");
        }

        return SLOVNI_HODNOCENI[index];
    }


    /**
     * Spočítá průměr známek.
     *
     * @param znamky pole známek
     * @return průměr
     * @throws IllegalArgumentException pokud jsou známky mimo rozsah 1–5
     */
    private double vypocitatPrumer(int[] znamky) {
        int soucet = 0;
        for (int znamka : znamky) {
            if (znamka < 1 || znamka > 5) {
                throw new IllegalArgumentException("Známky musí být v rozsahu 1–5.");
            }
            soucet += znamka;
        }
        return (double) soucet / znamky.length;
    }
}