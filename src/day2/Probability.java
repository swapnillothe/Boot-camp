package day2;

import java.math.BigDecimal;

class Probability {
    private final BigDecimal chance;
    private final int UPPER_BOUND = 1;
    private final int LOWER_BOUND = 0;

    Probability(double value) throws InvalidProbabilityException {
        if (isOutsideBound(value)) throw new InvalidProbabilityException();
        this.chance = BigDecimal.valueOf(value);
    }

    private boolean isOutsideBound(double value){
        return value < LOWER_BOUND || value > UPPER_BOUND;
    }

    Probability not() throws InvalidProbabilityException {
        BigDecimal upperBound = BigDecimal.valueOf(UPPER_BOUND);
        BigDecimal improbability = upperBound.subtract(this.chance);
        return new Probability(improbability.doubleValue());
    }

    Probability and(Probability probability1) throws InvalidProbabilityException {
        BigDecimal and = this.chance.multiply(probability1.chance);
        return new Probability(and.doubleValue());
    }

    Probability or(Probability probability) throws InvalidProbabilityException {
        return this.not().and(probability.not()).not();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Probability)) return false;
        Probability that = (Probability) obj;
        int comparedResult = that.chance.compareTo(this.chance);
        return comparedResult == 0;
    }
}
