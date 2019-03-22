package day3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class Ratio extends Unit {
  private Type type;

  public enum Type {LENGTH, VOLUME};

  private final BigDecimal ratio;
  private static Map<Type, Unit> standards = new HashMap<>();

  static final Unit MM = new Ratio(1, Type.LENGTH);
  static final Unit INCH = new Ratio(25, Type.LENGTH);
  static final Unit FEET = new Ratio(300, Type.LENGTH);
  static final Unit CM = new Ratio(10, Type.LENGTH);

  static final Unit LITER = new Ratio(1, Type.VOLUME);
  static final Unit GALLON = new Ratio(3.78, Type.VOLUME);

  private Ratio(double ratio, Type type) {
    this.type = type;
    this.ratio = BigDecimal.valueOf(ratio);

  }

  static {
    standards.put(Type.LENGTH, Ratio.INCH);
    standards.put(Type.VOLUME, Ratio.LITER);
  }

  BigDecimal convertToBaseUnit(BigDecimal value) {
    return value.multiply(this.ratio);
  }

  BigDecimal convertTo(BigDecimal valueInBaseUnit, Unit unit) {
    Ratio ratio = (Ratio) unit;
    return valueInBaseUnit.divide(ratio.ratio);
  }

  Unit getStandardUnit() {
    return Ratio.standards.get(this.type);
  }

  boolean ofDifferentType(Unit anotherUnit) {
    Ratio anotherRatio = (Ratio) anotherUnit;
    return !this.type.equals(anotherRatio.type);
  }

}
