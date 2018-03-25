package integerOperations

import utils.InputException
import utils.ExceptionMessages._
import Generators._
import IntegerProperties._

class IntegerMath(val firstInt: Int) {

  import IntegerMath._

  /**
    * Checks, if a number is free of squares
    */
  def isFreeOfSquares: Boolean = {
    if (firstInt <= 1) throw new InputException(StrictNegativeInput)
    else (for {cur <- firstInt.generateSquares if firstInt % cur == 0} yield true).isEmpty
  }

  /**
    * Checks, if a number is a Carmichael number
    */
  def isCarmichael: Boolean = {
    if (firstInt <= 1) throw new InputException(StrictNegativeInput)
    else if (firstInt.isFreeOfSquares && firstInt.isOdd) {
      val curFactorisation: List[Int] = firstInt.generatePrimeDivisors.filter {cur => cur != firstInt}

      (for {cur <- curFactorisation if (firstInt - 1) % (cur - 1) == 0} yield true).length == curFactorisation.length &&
      curFactorisation.nonEmpty
    }
    else false
  }
}

object IntegerMath {
  implicit def intToIntegerMath(a: Int): IntegerMath = new IntegerMath(a)
}

