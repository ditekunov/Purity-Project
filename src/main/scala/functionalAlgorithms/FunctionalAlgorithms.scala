package functionalAlgorithms

import utils.InputException
import utils.ExceptionMessages.emptyInput
import utils.ExceptionMessages.noneInput

object FunctionalAlgorithms {



  /**
    * Returns nth element of a sequence
    */
  def getElement[A](input: List[A], index: Int): A = (index, input) match {
    case (0, element :: _) => element
    case (n,  _  :: tail ) => getElement(tail, n - 1)
    case (_, Nil         ) => throw new InputException("\"getElement\" " + emptyInput)
  }

  /**
    * Checks, whether a list is a palindrome
    */
  def isPalindrome[A](input: List[A]): Boolean = {
    if (input.isEmpty) throw new InputException("\"isPalindrome\" " + emptyInput)
    else input == input.reverse
  }

  /**
    * Checks, whether a value is a palindrome
    */
  def isPalindrome[A](input: A): Boolean = input match {
    case None => throw new InputException("\"isPalindrome\" " + noneInput)

    case Some(element) => element.toString == element.toString.reverse
  }









}
