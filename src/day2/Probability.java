package day2;

import java.math.BigDecimal;

class Probability {
    private final double value;
    private final int UPPER_BOUND = 1;
    private final int LOWER_BOUND = 0;

    Probability(double value) throws InvalidProbabilityException {
        if (isOutsideBound(value)) throw new InvalidProbabilityException();
        this.value = value;
    }


    private boolean isOutsideBound(double value){
        return value < LOWER_BOUND || value > UPPER_BOUND;
    }

    Probability not() throws InvalidProbabilityException {
        BigDecimal probability = BigDecimal.valueOf(this.value);
        BigDecimal upperBound = BigDecimal.valueOf(UPPER_BOUND);
        BigDecimal improbability = upperBound.subtract(probability);
        return new Probability(improbability.doubleValue());
    }

    Probability and(Probability probability1) throws InvalidProbabilityException {
        return new Probability(this.value * probability1.value);
    }

    Probability or(Probability probability) throws InvalidProbabilityException {
        return this.not().and(probability.not()).not();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Probability)) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }
}
