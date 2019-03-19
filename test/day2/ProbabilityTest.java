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

    @Test
    void shouldCalculateTheChanceOfEventNotHappening() throws InvalidProbabilityException {
        Probability probability = new Probability(0.7);
        Probability actual = probability.not();
        Probability expected = new Probability(0.3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheCompoundProbabilityOfTwoEvents() throws InvalidProbabilityException {
        Probability probability = new Probability(0.3);
        Probability actual = probability.and(new Probability(0.2));
        Probability expected = new Probability(0.06);
        assertEquals(expected, actual);
    }

}