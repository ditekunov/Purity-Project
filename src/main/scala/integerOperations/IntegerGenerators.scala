package integerOperations

import utils.ExceptionMessages.StrictNegativeInput
import utils.InputException
import utils.ExceptionMessages.{NegativeInput, StackOverflowInput}

import scala.util.{Failure, Success, Try}
import IntegerProperties._
import IntegerMath._

class IntegerGenerators(val until: Int) {

  import IntegerGenerators._

  /**
    * Generates list in range from until to 1
    */
  def generateArithmeticRegression: List[Int] = Try(generateArithmeticRegressionLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"generateArithmeticRegression\" got " + ex.toString)
  }

  /**
    * Sub-function for generateArithmeticRegression
    */
  private def generateArithmeticRegressionLogic(cur: Int = until, regressionList: List[Int] = List()): List[Int] = {
    if (until < 0) throw new InputException("\"generateArithmeticRegression\" " + NegativeInput)
      if (cur == 0) regressionList
      else generateArithmeticRegressionLogic(cur - 1, regressionList :+ cur)
    }

  /**
    * Generates list in range from 1 to until
    */
  def generateArithmeticProgression: List[Int] = Try(generateArithmeticProgressionLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"generateArithmeticProgression\" " + ex.toString)
  }

  /**
    * Sub-function for generateArithmeticProgression
    */
  private def generateArithmeticProgressionLogic(cur: Int = 1, regressionList: List[Int] = List()): List[Int] = {
    if (until < 0) throw new InputException("\"generateArithmeticProgression\" " + NegativeInput)
    if (cur == until) regressionList :+ cur
    else generateArithmeticProgressionLogic(cur + 1, regressionList :+ cur)
  }

  /**
    * Generates squares in range from 2 to firstInt
    */
  def generateSquares: List[Int] = Try(generateSquaresLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"generateSquares\" got " + ex.toString)
  }

  /**
    * Sub-function for generateSquares
    */
  private def generateSquaresLogic(squaresList: List[Int] = List(), cur: Int = 2): List[Int] = {
    if (until <= 0) throw new InputException(StrictNegativeInput)
    else if (cur * cur > until) squaresList
    else generateSquaresLogic(squaresList :+ cur * cur, cur + 1)
  }

  /**
    * Returns the list of all the binary divisors of a number.
    */
  def generateBinaryDivisors: List[Int] = Try(generateBinaryDivisorsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"listBinaryDivisors\" got " + ex.toString)
  }

  /**
    * Sub-function for listBinaryDivisors(), to provide deep recursion handling.
    */
  private def generateBinaryDivisorsLogic(divisorsList: List[Int] = List(), total: Int = 2): List[Int] = {
    if (total == until) divisorsList :+ until
    else if (total > until) divisorsList
    else if (until % total == 0) generateBinaryDivisorsLogic(divisorsList :+ total, total * 2)
    else generateBinaryDivisorsLogic(divisorsList, total * 2)
  }

  /**
    * Returns the list of all the n-multiply divisors of a number.
    */
  def generateN_MultipleDivisors(n: Int): List[Int] = {
    if (n != 1)
      Try(generateN_MultipleDivisorsLogic(n, total = n)) match {
        case Success(something) => something
        case Failure(ex) => throw new InputException("\"listN_MultipleDivisors\" got " + ex.toString)
      }
    else generateArithmeticRegressionLogic(until).reverse
  }

  /**
    * Sub-function for listN_MultipleDivisors(), to provide deep recursion handling.
    */
  private def generateN_MultipleDivisorsLogic(n: Int, divisorsList: List[Int] = List(), total: Int): List[Int] = {
    if (total == until) divisorsList :+ until
    else if (total > until) divisorsList
    else if (until % total == 0) generateN_MultipleDivisorsLogic(n, divisorsList :+ total, total * n)
    else generateN_MultipleDivisorsLogic(n, divisorsList, total * n)
  }

  /**
    * Returns the list of all the divisors of a number.
    */
  def generateDivisors: List[Int] = Try(generateDivisorsLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for listDivisors(), to provide deep recursion handling.
    */
  private def generateDivisorsLogic(divisorsList: List[Int] = List(until), total: Int = 1): List[Int] = {
    if (until < 0) throw new InputException("\"listDivisors\" " + NegativeInput)
    else if (total == until / 2 + 1) divisorsList
    else if (total > until / 2) divisorsList
    else if (until % total == 0) generateDivisorsLogic(divisorsList :+ total, total + 1)
    else generateDivisorsLogic(divisorsList, total + 1)
  }

  /**
    * Returns the list of all the divisors of a number.
    */
  def generatePrimeDivisors: List[Int] = Try(generatePrimeDivisorsLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generatePrimeDivisors.
    */
 private def generatePrimeDivisorsLogic(divisorsList: List[Int] = List()): List[Int] = {
   if (until < 0) throw new InputException("\"listDivisors\" " + NegativeInput)
   else until.generateDivisors.filter {cur => cur == 1 || cur.isPrime }.filter {cur => cur != 1}
 }


  /**
    * Generates Carmichael numbers in a range from 1 to until.
    *
    * WARNING: in case of using factorisation, input over 100.000 is hard-code deprecated.
    */
  def generateCarmichaelNumbers: List[Int] = Try(generateCarmichaelNumbersLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generateCarmichaelNumbers.
    */
  private def generateCarmichaelNumbersLogic(outcomeList: List[Int] = List(), cur: Int = 3): List[Int] = {
    if (until > 100000) throw new InputException(StackOverflowInput)
    else if (until <= 1) throw new InputException(StrictNegativeInput)
    else if (cur > until) outcomeList
    else if (cur.isCarmichael) generateCarmichaelNumbersLogic(outcomeList :+ cur, cur + 1)
    else generateCarmichaelNumbersLogic(outcomeList, cur + 1)
  }


}



object IntegerGenerators {
  implicit def intToGenerators(a: Int): IntegerGenerators = new IntegerGenerators(a)
}
