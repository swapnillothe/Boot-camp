package day3;

import java.math.BigDecimal;

abstract class Unit {

  abstract BigDecimal convertToBaseUnit(BigDecimal value);

  abstract BigDecimal convertTo(BigDecimal valueInBaseUnit, Unit unit);

  abstract Unit getStandardUnit();

  abstract boolean ofDifferentType(Unit anotherUnit);
}
