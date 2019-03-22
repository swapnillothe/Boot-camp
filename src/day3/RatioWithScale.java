package day3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class RatioWithScale extends Unit {
  private final BigDecimal ratio;
  private final BigDecimal scale;

  private static Map<Unit.Type, Unit> standards = new HashMap<>();

  static final Unit FAHRENHEIT = new RatioWithScale(1, 0, Unit.Type.TEMPERATURE);
  static final Unit CELSIUS = new RatioWithScale(1.8, 32, Unit.Type.TEMPERATURE);

  private RatioWithScale(double ratio, double scale, Type type) {
    super(type);
    this.ratio = BigDecimal.valueOf(ratio);
    this.scale = BigDecimal.valueOf(scale);
  }

  static {
    standards.put(Unit.Type.LENGTH, RatioWithScale.FAHRENHEIT);
  }

  BigDecimal convertToBaseUnit(BigDecimal value) {
    return value.multiply(this.ratio).add(this.scale);
  }

  BigDecimal convertTo(BigDecimal valueInBaseUnit, Unit unit) {
    RatioWithScale ratio = (RatioWithScale) unit;
    return valueInBaseUnit.divide(ratio.ratio).subtract(ratio.scale);
  }

  Unit getStandardUnit() {
    return RatioWithScale.standards.get(super.type);
  }

}
