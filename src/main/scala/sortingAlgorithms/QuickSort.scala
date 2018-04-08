package sortingAlgorithms

/**
  * This object contains function, that realises quick sorting algorithm.
  *
  * https://en.wikipedia.org/wiki/Quicksort
  *
  * Worst speed: O(pow(n))
  *
  * Average speed: O(n*log(n))
  *
  * Best speed: O(n*log(n))
  *
  * In case that we take first element as pivot, algorithm works worse with sorted lists.
  *
  * Purity project by Daniil Tekunov.
  */
object QuickSort {

  def quickSort(list: List[Int]): List[Int] = {
    list match {
        // If a list contains no elements, we do not return anything.
      case Nil => Nil
        // If a list contains only one element, we just return it.
      case singleElement :: Nil => List(singleElement)
        // If a list contains more than one element,
      case middleElem :: tail =>
        // we quickSort the part of the list, that is less than middle element,
          quickSort(tail.filter(lessElem => lessElem <= middleElem)) :::
        // we add middle element to a sorted part above.
          List(middleElem) :::
        // and we quickSort the part of the list, that is greater than middle element and add it to a list above.
          quickSort(tail.filter(greaterElem => greaterElem > middleElem))
    }
  }
}
