package sortingAlgorithms

import scala.annotation.tailrec

/**
  * This object contains function, that realises insertion sorting algorithm.
  *
  * https://en.wikipedia.org/wiki/Insertion_sort
  *
  * Worst speed: O(pow(n))
  *
  * Average speed: O(pow(n))
  *
  * Best speed: O(n)
  *
  * Purity project by Daniil Tekunov.
  */
object InsertionSort {

  def insertionSort(list: List[Int]): List[Int] = sorting(list, Nil) match {
    case Nil => List()
    case something => something
  }

  @tailrec
  private def sorting(basis: List[Int], finalisedList: List[Int]): List[Int] = basis match {
    // if a list contains more than a single element, we insert the first element into thr outcome list
    case element :: tailElements => sorting(tailElements, insertion(element, finalisedList))
    // else we return outcome list
    case Nil => finalisedList
  }

  private def insertion(incomeElement: Int, outputList: List[Int]): List[Int] = outputList match {
    // if an income element is greater than first element in output list
    case element :: tailElements if incomeElement > element =>
      // we sort outcome list and insert the element at the beginning of it
      element :: insertion(incomeElement, tailElements)
      // else we put  income element athe beginning of a list
    case _ => incomeElement :: outputList
  }

}
