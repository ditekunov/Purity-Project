package integerOperations

import utils.InputException
import utils.ExceptionMessages.{NegativeOrZeroInput, StackOverflowInput, NegativeInput}
import scala.util.{Failure, Random, Success, Try}
import IntegerProperties._
import IntegerMath._

import scala.annotation.tailrec

class IntegerGenerators(val til: Int) {

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
  @tailrec
  private def generateArithmeticRegressionLogic(cur: Int = til, regressionList: List[Int] = List()): List[Int] = {
    if (til < 0) throw new InputException("\"generateArithmeticRegression\" " + NegativeOrZeroInput)
      if (cur == 0) regressionList
      else generateArithmeticRegressionLogic(cur - 1, regressionList :+ cur)
    }

  /**
    * Generates list in range from 1 to until
    *
    * https://en.wikipedia.org/wiki/Arithmetic_progression
    */
  def generateArithmeticProgression: List[Int] = Try(generateArithmeticProgressionLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"generateArithmeticProgression\" " + ex.toString)
  }

  /**
    * Sub-function for generateArithmeticProgression
    */
  @tailrec
  private def generateArithmeticProgressionLogic(cur: Int = 1, regressionList: List[Int] = List()): List[Int] = {
    if (til < 0) throw new InputException("\"generateArithmeticProgression\" " + NegativeOrZeroInput)
    if (cur == til) regressionList :+ cur
    else generateArithmeticProgressionLogic(cur + 1, regressionList :+ cur)
  }

  /**
    * Generates squares in range from 2 to firstInt
    *
    * https://en.wikipedia.org/wiki/Square_number
    */
  def generateSquares: List[Int] = Try(generateSquaresLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"generateSquares\" got " + ex.toString)
  }

  /**
    * Sub-function for generateSquares
    */
  @tailrec
  private def generateSquaresLogic(squaresList: List[Int] = List(), cur: Int = 2): List[Int] = {
    if (til <= 0) throw new InputException(NegativeInput)
    else if (cur * cur > til) squaresList
    else generateSquaresLogic(squaresList :+ cur * cur, cur + 1)
  }

  /**
    * Returns the list of all the binary divisors of a number.
    *
    * https://en.wikipedia.org/wiki/Divisor
    */
  def generateBinaryDivisors: List[Int] = Try(generateBinaryDivisorsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException("\"listBinaryDivisors\" got " + ex.toString)
  }

  /**
    * Sub-function for listBinaryDivisors(), to provide deep recursion handling.
    */
  @tailrec
  private def generateBinaryDivisorsLogic(divisorsList: List[Int] = List(), total: Int = 2): List[Int] = {
    if (total == til) divisorsList :+ til
    else if (total > til) divisorsList
    else if (til % total == 0) generateBinaryDivisorsLogic(divisorsList :+ total, total * 2)
    else generateBinaryDivisorsLogic(divisorsList, total * 2)
  }

  /**
    * Returns the list of all the n-multiply divisors of a number.
    *
    * https://en.wikipedia.org/wiki/Divisor
    */
  def generateN_MultipleDivisors(n: Int): List[Int] = {
    if (n != 1)
      Try(generateN_MultipleDivisorsLogic(n, total = n)) match {
        case Success(something) => something
        case Failure(ex) => throw new InputException("\"listN_MultipleDivisors\" got " + ex.toString)
      }
    else generateArithmeticRegressionLogic(til).reverse
  }

  /**
    * Sub-function for listN_MultipleDivisors(), to provide deep recursion handling.
    */
  @tailrec
  private def generateN_MultipleDivisorsLogic(n: Int, divisorsList: List[Int] = List(), total: Int): List[Int] = {
    if (total == til) divisorsList :+ til
    else if (total > til) divisorsList
    else if (til % total == 0) generateN_MultipleDivisorsLogic(n, divisorsList :+ total, total * n)
    else generateN_MultipleDivisorsLogic(n, divisorsList, total * n)
  }

  /**
    * Returns the list of all the divisors of a number.
    *
    * https://en.wikipedia.org/wiki/Divisor
    */
  def generateDivisors: List[Int] = Try(generateDivisorsLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for listDivisors(), to provide deep recursion handling.
    */
  @tailrec
  private def generateDivisorsLogic(divisorsList: List[Int] = List(til), total: Int = 1): List[Int] = {
    if (til < 0) throw new InputException("\"listDivisors\" " + NegativeOrZeroInput)
    else if (total == til / 2 + 1) divisorsList
    else if (total > til / 2) divisorsList
    else if (til % total == 0) generateDivisorsLogic(divisorsList :+ total, total + 1)
    else generateDivisorsLogic(divisorsList, total + 1)
  }

  /**
    * Returns the list of all the divisors of a number.
    *
    * https://en.wikipedia.org/wiki/Prime_number
    */
  def generatePrimeDivisors: List[Int] = Try(generatePrimeDivisorsLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generatePrimeDivisors.
    */
 private def generatePrimeDivisorsLogic(divisorsList: List[Int] = List()): List[Int] = {
   if (til < 0) throw new InputException("\"listDivisors\" " + NegativeOrZeroInput)
   else til.generateDivisors.filter { cur =>( cur == 1 || cur.isPrime) && cur != 1 }
 }


  /**
    * Generates Carmichael numbers in a range from 1 to until.
    *
    * WARNING: in case of using factorisation, input over 100.000 is hard-code deprecated.
    *
    * https://en.wikipedia.org/wiki/Carmichael_number
    */
  def generateCarmichaelNumbers: List[Int] = Try(generateCarmichaelNumbersLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generateCarmichaelNumbers.
    */
  @tailrec
  private def generateCarmichaelNumbersLogic(outcomeList: List[Int] = List(), cur: Int = 3): List[Int] = {
    if (til > 100000) throw new InputException(StackOverflowInput)
    else if (til <= 1) throw new InputException(NegativeInput)
    else if (cur > til) outcomeList
    else if (cur.isCarmichael) generateCarmichaelNumbersLogic(outcomeList :+ cur, cur + 1)
    else generateCarmichaelNumbersLogic(outcomeList, cur + 1)
  }

  /**
    * Generates Lucas-Carmichael numbers in a range from 1 to until.
    *
    * WARNING: in case of using factorisation, input over 100.000 is hard-code deprecated.
    *
    * https://en.wikipedia.org/wiki/Lucas–Carmichael_number
    */
  def generateLucasCarmichaelNumbers: List[Int] = Try(generateLucasCarmichaelNumbersLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generateLucasCarmichaelNumbers.
    */
  @tailrec
  private def generateLucasCarmichaelNumbersLogic(outcomeList: List[Int] = List(), cur: Int = 3): List[Int] = {
    if (til > 100000) throw new InputException(StackOverflowInput)
    else if (til <= 1) throw new InputException(NegativeInput)
    else if (cur > til) outcomeList
    else if (cur.isLucas_Carmichael) generateLucasCarmichaelNumbersLogic(outcomeList :+ cur, cur + 1)
    else generateLucasCarmichaelNumbersLogic(outcomeList, cur + 1)
  }

  /**
    * Generates Fibonacci numbers in a range from 1 to until.
    *
    * https://en.wikipedia.org/wiki/Fibonacci_number
    */
  def generateFibonacci: List[Int] = Try(generateFibonacciLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generateFibonacci.
    */
  @tailrec
  private def generateFibonacciLogic(outcomeList: List[Int] = List(0), cur: Int = 1): List[Int] = {
    if (til < 0) throw new InputException("\"generateFibonacci\" " + NegativeOrZeroInput)
    else if (cur > til) outcomeList
    else generateFibonacciLogic(outcomeList :+ cur, cur + outcomeList.last)
  }

  /**
    * Generates random numbers in a range from 1 to until.
    *
    * https://en.wikipedia.org/wiki/Pseudorandom_number_generator
    */
  def generateRandomInts: List[Int] = Try(generateRandomIntsLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generateRandomInts
    */
  private def generateRandomIntsLogic(outcomeList: List[Int] = List(), cur: Int = 1): List[Int] = {
    def random(n: Int): Int = {
      val random = new Random()
      random.nextInt(n)
    }

    if (til < 0) throw new InputException("\"generateRandomInts\" " + NegativeOrZeroInput)
    else if (cur > til) outcomeList
    else generateFibonacciLogic(outcomeList :+ random(til), cur + 1)
  }

  /**
    * Generates Catalan numbers in a range from 1 to until.
    *
    * https://en.wikipedia.org/wiki/Catalan_number
    */
  def generateCatalanNumbers: List[Int] = Try(generateCatalanNumbersLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generateCatalanNumbers.
    */
  @tailrec
  private def generateCatalanNumbersLogic(outcomeList: List[Int] = List(1), cur: Int = 1 ): List[Int] = {
    if (til < 0) throw new InputException("\"generateCatalanNumbers\" " + NegativeInput)
    else if ( outcomeList.last > til) outcomeList.init
    else generateCatalanNumbersLogic(outcomeList :+ cur.nthCatalan, cur + 1)
  }

}


object IntegerGenerators {
  implicit def intToLocalImplicit(a: Int): IntegerGenerators = new IntegerGenerators(a)
}
