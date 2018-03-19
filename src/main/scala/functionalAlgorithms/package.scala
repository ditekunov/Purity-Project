import utils.EmptyInputException

import scala.concurrent.{ExecutionContext, Future}



package object functionalAlgorithms {

  /**
    * Returns nth element of a sequence
    */
  def getElement[A](input: List[A]): A = input match {
    case element :: _ :: Nil => element
    case _ :: tail => getElement(tail)
    case _ => throw new EmptyInputException("\"getElement()\" function Expected Some(), got None instead")
  }

  /**
    * Checks, whether a value is a palindrome
    */
  def isPalindrome[A](input: List[A]): Boolean = {
    if (input.isEmpty) throw new EmptyInputException("\"getElement()\" function Expected Some(), got None instead")
    else input == input.reverse
  }

  /**
    * Checks, whether a value is a palindrome
    */
  def isPalindrome[A](input: A): Boolean = input match {
    case None => throw new EmptyInputException("\"getElement()\" function Expected Some(), got None instead")

    case Some(element) => element.toString == element.toString.reverse
  }







}
