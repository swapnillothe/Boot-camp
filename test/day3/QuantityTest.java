package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class QuantityTest {

  @Test
  void shouldReturnTrueIfTwoQuantitiesAreEqual() {
    Quantity feet = new Quantity(10.0, Unit.FEET);
    Quantity inch = new Quantity(120.0, Unit.INCH);
    assertEquals(feet, inch);
  }

  @Test
  void shouldReturnFalseIfFeetAndInchesAreNotEquivalent() {
    Quantity feet = new Quantity(10.0, Unit.FEET);
    Quantity inch = new Quantity(130.0, Unit.INCH);
    assertNotEquals(feet, inch);
  }

  @Test
  void shouldReturnTrueIfCentiMeterAndMilimeterAreEquivalent() {
    Quantity cm = new Quantity(10.0, Unit.CM);
    Quantity mm = new Quantity(100.0, Unit.MM);
    assertEquals(cm, mm);
  }

  @Test
  void shouldReturnFalseIfCentiMeterAndMilimeterAreNotEquivalent() {
    Quantity cm = new Quantity(10.0, Unit.CM);
    Quantity mm = new Quantity(99.0, Unit.MM);
    assertNotEquals(cm, mm);
  }

  @Test
  void ShouldReturnTrueIfGivenLiterAndGivenGalllonValueAreEqual() {
    Quantity liter = new Quantity(3.78, Unit.LITER);
    Quantity gallon = new Quantity(1, Unit.GALLON);
    assertEquals(liter, gallon);
  }

  @Test
  void ShouldReturnFalseIfGivenQuantitiesAreOfDifferentType() {
    Quantity liter = new Quantity(1.0, Unit.LITER);
    Quantity cm = new Quantity(10.0, Unit.CM);
    assertNotEquals(liter, cm);
  }

  @Test
  void ShouldAddTwoSameQuantity() {
    Quantity inch1 = new Quantity(1, Unit.INCH);
    Quantity inch2 = new Quantity(2, Unit.INCH);
    Quantity expected = new Quantity(3, Unit.INCH);
    Quantity actual = inch1.add(inch2, Unit.INCH);
    assertEquals(expected, actual);
  }

  @Test
  void ShouldAddDifferentQuantityOfTypeLength() {
    Quantity inch = new Quantity(2, Unit.INCH);
    Quantity cm = new Quantity(2.5, Unit.CM);
    Quantity expected = new Quantity(3, Unit.INCH);
    Quantity actual = inch.add(cm, Unit.INCH);
    assertEquals(expected, actual);
  }

  @Test
  void ShouldAddDifferentQuantityOfTypeVolume() {
    Quantity gallon = new Quantity(1, Unit.GALLON);
    Quantity liter = new Quantity(1, Unit.LITER);
    Quantity expected = new Quantity(4.78, Unit.LITER);
    Quantity actual = gallon.add(liter, Unit.LITER);
    assertEquals(expected, actual);
  }
}