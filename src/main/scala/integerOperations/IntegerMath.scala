package integerOperations

import utils.InputException
import utils.ExceptionMessages._
import Generators._

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
    * Generates Carmichael numbers in a range from 1 to firstInt
    */
//  final def generateCarmichaelNumbers(outcomeList: List[Int] = List()): List[Int] = {
//    if (firstInt <= 1) throw new InputException(StrictNegativeInput)
//    else if (firstInt.isFreeOfSquares && )
//  }


}

object IntegerMath {
  implicit def intToIntegerMath(a: Int): IntegerMath = new IntegerMath(a)
}

