package cz.kocaro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ZpracovaniMyTest {

  @Test
  void testCompIntegers() {
    assertEquals(0, ZpracovaniMy.comp(5, 5));
    assertTrue(ZpracovaniMy.comp(3, 5) < 0);
    assertTrue(ZpracovaniMy.comp(8, 2) > 0);
  }

  @Test
  void testCompStrings() {
    assertEquals(0, ZpracovaniMy.comp("abc", "ABC"));
    assertTrue(ZpracovaniMy.comp("apple", "banana") < 0);
    assertTrue(ZpracovaniMy.comp("Zebra", "apple") > 0);
  }
}
