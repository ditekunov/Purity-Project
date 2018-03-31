package doubleOperations

import utils.InputException
import utils.ExceptionMessages.ZeroInput

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

}

object DoubleProperties {
  implicit def doubleToLocalProps(a: Double): DoubleProperties = new DoubleProperties(a)
}