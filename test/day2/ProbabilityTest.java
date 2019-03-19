package day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    void shouldNotThrowExceptionIfValueIsBetween0And1() {
        assertDoesNotThrow(() -> new Probability(0.1D));
    }

    @Test
    void shouldTrowExceptionIfValueIsBelow0() {
        assertThrows(ProbabilityOutOfBoundException.class, () -> new Probability(-0.1D));
    }

    @Test
    void shouldTrowExceptionIfValueIsAbove1() {
        assertThrows(ProbabilityOutOfBoundException.class, () -> new Probability(1.1D));
    }

    @Test
    void shouldReturnComplementOfProbability() throws ProbabilityOutOfBoundException {
        Probability probability = new Probability(0.3D);
        Probability actual = probability.not();
        Probability expected = new Probability(0.7D);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnUnionOfTwoProbabilities() throws ProbabilityOutOfBoundException {
        Probability probability1 = new Probability(0.3D);
        Probability probability2 = new Probability(0.7D);
        Probability actual = probability1.and(probability2);
        Probability expected = new Probability(0.21D);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnIntersectionOfTwoProbabilities() throws ProbabilityOutOfBoundException {
        Probability probability1 = new Probability(0.5D);
        Probability probability2 = new Probability(0.5D);
        Probability actual = probability1.or(probability2);
        Probability expected = new Probability(0.75D);
        assertEquals(expected, actual);
    }
}
