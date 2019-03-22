package day3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class RatioWithScale extends Unit {
  private Type type;

  public enum Type {TEMPERATURE}

  private final BigDecimal ratio;
  private final BigDecimal scale;

  private static Map<Type, Unit> standards = new HashMap<>();

  static final Unit FAHRENHEIT = new RatioWithScale(1, 0, Type.TEMPERATURE);
  static final Unit CELSIUS = new RatioWithScale(1.8, 32, Type.TEMPERATURE);

  private RatioWithScale(double ratio, double scale, Type type) {
    this.ratio = BigDecimal.valueOf(ratio);
    this.scale = BigDecimal.valueOf(scale);
    this.type = type;
  }

  static {
    standards.put(Type.TEMPERATURE, RatioWithScale.FAHRENHEIT);
  }

  BigDecimal convertToBaseUnit(BigDecimal value) {
    return value.multiply(this.ratio).add(this.scale);
  }

  BigDecimal convertTo(BigDecimal valueInBaseUnit, Unit unit) {
    RatioWithScale ratio = (RatioWithScale) unit;
    return valueInBaseUnit.divide(ratio.ratio).subtract(ratio.scale);
  }

  Unit getStandardUnit() {
    return RatioWithScale.standards.get(this.type);
  }

  boolean ofDifferentType(Unit anotherUnit) {
    RatioWithScale anotherRatioWithSacle = (RatioWithScale) anotherUnit;
    return !this.type.equals(anotherRatioWithSacle.type);
  }

}
