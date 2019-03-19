package day2;

public class Probability {
    private final double probability;

    Probability(double probability) throws InvalidProbabilityException {
        if (probability < 0 || probability > 1)throw new InvalidProbabilityException();
            this.probability = probability;
    }


}
