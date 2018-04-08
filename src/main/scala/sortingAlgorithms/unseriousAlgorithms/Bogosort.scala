package sortingAlgorithms.unseriousAlgorithms

import listOperations.ListProperties.isSorted

import scala.annotation.tailrec
import scala.util.Random.shuffle


/**
  * This object contains function, that realises bogosort algorithm.
  *
  * https://en.wikipedia.org/wiki/Bogosort
  *
  * Worst speed: Unbounded
  *
  * Average speed: O((n+1)!)
  *
  * Best speed: O(n)
  *
  * Purity project by Daniil Tekunov.
  */
object Bogosort {

  @tailrec
  def bogosort(input: List[Int]): List[Int] =
    if (isSorted(input)) input
    else bogosort(shuffle(input))
}
