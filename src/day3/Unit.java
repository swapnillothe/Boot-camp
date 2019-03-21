package day3;

import java.math.BigDecimal;

public class Unit {
    private final BigDecimal ratio;
    public static final Unit mm = new Unit(1);
    public static final Unit inch = new Unit(25);
    public static final Unit feet = new Unit(300);
    public static final Unit cm = new Unit(10);

    private Unit(double ratio) {
        this.ratio = BigDecimal.valueOf(ratio);
    }

    BigDecimal convertToMM(BigDecimal value){
        return value.multiply(this.ratio);
    }
}
