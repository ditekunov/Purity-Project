package listOperations

import utils.ExceptionMessages.{EmptyInput, NoneInput}
import utils.InputException

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

/**
  * Contains different functions, that affect lists.
  *
  * Purity project by Daniil Tekunov.
  */
object ListProperties {

  /**
    * Returns nth element of a list.
    */
  def get[A](input: List[A], index: Int): A = (index, input) match {
    case (0, element :: _) => element
    case (n,  _  :: tail ) => get(tail, n - 1)
    case (_, Nil         ) => throw new InputException("\"getElement\" " + EmptyInput)
  }

  /**
    * Checks, whether a list is a palindrome.
    */
  def isPalindrome[A](input: List[A]): Boolean = {
    if (input.isEmpty) throw new InputException("\"isPalindrome\" " + EmptyInput)
    else input == input.reverse
  }

  /**
    * Checks, whether a value is a palindrome.
    */
  def isPalindrome[A](input: A): Boolean = input match {
    case None => throw new InputException("\"isPalindrome\" " + NoneInput)

    case Some(element) => element.toString == element.toString.reverse
  }

  /**
    * Checks whether the list is sorted.
    */
  def isSorted(input: List[Int])(implicit ord: Ordering[Int]): Boolean = input match {
    case List() => true
    case List(_) => true
    case _ => input.sliding(2).forall {
      case List(firstElement, secondElement) => ord.lteq(firstElement, secondElement)
    }
  }

  /**
    * Realisation of a standard binary search.
    *
    * https://en.wikipedia.org/wiki/Binary_search_algorithm
    *
    * Worst speed: O(log(n))
    *
    * Average speed: O(log(n))
    *
    * Best speed: O(1)
    *
    */
  @tailrec
  def binarySearch(input: List[Int], element: Int): Int = {
    @tailrec
    def binarySearchLogic(enter: Int = 0, exit: Int = input.length - 1): Option[Int] =
      enter + (exit - enter) / 2 match {
        case between if input(between) > element => binarySearchLogic(enter, exit - between)
        case between if input(between) < element => binarySearchLogic(enter + between)
        case between if input(between) == element => Some(between)
        case _ if enter < exit => None
    }

    if (input.isEmpty) throw new InputException(EmptyInput)
    else if (!isSorted(input)) binarySearch(input.sorted, element)
    else if (input.last == element) input.length - 1
    else Try(binarySearchLogic()) match {
      case Success(something) => something.get
      case Failure(_) => throw new InputException(NoneInput)
    }
  }

  /**
    * Realisation of a standard linear search.
    *
    * https://en.wikipedia.org/wiki/Linear_search
    *
    * Worst speed: O(n)
    *
    * Average speed: O(n/2)
    *
    * Best speed: O(1)
    *
    */
  def linearSearch[A](input: List[A], element: A): Int = {

    @tailrec
    def linearSearchLogic[B](input: List[B], element: B, iter: Int = 0): Int = input match {
      case elem :: tail =>
        if (elem == element) iter
        else linearSearchLogic(tail, element, iter + 1)
      case Nil => throw new InputException()
    }

    if (input.nonEmpty) linearSearchLogic(input, element)
    else throw new InputException(NoneInput)
  }
 
 def generatePermutations[A](s: List[A], k: Int): List[List[A]] = 
    if (k > s.size) throw new InputException()
    else if (k == 1) s.map(List(_))
    else generatePermutations(s.tail, k - 1).map(_ + s.head) ++ combinations(s.tail, k)

}
