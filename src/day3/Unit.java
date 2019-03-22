package day3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class Unit {
  private final BigDecimal ratio;
  private final Type type;
  private static Map<Type, Unit> standards = new HashMap<>();

  private enum Type {LENGTH, VOLUME}

  static final Unit MM = new Unit(1, Type.LENGTH);
  static final Unit INCH = new Unit(25, Type.LENGTH);
  static final Unit FEET = new Unit(300, Type.LENGTH);
  static final Unit CM = new Unit(10, Type.LENGTH);

  static final Unit LITER = new Unit(1, Type.VOLUME);
  static final Unit GALLON = new Unit(3.78, Type.VOLUME);

  private Unit(double ratio, Type type) {
    this.ratio = BigDecimal.valueOf(ratio);
    this.type = type;

  }

  static {
    standards.put(Type.LENGTH, Unit.INCH);
    standards.put(Type.VOLUME, Unit.LITER);

  }

  BigDecimal convertToBaseUnit(BigDecimal value) {
    return value.multiply(this.ratio);
  }

  BigDecimal convertTo(BigDecimal valueInBaseUnit, Unit unit) {
    return valueInBaseUnit.divide(unit.ratio);
  }

  boolean ofDifferentType(Unit anotherUnit) {
    return !this.type.equals(anotherUnit.type);
  }

  Unit getStandardUnit() {
    return Unit.standards.get(this.type);
  }

}
