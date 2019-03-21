package day3;

import java.math.BigDecimal;

class Quantity {
    private BigDecimal value;
    private Unit unit;

    Quantity(double value, Unit unit) {
        this.value = BigDecimal.valueOf(value);
        this.unit = unit;
    }

    boolean isEqual(Quantity quantity) {
        BigDecimal valueOfMainQuantity = this.unit.convertToMM(this.value);
        BigDecimal valueOfGivenQuantity = quantity.unit.convertToMM(quantity.value);
        return valueOfMainQuantity.compareTo(valueOfGivenQuantity) == 0;
    }
}
