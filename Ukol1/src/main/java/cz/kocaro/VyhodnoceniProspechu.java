package cz.kocaro;

/**
 * Třída pro výpočet slovního hodnocení z průměru známek.
 */
public class VyhodnoceniProspechu {

    private final String[] slovniHodnoceni = {
            "výborně", "chvalitebně", "dobře", "dostatečně", "nedostatečně"
    };

    /**
     * Vrátí slovní hodnocení na základě známek.
     * @param znamky pole známek
     * @return slovní hodnocení
     */
    public String prospech(int[] znamky) {
        if (znamky == null || znamky.length == 0) {
            return "bez hodnocení";
        }

        double prumer = prumer(znamky);
        int index = (int) Math.round(prumer) - 1;
        if (index < 0) index = 0;
        if (index >= slovniHodnoceni.length) index = slovniHodnoceni.length - 1;
        return slovniHodnoceni[index];
    }

    /**
     * Spočítá průměr známek.
     * @param znamky pole známek
     * @return průměr
     */
    private double prumer(int[] znamky) {
        if (znamky == null || znamky.length == 0) return 0.0;
        int sum = 0;
        for (int znamka : znamky) sum += znamka;
        return (double) sum / znamky.length;
    }
}
