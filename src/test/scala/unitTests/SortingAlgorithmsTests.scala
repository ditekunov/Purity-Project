package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import sortingAlgorithms._
import sortingAlgorithms.unseriousAlgorithms._

class SortingAlgorithmsTests extends FunSuite {
  final lazy val unsortedList = List(8, 4, 6, 1, 7, 3, 8, 4, 7, 9, 2, 7)
  final lazy val sortedList = List(1, 2, 3, 4, 5, 6, 7, 8)
  final lazy val emptyList = List()

  test("Testing of the quickSort") {
    QuickSort.quickSort(unsortedList) shouldBe List(1, 2, 3, 4, 4, 6, 7, 7, 7, 8, 8, 9)
    QuickSort.quickSort(sortedList) shouldBe sortedList
    QuickSort.quickSort(emptyList) shouldBe emptyList
  }

  test("Testing of the bogosort") {
    Bogosort.bogosort(sortedList) shouldBe sortedList
    Bogosort.bogosort(List(3, 2, 1)) shouldBe List(1, 2, 3)
    Bogosort.bogosort(emptyList) shouldBe emptyList
  }

  test("Testing of the sleepSort") {
    SleepSort.sleepSort(unsortedList) should be
    SleepSort.sleepSort(sortedList) should be
    SleepSort.sleepSort(emptyList) should be
  }

  test("Testing of the bubbleSort") {
    BubbleSort.bubbleSort(sortedList) shouldBe sortedList
    BubbleSort.bubbleSort(unsortedList) shouldBe List(1, 2, 3, 4, 4, 6, 7, 7, 7, 8, 8, 9)
    BubbleSort.bubbleSort(emptyList) shouldBe emptyList
  }

  test("Testing of the mergeSort") {
    MergeSort.mergeSort(sortedList) shouldBe sortedList
    MergeSort.mergeSort(unsortedList) shouldBe List(1, 2, 3, 4, 4, 6, 7, 7, 7, 8, 8, 9)
    MergeSort.mergeSort(emptyList) shouldBe emptyList
  }

  test("Testing of the insertionSort") {
    InsertionSort.insertionSort(sortedList) shouldBe sortedList
    InsertionSort.insertionSort(unsortedList) shouldBe List(1, 2, 3, 4, 4, 6, 7, 7, 7, 8, 8, 9)
    InsertionSort.insertionSort(emptyList) shouldBe emptyList
  }
  
  test("Testing of the selectionSort") {
    SelectionSort.selectionSort(sortedList) shouldBe sortedList
    SelectionSort.selectionSort(unsortedList) shouldBe List(1, 2, 3, 4, 4, 6, 7, 7, 7, 8, 8, 9)
    SelectionSort.selectionSort(emptyList) shouldBe emptyList
  }
}
