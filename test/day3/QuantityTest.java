package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class QuantityTest {

  @Test
  void shouldReturnTrueIfTwoQuantitiesAreEqual() {
    Quantity feet = new Quantity(10.0, Ratio.FEET);
    Quantity inch = new Quantity(120.0, Ratio.INCH);
    assertEquals(feet, inch);
  }

  @Test
  void shouldReturnFalseIfFeetAndInchesAreNotEquivalent() {
    Quantity feet = new Quantity(10.0, Ratio.FEET);
    Quantity inch = new Quantity(130.0, Ratio.INCH);
    assertNotEquals(feet, inch);
  }

  @Test
  void shouldReturnTrueIfCentiMeterAndMilimeterAreEquivalent() {
    Quantity cm = new Quantity(10.0, Ratio.CM);
    Quantity mm = new Quantity(100.0, Ratio.MM);
    assertEquals(cm, mm);
  }

  @Test
  void shouldReturnFalseIfCentiMeterAndMilimeterAreNotEquivalent() {
    Quantity cm = new Quantity(10.0, Ratio.CM);
    Quantity mm = new Quantity(99.0, Ratio.MM);
    assertNotEquals(cm, mm);
  }

  @Test
  void ShouldReturnTrueIfGivenLiterAndGivenGalllonValueAreEqual() {
    Quantity liter = new Quantity(3.78, Ratio.LITER);
    Quantity gallon = new Quantity(1, Ratio.GALLON);
    assertEquals(liter, gallon);
  }

  @Test
  void ShouldReturnFalseIfGivenQuantitiesAreOfDifferentType() {
    Quantity liter = new Quantity(1.0, Ratio.LITER);
    Quantity cm = new Quantity(10.0, Ratio.CM);
    assertNotEquals(liter, cm);
  }

  @Test
  void ShouldAddTwoSameQuantity() {
    Quantity inch1 = new Quantity(1, Ratio.INCH);
    Quantity inch2 = new Quantity(2, Ratio.INCH);
    Quantity expected = new Quantity(3, Ratio.INCH);
    Quantity actual = inch1.add(inch2, Ratio.INCH);
    assertEquals(expected, actual);
  }

  @Test
  void ShouldAddDifferentQuantityOfTypeLength() {
    Quantity inch = new Quantity(2, Ratio.INCH);
    Quantity cm = new Quantity(2.5, Ratio.CM);
    Quantity expected = new Quantity(3, Ratio.INCH);
    Quantity actual = inch.add(cm, Ratio.INCH);
    assertEquals(expected, actual);
  }

  @Test
  void ShouldAddDifferentQuantityOfTypeVolume() {
    Quantity gallon = new Quantity(1, Ratio.GALLON);
    Quantity liter = new Quantity(1, Ratio.LITER);
    Quantity expected = new Quantity(4.78, Ratio.LITER);
    Quantity actual = gallon.add(liter, Ratio.LITER);
    assertEquals(expected, actual);
  }

  @Test
  void ShouldAddDifferentQuantityOfTypeVolumeInStandardUnit() {
    Quantity gallon = new Quantity(1, Ratio.GALLON);
    Quantity liter = new Quantity(1, Ratio.LITER);
    Quantity expected = new Quantity(4.78, Ratio.LITER);
    Quantity actual = gallon.add(liter);
    assertEquals(expected, actual);
  }

  @Test
  void ShouldReturnTrueIfGivenFahrenheitAndCelsiousAreEqual() {
    Quantity fahrenheit = new Quantity(212, RatioWithScale.FAHRENHEIT);
    Quantity celsius = new Quantity(100, RatioWithScale.CELSIUS);
    assertEquals(fahrenheit,celsius);
  }

  @Test
  void ShouldReturnFalseIfGivenFahrenheitAndCelsiousAreNotEqual() {
    Quantity fahrenheit = new Quantity(220, RatioWithScale.FAHRENHEIT);
    Quantity celsius = new Quantity(100, RatioWithScale.CELSIUS);
    assertNotEquals(fahrenheit,celsius);
  }
}