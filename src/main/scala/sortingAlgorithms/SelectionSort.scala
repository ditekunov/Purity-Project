package sortingAlgorithms

import scala.annotation.tailrec

/**
  * This object contains function, that realises selection sorting algorithm.
  *
  * https://en.wikipedia.org/wiki/Selection_sort
  *
  * Worst speed: O(pow(n))
  *
  * Average speed: O(pow(n))
  *
  * Best speed: O(pow(n))
  *
  */
object SelectionSort {

  def selectionSort(list: List[Int]): List[Int] = {

    def reWrite(firstPart: List[Int], secondPart: List[Int]): List[Int] = firstPart match {
      case element :: next => select(element, next, Nil, secondPart)
      case Nil => secondPart
    }

    @tailrec
    def select(firstElement: Int, secondElement: List[Int], firstPart: List[Int], secondPart: List[Int]): List[Int] =
      secondElement match {
        case element :: next =>
          if (firstElement > element) select(firstElement, next, element :: firstPart, secondPart)
          else select(element, next, firstElement :: firstPart, secondPart)
        case Nil => reWrite(firstPart, firstElement :: secondPart)
      }

    reWrite(list, Nil)

  }
}
