package day2;

import java.util.Objects;

class Probability {
    private final double probability;
    private final int UPPER_BOUND=1;

    Probability(double probability) throws InvalidProbabilityException {
        if (probability < 0 || probability > 1) throw new InvalidProbabilityException();
        this.probability = probability;
    }


    Probability not() throws InvalidProbabilityException {
        return new Probability(UPPER_BOUND - this.probability) ;
    }

    Probability and(Probability probability1) throws InvalidProbabilityException {


        return new Probability(this.probability * probability1.probability);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Probability)) return false;
        Probability that = (Probability) o;
        return Double.compare(that.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probability);
    }
}
