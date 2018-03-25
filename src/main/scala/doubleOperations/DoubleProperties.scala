package doubleOperations

class DoubleProperties(val firstDouble: Double) {

  import DoubleProperties._

  /**
    * Returns the number, inversed via 1
    */
  def inverse: Double = 1 / firstDouble

  /**
    * Returns square of a Double
    */
  def sqrDouble: Double = firstDouble * firstDouble

}

object DoubleProperties {
  implicit def doubleToDoubleProperties(a: Double): DoubleProperties = new DoubleProperties(a)
}