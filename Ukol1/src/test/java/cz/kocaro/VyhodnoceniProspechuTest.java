package cz.kocaro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VyhodnoceniProspechuTest {

  private final VyhodnoceniProspechu vp = new VyhodnoceniProspechu();

  @Test
  void testProspechNormalni() {
    assertEquals("výborně", vp.prospech(new int[] {1, 1, 1}));
    assertEquals("chvalitebně", vp.prospech(new int[] {2, 2, 2}));
    assertEquals("dobře", vp.prospech(new int[] {3, 3, 3}));
    assertEquals("dostatečně", vp.prospech(new int[] {4, 4, 4}));
    assertEquals("nedostatečně", vp.prospech(new int[] {5, 5, 5}));
  }

  @Test
  void testProspechHranicniHodnoty() {
    assertEquals("výborně", vp.prospech(new int[] {1})); // Průměr 1
    assertEquals("nedostatečně", vp.prospech(new int[] {5})); // Průměr 5
    assertEquals("chvalitebně", vp.prospech(new int[] {1, 2})); // Průměr 1.5 → zaokrouhleno na 2
    assertEquals("dostatečně", vp.prospech(new int[] {3, 4})); // Průměr 3.5 → zaokrouhleno na 4
  }

  @Test
  void testProspechNevalidniVstup() {
    // Testování nevalidních vstupů
    assertThrows(
        IllegalArgumentException.class,
        () -> vp.prospech(new int[] {0})); //  Vstup známek je nevalidní, 0 není známka
    assertThrows(
        IllegalArgumentException.class, () -> vp.prospech(new int[] {6})); // Známka mimo rozsah
    assertThrows(
        IllegalArgumentException.class, () -> vp.prospech(new int[] {1, 2, -1})); // Záporná známka
  }

  @Test
  void testProspechRuzneKombinace() {
    assertEquals("výborně", vp.prospech(new int[] {1, 1, 2})); // Průměr 1.33 → zaokrouhleno na 1
    assertEquals(
        "chvalitebně", vp.prospech(new int[] {2, 2, 3})); // Průměr 2.33 → zaokrouhleno na 2
    assertEquals("dobře", vp.prospech(new int[] {3, 3, 4})); // Průměr 3.33 → zaokrouhleno na 3
    assertEquals("dostatečně", vp.prospech(new int[] {4, 4, 5})); // Průměr 4.33 → zaokrouhleno na 4
    assertEquals("nedostatečně", vp.prospech(new int[] {5, 5, 5})); // Průměr 5
  }

  @Test
  void testProspechEmptyArray() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              vp.prospech(new int[] {});
            });

    // Ověříme zprávu výjimky
    assertEquals("Známky nesmí být null nebo prázdné.", exception.getMessage());
  }

  @Test
  void testProspechNullArray() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              vp.prospech(null);
            });

    // Ověříme zprávu výjimky
    assertEquals("Známky nesmí být null nebo prázdné.", exception.getMessage());
  }

  @Test
  void testZaokrouhleni() {
    assertEquals(
        "chvalitebně", vp.prospech(new int[] {1, 2, 2})); // průměr = 1.66 -> round(2) = chvalitebně
    assertEquals("dobře", vp.prospech(new int[] {3, 3, 3, 2})); // průměr = 2.75 -> round(3) = dobře
  }
}
