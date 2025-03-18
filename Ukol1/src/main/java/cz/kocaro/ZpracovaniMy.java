package cz.kocaro;

/** Pomocná třída pro porovnávání hodnot. */
public class ZpracovaniMy {

  /**
   * Porovná dvě celá čísla.
   *
   * @param a první číslo
   * @param b druhé číslo
   * @return -1 pokud a &lt; b, 0 pokud a == b, 1 pokud a &gt; b
   */
  public static int comp(int a, int b) {
    return Integer.compare(a, b);
  }

  /**
   * Porovná dva řetězce bez ohledu na velikost písmen.
   *
   * @param a první řetězec
   * @param b druhý řetězec
   * @return -1 pokud a &lt; b, 0 pokud a == b, 1 pokud a &gt; b (ignoruje velikost písmen)
   */
  public static int comp(String a, String b) {
    return a.compareToIgnoreCase(b);
  }
}
