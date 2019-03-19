package day2;

import java.util.Objects;

class Probability {
    private final double probability;

    Probability(double probability) throws InvalidProbabilityException {
        if (probability < 0 || probability > 1) throw new InvalidProbabilityException();
        this.probability = probability;
    }


    Probability calculateChanceOfNotOccurring() throws InvalidProbabilityException {
        return new Probability(1 - this.probability) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Probability)) return false;
        Probability that = (Probability) o;
        return Double.compare(that.probability, probability) == 0;
    }

    
}
