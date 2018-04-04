package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import listOperations.ListProperties._
import utils.InputException

class ListsTests extends FunSuite {

  final lazy val testListOFChars = List('A', 'B', 'C', 'D')
  final lazy val sortedTestListOfIntegers = List(1, 2, 3, 4, 5)
  final lazy val unsortedListOfIntegers = List(5, 3, 5, 1, 9, 77)
  final lazy val emptyList = List()

  test("Testing of get()") {

    get(testListOFChars, 3) shouldBe 'D'
    assertThrows[InputException] {
      get(testListOFChars, 4)
    }
    get(sortedTestListOfIntegers, 3) shouldBe 4
  }

  test("Testing of isPalindrome") {

  }

  test("Testing of isSorted") {
    isSorted(sortedTestListOfIntegers) shouldBe true
    isSorted(unsortedListOfIntegers) shouldBe false
    isSorted(emptyList) shouldBe true

  }

  test("Testing of binarySearch") {
    binarySearch(sortedTestListOfIntegers, 3) shouldBe 2
    binarySearch(sortedTestListOfIntegers, 5) shouldBe 4
  }
}
