package integerOperations

import utils.InputException
import utils.ExceptionMessages._
import IntegerGenerators._
import IntegerProperties._

import scala.util.{Failure, Success, Try}

/**
  * Contains functions, that use more specific math or algorithms.
  *
  * Purity project by Daniil Tekunov.
  */
class IntegerMath(val firstInt: Int) {

  import IntegerMath._

  /**
    * Checks, if a number is free of squares.
    *
    * https://en.wikipedia.org/wiki/Square-free_integer
    */
  def isFreeOfSquares: Boolean = {
    if (firstInt <= 1) throw new InputException(NegativeInput)
    else (for {cur <- firstInt.generateSquares if firstInt % cur == 0} yield true).isEmpty
  }

  /**
    * Checks, if an Int is a Carmichael number.
    *
    * https://en.wikipedia.org/wiki/Carmichael_number
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
    * Checks, if an Int is a Lucas-Carmichael number.
    *
    * https://en.wikipedia.org/wiki/Lucas–Carmichael_number
    */
  def isLucas_Carmichael: Boolean = {
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
    *
    * https://en.wikipedia.org/wiki/Fibonacci_number
    */
  def isFibonacci: Boolean = {
    if (firstInt < 0) throw new InputException(NegativeInput)
    else firstInt.generateFibonacci.contains(firstInt)
  }

  /**
    * Generates Catalan number with `firstInt` index.
    *
    * https://en.wikipedia.org/wiki/Catalan_number
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

  /**
    * Realisation of a binary 'N' power of an Int.
    *
    * https://en.wikipedia.org/wiki/Exponentiation_by_squaring
    *
    * Works with O(log(n)) speed.
    */
  def binaryPower(n: Int): Int = Try(binaryPowerLogic(firstInt, n)) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for binaryPower
    */
  private def binaryPowerLogic(cur: Int, n: Int): Int = {
    if (n == 0) 1
    else if (n % 2 == 1) binaryPowerLogic(cur, n - 1) * cur
    else binaryPowerLogic(cur, n / 2) * binaryPowerLogic(cur, n / 2)
  }

  /**
    * Checks, whether the number is a Zuckerman number
    *
    * http://www.numbersaplenty.com/set/Zuckerman_number/
    */
  def isZuckerman: Boolean =
    (firstInt.compositionOfDigits > 0) && (firstInt % firstInt.compositionOfDigits == 0) && (firstInt > 0)

  /**
    * Checks, whether the number is a Harshad number
    *
    * https://en.wikipedia.org/wiki/Harshad_number
    */
  def isHarshad: Boolean = (firstInt == 0) || (firstInt % firstInt.sumOfDigits == 0) && (firstInt > 0)

}

object IntegerMath {
  implicit def intToMathImplicit(a: Int): IntegerMath = new IntegerMath(a)
}

