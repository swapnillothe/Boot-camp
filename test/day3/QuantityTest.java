package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldReturnTrueIfTwoQuantitiesAreEqual() {
        Quantity quantity1 = new Quantity(10.0, Unit.feet);
        Quantity quantity2 = new Quantity(120.0, Unit.inch);

        assertTrue(quantity1.isEqual(quantity2));
    }

    @Test
    void shouldReturnFalseIfFeetAndInchesAreNotEquivalent() {
        Quantity quantity1 = new Quantity(10.0, Unit.feet);
        Quantity quantity2 = new Quantity(130.0, Unit.inch);

        assertFalse(quantity1.isEqual(quantity2));
    }

    @Test
    void shouldReturnTrueIfCentiMeterAndMilimeterAreEquivalent() {
        Quantity quantity1 = new Quantity(10.0, Unit.cm);
        Quantity quantity2 = new Quantity(100.0, Unit.mm);

        assertTrue(quantity1.isEqual(quantity2));
    }

    @Test
    void shouldReturnFalseIfCentiMeterAndMilimeterAreNotEquivalent() {
        Quantity quantity1 = new Quantity(10.0, Unit.cm);
        Quantity quantity2 = new Quantity(99.0, Unit.mm);

        assertFalse(quantity1.isEqual(quantity2));
    }

}