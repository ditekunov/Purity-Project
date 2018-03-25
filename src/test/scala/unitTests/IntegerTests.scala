package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import integerOperations.IntegerProperties._
import utils.InputException

class IntegerTests extends FunSuite {

  final val testEvenList: List[Int] = List(2,6,222,-2, 10000000)
  final val testOddList: List[Int] = List(1,3,15,275,100000001)
  final val testSquaresList: List[Int] = List(4,9,625,1000000)
  final val emptyList = List()

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

  test("Testing of listDivisors") {
    0.listDivisors shouldBe List(0)
    100.listDivisors shouldBe List(1, 2, 4, 5, 10, 20, 25, 50, 100)
    /**
      * WORKS SLOWLY (2-3 sec) can be activated/deactivated
      */
    //1000000000.listDevisors should be
  }

  test("Testing of nthGreatestDevisor") {
    100.nthGreatestDivisor(0) shouldBe 100
    100.nthGreatestDivisor(2) shouldBe 25
    assertThrows[InputException] {
      100.nthGreatestDivisor(100)
    }
  }

  test("Testing of listBinaryDivisors") {
    100.listBinaryDivisors shouldBe List(2, 4)
    64.listBinaryDivisors shouldBe List(2, 4, 8, 16, 32, 64)
    3.listBinaryDivisors shouldBe emptyList
  }

  test("Testing of listN_MultipleDivisors") {
    100.listN_MultipleDivisors(100) shouldBe List(100)
    10.listN_MultipleDivisors(1) shouldBe List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  }

  test("Testing of numOfDivisors") {
    100.numOfDivisors shouldBe 9
    0.numOfDivisors shouldBe 1
  }

  test("Testing of sumOfDivisors") {
    100.sumOfDivisors shouldBe 217
    0.sumOfDivisors shouldBe 0
    assertThrows[InputException] {
      -1.sumOfDivisors
    }
  }

  test("Testing of isPrime") {
    10.isPrime shouldBe false
    17.isPrime shouldBe true
    289.isPrime shouldBe false
    assertThrows[InputException] {
      1.isPrime
    }
  }

  test("Testing of gcdWith") {
    14.gcdWith(7) shouldBe 7
    21.gcdWith(7) shouldBe 7
  }

  test("testing of sqr") {
    0.sqr shouldBe 0
    7.sqr shouldBe 49
    -2.sqr shouldBe 4
  }

  test("Testing of isPrimeFermat") {
    2.isPrimeFermat() shouldBe true
    17.isPrimeFermat(100) shouldBe true
    49.isPrimeFermat(200) shouldBe false
    13.isPrimeFermat(200) shouldBe true

  }


}
