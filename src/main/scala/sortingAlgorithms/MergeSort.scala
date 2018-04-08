package sortingAlgorithms

/**
  * This object contains function, that realises merge sort algorithm.
  *
  * https://en.wikipedia.org/wiki/Merge_sort
  *
  * Worst speed: O(n*log(n))
  *
  * Average speed: O(n*log(n))
  *
  * Best speed: O(n*log(n))
  *
  * Purity project by Daniil Tekunov.
  */
object MergeSort {

  def mergeSort(input: List[Int]): List[Int] = {
    // If length of a list is 0, then we just return an empty list
    if (input.length / 2 == 0) input
    else {
      // else, we split the list by two parts - left and right
      val (left, right) = input.splitAt(input.length / 2)
      // and merge recursively parts of the list
      merge(mergeSort(left), mergeSort(right))
    }
  }

    private def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
        // if the left part of a list is a single element, we return this element
        case (_, Nil) => left
        // if the right part of a list is a single element, we return this element
        case (Nil, _) => right
        // if they are both non-empty,
        case (leftHead :: leftTail, rightHead :: rightTail) =>
          // we merge the biggest part of a list with merged smaller part
          if (leftHead < rightHead) leftHead::merge(leftTail, right)
          else rightHead :: merge(left, rightTail)
  }

}
