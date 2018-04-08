package integerOperations

import utils.InputException
import utils.ExceptionMessages.NegativeInput
import integerOperations.IntegerProperties._

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

/**
  * Contains generators, that use more specific math or algorithms.
  *
  * Purity project by Daniil Tekunov.
  */
class IntegerGeneratorsMath(val til: Int) {

  import IntegerGeneratorsMath._

  /**
    * Generates prime numbers using Sieve of Eratosthenes.
    */
  def generateEratosthenesPrimes: List[Int] =
    Try(generateEratosthenesPrimesLogic(Stream.from(2)).take(til)) match {
      case Success(something) => something.toList
      case Failure(ex) => throw new InputException(ex.toString)
    }

  /**
    * Sub-function for generateEratosthenesPrimes
    */
  private def generateEratosthenesPrimesLogic(input: Stream[Int]): Stream[Int] =
    input.head #:: generateEratosthenesPrimesLogic(input.tail.filter(_ % input.head != 0))

  /**
    * Generates Fermat numbers in range from 1 to until.
    */
  def generateFermatNumbers: List[Int] = Try(generateFermatNumbersLogic()) match {
    case Success(something) =>
      if (something == List(3)) something
      else something.tail

    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for generateFermatNumbers
    */
  @tailrec
  private def generateFermatNumbersLogic(outcomeList: List[Int] = List(3), cur: Int = 3): List[Int] = {
    if (til < 3) throw new InputException("\"generateCatalanNumbers\" " + NegativeInput)
    else if (til < 5) List(3)
    else if (outcomeList.last > til) outcomeList.init
    else generateFermatNumbersLogic(outcomeList :+ cur, (cur - 1).sqr + 1)
  }

}

object IntegerGeneratorsMath {
  implicit def intToGenerators(a: Int): IntegerGeneratorsMath = new IntegerGeneratorsMath(a)
}