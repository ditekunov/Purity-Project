package integerOperations


import utils.InputException

import scala.util.{Failure, Random, Success, Try}
import utils.ExceptionMessages.{BorderInput, NegativeInput, StrictNegativeInput}
import integerOperations.IntegerGenerators._

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

  /**
    * Finds the sum of number's digits.
    */
  def sumOfDigits: Int = Try(sumOfDigitsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for sumOfDigits(), to provide errors handling.
    */
  private def sumOfDigitsLogic(cur: Int = firstInt, sum: Int = 0): Int = cur match {
    case 0 => sum
    case _ => sumOfDigitsLogic(cur / 10, sum + (cur % 10))
  }

  /**
    * Finds the composition of number's digits.
    */
  def compositionOfDigits: Int = Try(compositionOfDigitsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for compositionOfDigits(), to provide errors handling.
    */
  private def compositionOfDigitsLogic(cur: Int = firstInt, comp: Int = 1): Int = cur match {
    case 0 => if (firstInt == 0) 0 else comp
    case _ => compositionOfDigitsLogic(cur / 10, comp * (cur % 10))
  }

  /**
    * Finds the number of digits in a number.
    */
  def numOfDigits: Int = Try(numOfDigitsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for numOfDigits(), to provide errors handling.
    */
  private def numOfDigitsLogic(cur: Int = firstInt, comp: Int = 0): Int = cur match {
    case 0 => if (firstInt == 0) 1 else comp
    case _ => numOfDigitsLogic(cur / 10, comp + 1)
  }

  /**
    * Finds the greatest divisor of a number.
    */
  def nthGreatestDivisor(nPosition: Int): Int = {
    if (nPosition < 0) throw new InputException("\"nthGreatestDivisor\" " + NegativeInput)
    else Try(firstInt.generateDivisors.sortWith(_ > _)(nPosition)) match {
      case Success(something) => something
      case Failure(ex) => throw new InputException("\"nthGreatestDivisor\" got " + ex.toString)
    }

  }

  /**
    * Returns the number of total divisors of an Int.
    */
  def numOfDivisors: Int = firstInt.generateDivisors.length

  /**
    * Returns the sum of all the divisors of an Int.
    */
  def sumOfDivisors:Int = firstInt.generateDivisors.sum

  /**
    * Checks, whether the Int is prime with O(sqrt(n)) speed.
    */
  def isPrime:Boolean = Try(isPrimeLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"isPrime\" " + ex)
  }

  /**
    * Sub-function for isPrime.
    */
  private def isPrimeLogic(cur: Int = 2): Boolean = {
    if (firstInt == 2 || firstInt == 3) true
    else if (firstInt < 2) throw new InputException("\"isPrime\" " + BorderInput)
    else if (cur.toLong > Math.sqrt(firstInt.toLong)) true
    else if (firstInt % cur == 0) false
    else isPrimeLogic(cur + 1)
  }

  /**
    * Returns the greatest common divisor of two Integers
    */
  def gcdWith(secondInt: Int): Int = Try(gcdWithLogic(first = firstInt, second = secondInt)) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"gcdWith\" " + ex)
  }

  /**
    * Sub-function for gcdWith
    */
  private def gcdWithLogic(first: Int, second: Int): Int = {
    if (first < 0 || second < 0) throw new InputException(StrictNegativeInput)
    else if (second == 0) first
    else gcdWithLogic(second, first % second)
  }

  /**
    * Returns the square of an Integer.
    */
  def sqr: Int = firstInt * firstInt

  /**
    * Returns the N power of an Integer
    */
  def powN(n: Int): BigInt = Try(sqrNLogic(localIterations = n)) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"sqrN\" " + ex)
  }

  private def sqrNLogic(localIterations: Int, total: Int = 1): BigInt = localIterations match {
    case 0 => total
    case _ =>
      if (localIterations > 0 && firstInt >= 0) sqrNLogic(localIterations - 1, total * firstInt)
      else throw new InputException(NegativeInput)
  }

  /**
    * Checks, whether the Int is prime with Fermat method with O(log(n)) speed.
    */
  def isPrimeFermat(iterations: Int = 100): Boolean = Try(isPrimeFermatBorders(localIterations = iterations)) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"isPrimeFermat\" " + ex)
  }

  /**
    * Sub-functions for isPrimeFermat
    */
  private def isPrimeFermatBorders(first : Int = firstInt, localIterations : Int) : Boolean = {
    if (localIterations == 0) true
    else if (isPrimeFermatLogic(first)) isPrimeFermatBorders(first, localIterations - 1)
    else false
  }
  private def isPrimeFermatLogic(n : Int) : Boolean = {
    def checkWithRandomize(a : Int) : Boolean = {
      val res = expmod(a, n, n)
      res == a % n
    }
    checkWithRandomize(random(n - 1) + 1)
  }
  private def expmod(base : Int, exp : Int, m : Int) : Int = {
    if (exp == 0) 1
    else if (exp.isEven) expmod(base, exp / 2, m).sqr % m
    else base * expmod(base, exp - 1, m) % m
  }

  /**
    * Service function, that returns a random Int between 1 and n
    */
  private def random(n: Int) : Int = {
    val random = new Random()
    random.nextInt(n)
  }

}

object IntegerProperties {
  implicit def intToIntegerProperties(a: Int): IntegerProperties = new IntegerProperties(a)
}
