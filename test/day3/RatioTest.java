package day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RatioTest {
  @Test
  @DisplayName("should convert inches to MM")
  void shouldReturnEquivalentValueOfInchesInMiliMeter() {
    BigDecimal actual = Ratio.INCH.convertToBaseUnit(BigDecimal.valueOf(1.0));
    BigDecimal expected = BigDecimal.valueOf(25.0);
    assertEquals(0, expected.compareTo(actual));
  }

  @Test
  @DisplayName("should convert FEET to MM")
  void shouldReturnEquivalentValueOfFeetInMilliMeter() {
    BigDecimal actual = Ratio.FEET.convertToBaseUnit(BigDecimal.valueOf(1.0));
    BigDecimal expected = BigDecimal.valueOf(300.0);
    assertEquals(0, expected.compareTo(actual));
  }

}