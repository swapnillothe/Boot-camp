package day2;

import java.math.BigDecimal;

class Probability {
    private final BigDecimal chance;
    private final int UPPER_BOUND = 1;
    private final int LOWER_BOUND = 0;

    Probability(double value) throws ProbabilityOutOfBoundException {
        if (isOutsideBound(value)) throw new ProbabilityOutOfBoundException();
        this.chance = BigDecimal.valueOf(value);
    }

    private boolean isOutsideBound(double value){
        return value < LOWER_BOUND || value > UPPER_BOUND;
    }

    Probability not() throws ProbabilityOutOfBoundException {
        BigDecimal upperBound = BigDecimal.valueOf(UPPER_BOUND);
        BigDecimal improbability = upperBound.subtract(this.chance);
        return new Probability(improbability.doubleValue());
    }

    Probability and(Probability probability) throws ProbabilityOutOfBoundException {
        BigDecimal and = this.chance.multiply(probability.chance);
        return new Probability(and.doubleValue());
    }

    Probability or(Probability probability) throws ProbabilityOutOfBoundException {
        Probability complimentOfMainChance = this.not();
        Probability complementOfPassedChance = probability.not();
        Probability commonComplement = complimentOfMainChance.and(complementOfPassedChance);
        return commonComplement.not();
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
