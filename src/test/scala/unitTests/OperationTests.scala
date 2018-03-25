package unitTests

import org.scalatest.Matchers._
import org.scalatest.FunSuite
import functionalAlgorithms.Changes._
import utils.InputException

class OperationTests extends FunSuite {

  final val emptyList = List()

  test("Testing of countSignChanges") {

    val intTestingSignChangesList1: List[Int] = List(-1, 2, -1, 2, -1, -21, -10, 20, 20, 20, 35, -11)
    val intTestingSignChangesList2: List[Int] = List(1, 1, 1, 1, 1, 1)

    countSignChanges(intTestingSignChangesList1) shouldBe List(3, 3)
    countSignChanges(intTestingSignChangesList2) shouldBe List(0, 0)

    assertThrows[InputException] {
      countSignChanges(emptyList)
    }
  }

  test("Testing of countLetterChanges") {
    val testingLetterChangesList1: List[Char] = List('a', 'A', 'b', 'B', 'a', 'b', 'c', 'C')
    val testingLetterChangesList2: List[Char] = List('a', 'a', 'a', 'a')

    countLetterChanges(testingLetterChangesList1) shouldBe List(2, 1)
    countLetterChanges(testingLetterChangesList2) shouldBe List(0, 0)

    assertThrows[InputException] {
      countLetterChanges(emptyList)
    }
  }





}
