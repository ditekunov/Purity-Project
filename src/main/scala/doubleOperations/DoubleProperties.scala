package doubleOperations

class DoubleProperties(val firstDouble: Double) {

  import DoubleProperties._

  def inverse: Double = 1 / firstDouble

}

object DoubleProperties {
  implicit def doubleToDoubleProperties(a: Double): DoubleProperties = new DoubleProperties(a)
}