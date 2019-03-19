package day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {
    @Test
    void shouldNotThrowExceptionIfValueIsBetween0And1() {
        assertDoesNotThrow(() -> new Probability(0.1));
    }

    @Test
    void shouldTrowExceptionIfValueIsBelow0() {
        assertThrows(InvalidProbabilityException.class, () -> new Probability(-0.1));
    }

    @Test
    void shouldTrowExceptionIfValueIsAbove1() {
        assertThrows(InvalidProbabilityException.class, () -> new Probability(1.1));
    }
}