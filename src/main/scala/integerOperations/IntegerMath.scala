package integerOperations

import utils.InputException
import utils.ExceptionMessages._
import IntegerGenerators._
import IntegerProperties._

import scala.util.{Failure, Success, Try}

class IntegerMath(val firstInt: Int) {

  import IntegerMath._

  /**
    * Checks, if a number is free of squares.
    */
  def isFreeOfSquares: Boolean = {
    if (firstInt <= 1) throw new InputException(NegativeInput)
    else (for {cur <- firstInt.generateSquares if firstInt % cur == 0} yield true).isEmpty
  }

  /**
    * Checks, if an Int is a Carmichael number.
    */
  def isCarmichael: Boolean = {
    if (firstInt <= 1) throw new InputException(NegativeInput)
    else if (firstInt.isFreeOfSquares && firstInt.isOdd) {
      val curFactorisation: List[Int] = firstInt.generatePrimeDivisors.filter {cur => cur != firstInt}

      (for {cur <- curFactorisation if (firstInt - 1) % (cur - 1) == 0} yield true).length == curFactorisation.length &&
      curFactorisation.nonEmpty
    }
    else false
  }

  /**
    * Checks, if an Int is a Luc-Carmichael number.
    */
  def isLuc_Carmichael: Boolean = {
    if (firstInt <= 1) throw new InputException(NegativeInput)
    else if (firstInt.isFreeOfSquares && firstInt.isOdd) {
      val curFactorisation: List[Int] = firstInt.generatePrimeDivisors.filter {cur => cur != firstInt}

      (for {cur <- curFactorisation if (firstInt + 1) % (cur + 1) == 0} yield true).length == curFactorisation.length &&
        curFactorisation.nonEmpty
    }
    else false
  }

  /**
    * Checks, if an Int is a Fibonacci number.
    */
  def isFibonacci: Boolean = {
    if (firstInt < 0) throw new InputException(NegativeInput)
    else firstInt.generateFibonacci.contains(firstInt)
  }

  /**
    * Generates Catalan number with `firstInt` index.
    */
  def nthCatalan: Int = Try(nthCatalanLogic(firstInt)) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for nthCatalan
    */
  private def nthCatalanLogic(input: Int): Int = {
    if (input <= 1) 1
    else (0 until input).map(i => nthCatalanLogic(i) * nthCatalanLogic(input - i - 1)).sum
  }

}

object IntegerMath {
  implicit def intToMathImplicit(a: Int): IntegerMath = new IntegerMath(a)
}

