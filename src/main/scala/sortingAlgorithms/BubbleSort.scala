package sortingAlgorithms
import scala.annotation.tailrec

/**
  * This object contains function, that realises bubble sorting algorithm.
  *
  * https://en.wikipedia.org/wiki/Bubble_sort
  *
  * Worst speed: O(pow(n))
  *
  * Average speed: O(pow(n))
  *
  * Best speed: O(n)
  *
  * Purity project by Daniil Tekunov.
  */
object BubbleSort {

  def bubbleSort(basicList: List[Int]): List[Int] = basicList match {
    case List() => List()
    case _ => bubble(basicList, Nil, Nil)
  }

  @tailrec
  private def bubble(basic: List[Int], rest: List[Int], sorted: List[Int]): List[Int] = basic match {
    // If we have a single element in a basic list
    case element :: Nil =>
      // end the rest list is empty, we add that element to a sorted list
      if (rest.isEmpty) element :: sorted
      // else we add this element to a sorted list and call the function again, without that element
      else bubble(rest, Nil, element :: sorted)
    // If we have 2+ elements
    case firstElement :: secondElement :: next =>
      // if first found element is greater, than another, we call the function again, without second element
      // and we add second element to the rest list
      if (firstElement > secondElement) bubble(firstElement :: next, secondElement :: rest, sorted)
      //else we realize that operation, via swapped elements
      else bubble(secondElement :: next, firstElement :: rest, sorted)
  }

}
