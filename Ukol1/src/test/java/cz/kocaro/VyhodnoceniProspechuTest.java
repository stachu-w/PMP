package cz.kocaro;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VyhodnoceniProspechuTest {

    private final VyhodnoceniProspechu vp = new VyhodnoceniProspechu();

    @Test
    void testProspechNormalni() {
        assertEquals("výborně", vp.prospech(new int[]{1, 1, 1}));
        assertEquals("dobře", vp.prospech(new int[]{3, 3, 3}));
        assertEquals("chvalitebně", vp.prospech(new int[]{2, 2, 3}));
        assertEquals("nedostatečně", vp.prospech(new int[]{5, 5, 5}));
    }

    @Test
    void testProspechEmptyArray() {
        assertEquals("bez hodnocení", vp.prospech(new int[]{}));
    }

    @Test
    void testProspechNullArray() {
        assertEquals("bez hodnocení", vp.prospech(null));
    }

    @Test
    void testZaokrouhleni() {
        assertEquals("chvalitebně", vp.prospech(new int[]{1, 2, 2})); // průměr = 1.66 -> round(2) = chvalitebně
        assertEquals("dobře", vp.prospech(new int[]{3, 3, 3, 2})); // průměr = 2.75 -> round(3) = dobře
    }
}
