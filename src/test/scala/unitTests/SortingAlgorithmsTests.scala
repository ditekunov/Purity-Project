package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import sortingAlgorithms._

class SortingAlgorithmsTests extends FunSuite {
  final lazy val unsortedList = List(8,4,6,1,7,3,8,4,7,9,2,7)
  final lazy val sortedList = List(1,2,3,4,5,6,7,8)
  final lazy val emptyList = List()

test("Testing of the quickSort") {
  QuickSort.quickSort(unsortedList) shouldBe List(1, 2, 3, 4, 4, 6, 7, 7, 7, 8, 8, 9)
  QuickSort.quickSort(sortedList) shouldBe sortedList
  QuickSort.quickSort(emptyList) shouldBe emptyList
}

}
