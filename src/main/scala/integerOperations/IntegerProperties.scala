package integerOperations


import utils.InputException
import scala.util.{Failure, Success, Try}
import utils.ExceptionMessages.NegativeInput

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
    * Finds the sum of number's digits
    */
  def sumOfDigits: Int = Try(sumOfDigitsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for sumOfDigits(), to provide errors handling
    */
  private def sumOfDigitsLogic(cur: Int = firstInt, sum: Int = 0): Int = cur match {
    case 0 => sum
    case _ => sumOfDigitsLogic(cur / 10, sum + (cur % 10))
  }

  /**
    * Finds the composition of number's digits
    */
  def compositionOfDigits: Int = Try(compositionOfDigitsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for compositionOfDigits(), to provide errors handling
    */
  private def compositionOfDigitsLogic(cur: Int = firstInt, comp: Int = 1): Int = cur match {
    case 0 => if (firstInt == 0) 0 else comp
    case _ => compositionOfDigitsLogic(cur / 10, comp * (cur % 10))
  }

  /**
    * Finds the number of digits in a number
    */
  def numOfDigits: Int = Try(numOfDigitsLogic()) match {
    case Success(something) => something
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for numOfDigits(), to provide errors handling
    */
  private def numOfDigitsLogic(cur: Int = firstInt, comp: Int = 0): Int = cur match {
    case 0 => if (firstInt == 0) 1 else comp
    case _ => numOfDigitsLogic(cur / 10, comp + 1)
  }

  /**
    * Returns the list of all the divisors of a number.
    */
  def listDevisors: List[Int] = Try(listDevisorsLogic()) match {
    case Success(something) => something.sorted
    case Failure(ex) => throw new InputException(ex.toString)
  }

  /**
    * Sub-function for devisors(), to provide deep recursion handling
    */
  private def listDevisorsLogic(devisorsList: List[Int] = List(firstInt), total: Int = 1): List[Int] = {
      if (total == firstInt / 2) {
        devisorsList :+ total
      }
      else if (total > firstInt / 2) devisorsList
      else if (firstInt % total == 0) listDevisorsLogic(devisorsList :+ total, total + 1)
      else listDevisorsLogic(devisorsList, total + 1)
  }

  /**
    * Finds the greatest devisor of a number
    */
  def nthGreatestDevisor(nPosition: Int): Int = {
    if (nPosition < 0) throw new InputException("\"nthGreatestDevisor\" " + NegativeInput)
    else Try(firstInt.listDevisors.sortWith(_ > _)(nPosition)) match {
      case Success(something) => something
      case Failure(ex) => throw new InputException("\"nthGreatestDevisor\" got " + ex.toString)
    }

  }


}

object IntegerProperties {
  implicit def intToIntegerProperties(a: Int): IntegerProperties = new IntegerProperties(a)
}
