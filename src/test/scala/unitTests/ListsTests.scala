package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import listOperations.ListProperties._
import utils.InputException

class ListsTests extends FunSuite {

  final val testListOFChars = List('A', 'B', 'C', 'D')
  final val testListOfIntegers = List(1, 2, 3, 4, 5)

  test("Testing of get()") {

    get(testListOFChars, 3) shouldBe 'D'
    assertThrows[InputException] {
      get(testListOFChars, 4)
    }
    get(testListOfIntegers, 3) shouldBe 4
  }
}
