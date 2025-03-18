package cz.kocaro;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // === 1) Vyhodnocení prospěchu ===
        VyhodnoceniProspechu vp = new VyhodnoceniProspechu();
        int[] znamky = {1, 2, 3, 1, 2};
        System.out.println("Slovní hodnocení pro známky " + Arrays.toString(znamky) + ": " + vp.prospech(znamky));

        // === 2) Komparační funkce ===
        System.out.println("\nPorovnání čísel:");
        System.out.println("comp(5, 5) = " + ZpracovaniMy.comp(5, 5));   // 0
        System.out.println("comp(3, 8) = " + ZpracovaniMy.comp(3, 8));   // -1
        System.out.println("comp(9, 1) = " + ZpracovaniMy.comp(9, 1));   // 1

        System.out.println("\nPorovnání řetězců:");
        System.out.println("comp(\"abc\", \"ABC\") = " + ZpracovaniMy.comp("abc", "ABC"));  // 0
        System.out.println("comp(\"apple\", \"banana\") = " + ZpracovaniMy.comp("apple", "banana"));  // -1

        // === 3) Test interval (otevřený interval) ===
        System.out.println("\nTestování intervalu (otevřený interval):");
        System.out.println("interval(1, 5, 3) = " + Zpracovani.interval(1, 5, 3));  // true
        System.out.println("interval(1, 5, 1) = " + Zpracovani.interval(1, 5, 1));  // false
        System.out.println("interval(1, 5, 5) = " + Zpracovani.interval(1, 5, 5));  // false

        // === 4) Generování vzorků sestupně ===
        System.out.println("\nGenerování vzorků:");
        double[] vzorky = Zpracovani.vzorkySestupně(2.0, 10.0, 2.0);  // od 10.0 do 2.0 krokem 2.0
        System.out.println("vzorkySestupně(2.0, 10.0, 2.0) = " + Arrays.toString(vzorky));
    }
}
