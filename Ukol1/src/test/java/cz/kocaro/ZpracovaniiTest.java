package cz.kocaro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZpracovaniiTest {

  @Test
  void testIntervalExclusive() {
    assertTrue(Zpracovanii.interval(1, 5, 3));
    assertFalse(Zpracovanii.interval(1, 5, 1)); // 1 is not included
    assertFalse(Zpracovanii.interval(1, 5, 5)); // 5 is not included
    assertFalse(Zpracovanii.interval(1, 5, 0));
    assertFalse(Zpracovanii.interval(1, 5, 6));
  }

  @Test
  void testVzorkySestupneValid() {
    double[] expected = {10.0, 8.0, 6.0, 4.0};
    assertArrayEquals(expected, Zpracovanii.vzorkySestupně(4.0, 10.0, 2.0));
  }

  @Test
  void testVzorkySestupneEmpty() {
    assertArrayEquals(new double[0], Zpracovanii.vzorkySestupně(10.0, 5.0, 2.0)); // odkud < kam
    assertArrayEquals(new double[0], Zpracovanii.vzorkySestupně(2.0, 10.0, -1.0)); // krok <= 0
  }

  @Test
  void testVzorkySestupneExactStep() {
    double[] expected = {5.0, 2.0};
    assertArrayEquals(expected, Zpracovanii.vzorkySestupně(2.0, 5.0, 3.0));
  }
}
