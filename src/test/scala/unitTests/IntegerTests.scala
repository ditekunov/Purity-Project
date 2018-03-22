package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import integerOperations.IntegerProperties._

class IntegerTests extends FunSuite {

  final val testEvenList: List[Int] = List(2,6,222,-2, 10000000)
  final val testOddList: List[Int] = List(1,3,15,275,100000001)
  final val testSquaresList: List[Int] = List(4,9,625,1000000)

  test("Testing of isEven") {
    testEvenList.foreach { cur: Int => cur.isEven shouldBe true }
    testOddList.foreach { cur: Int => cur.isEven shouldBe false }
  }

  test("Testing of isOdd") {
    testEvenList.foreach { cur: Int => cur.isOdd shouldBe false }
    testOddList.foreach { cur: Int => cur.isOdd shouldBe true }
  }

  test("Testing of isSquared") {
    testEvenList.foreach { cur: Int => cur.isSquared() shouldBe false }
    testSquaresList.foreach {cur: Int => cur.isSquared() shouldBe true}
  }

  test("Testing of sumOfDigits") {
    0.sumOfDigits shouldBe 0
    50.sumOfDigits shouldBe 5
    123456789.sumOfDigits shouldBe 45
  }

  test("Testing of compositionOfDigits") {
    0.compositionOfDigits shouldBe 0
    50.compositionOfDigits shouldBe 0
    999999999.compositionOfDigits shouldBe 387420489
  }

  test("Testing of numOfDigits") {
    0.numOfDigits shouldBe 1
    50.numOfDigits shouldBe 2
    999999999.numOfDigits shouldBe 9
  }

  test("Testing of devisors") {
    0.devisors shouldBe List(0)
    50.devisors shouldBe List(50, 1, 2, 5, 10, 25)
    1000000000.devisors should be
  }

}
