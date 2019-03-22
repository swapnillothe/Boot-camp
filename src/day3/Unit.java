package day3;

import java.math.BigDecimal;

abstract class Unit {
  Type type;

  public enum Type {LENGTH, VOLUME,TEMPERATURE}

  Unit(Type type) {
    this.type = type;
  }

  abstract BigDecimal convertToBaseUnit(BigDecimal value);

  abstract BigDecimal convertTo(BigDecimal valueInBaseUnit, Unit unit);

  abstract Unit getStandardUnit();

  boolean ofDifferentType(Unit anotherUnit) {
    return !this.type.equals(anotherUnit.type);
  }
}
