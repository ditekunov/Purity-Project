package integerOperations

class IntegerProperties(val firstInt: Int) {
  import IntegerProperties._

  /**
    * Checks, whether the number is even
    */
  def isEven: Boolean = firstInt % 2 == 0

  /**
    * Checks, whether the number is odd
    */
  def isOdd: Boolean = firstInt % 2 != 0

  /**
    * Checks, whether the number is a square of two numbers
    */
  def isSquared(secondInt: Int = firstInt, multiplier: Int = 3): Boolean = {
    if (secondInt > 0) secondInt match {
      case 1 => true
      case 0 => false
      case _ => isSquared(secondInt - multiplier, multiplier + 2)
    }
    else if (firstInt == 0) true
    else false
  }

}

object IntegerProperties {
  implicit def intToIntegerProperties(a: Int): IntegerProperties = new IntegerProperties(a)
}
