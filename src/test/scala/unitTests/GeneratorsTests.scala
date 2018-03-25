package unitTests

import org.scalatest.FunSuite
import integerOperations.Generators._
import org.scalatest.Matchers._


class GeneratorsTests extends FunSuite {

  final val emptyList = List()

  test("Testing of arithmeticProgression") {
    10.generateArithmeticProgression shouldBe List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    1.generateArithmeticProgression shouldBe List(1)

  }

  test("Testing of arithmeticRegression") {
    10.generateArithmeticRegression shouldBe List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reverse
    1.generateArithmeticRegression shouldBe List(1)

  }

  test("Testing of listDivisors") {
    0.generateDivisors shouldBe List(0)
    100.generateDivisors shouldBe List(1, 2, 4, 5, 10, 20, 25, 50, 100)
    /**
      * WORKS SLOWLY (2-3 sec) can be activated/deactivated
      */
    //1000000000.listDevisors should be
  }

  test("Testing of listBinaryDivisors") {
    100.generateBinaryDivisors shouldBe List(2, 4)
    64.generateBinaryDivisors shouldBe List(2, 4, 8, 16, 32, 64)
    3.generateBinaryDivisors shouldBe emptyList
  }

  test("Testing of listN_MultipleDivisors") {
    100.generateN_MultipleDivisors(100) shouldBe List(100)
    10.generateN_MultipleDivisors(1) shouldBe List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  }

}