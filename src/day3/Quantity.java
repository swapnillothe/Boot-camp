package day3;

import java.math.BigDecimal;

class Quantity {
  private BigDecimal value;
  private Unit unit;

  Quantity(double value, Unit unit) {
    this.value = BigDecimal.valueOf(value);
    this.unit = unit;
  }

  @Override
  public boolean equals(Object anotherQuantity) {
    if (this == anotherQuantity) return true;
    if (anotherQuantity == null || getClass() != anotherQuantity.getClass()) return false;
    Quantity quantity = (Quantity) anotherQuantity;

    if (this.unit.ofDifferentType(quantity.unit)) return false;
    BigDecimal valueOfMainQuantity = this.unit.convertToBaseUnit(this.value);
    BigDecimal valueOfGivenQuantity = quantity.unit.convertToBaseUnit(quantity.value);
    return valueOfMainQuantity.compareTo(valueOfGivenQuantity) == 0;
  }

  Quantity add(Quantity anotherQuantity, Unit unit){
    if (this.unit.ofDifferentType(anotherQuantity.unit)) return null;

    BigDecimal valueOfMainQuantity = this.unit.convertToBaseUnit(this.value);
    BigDecimal valueOfGivenQuantity = anotherQuantity.unit.convertToBaseUnit(anotherQuantity.value);
    BigDecimal totalValue = (valueOfGivenQuantity.add(valueOfMainQuantity));
    BigDecimal valueInRequiredUnit = unit.convertTo(totalValue,unit);
    return new Quantity(valueInRequiredUnit.doubleValue(), unit);
  }

  Quantity add(Quantity anotherQuantity){
    Unit unit = (Unit) anotherQuantity.unit.getStandardUnit();
    return this.add(anotherQuantity, unit);
  }

}
