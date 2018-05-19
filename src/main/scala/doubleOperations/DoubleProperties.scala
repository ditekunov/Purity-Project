package doubleOperations

import utils.InputException
import utils.ExceptionMessages.ZeroInput
import utils.MathConstants.pi

/**
  * Contains functions, affecting double properties.
  *
  * Purity project by Daniil Tekunov.
  */
class DoubleProperties(val firstDouble: Double) {

  import DoubleProperties._

  /**
    * Returns the number, inversed via 1
    */
  def inverse: Double = firstDouble match {
    case 0 => throw new InputException("\"inverse\" " + ZeroInput)
    case _ => 1 / firstDouble
  }

  /**
    * Returns square of a Double
    */
  def sqrDouble: Double = firstDouble * firstDouble
 
  /**
    * Returns absolute value of a Double
    */
  def abs: Double = if (firstDouble < 0) -firstDouble else firstDouble
 
  /**
    * Returns double, converted to degrees
    */
  def toDegrees: Double = firstDouble * 180.0 / pi
 
  /**
    * Increments double
    */
  def incDouble: Double =
    if (a != Double.MAX_VALUE) a + 1
    else throw new InputException(OverflowInput)

}

object DoubleProperties {
  implicit def doubleToLocalProps(a: Double): DoubleProperties = new DoubleProperties(a)
}
