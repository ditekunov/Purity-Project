package unitTests

import org.scalatest.FunSuite
import utils.InputException
import integerOperations.IntegerGeneratorsMath._
import org.scalatest.Matchers._

class IntegerGeneratorsMathTests extends FunSuite {

  test("Testing of generateFermatNumbers") {
    258.generateFermatNumbers shouldBe List(3, 5, 17, 257)
    assertThrows[InputException] {
      (-1).generateFermatNumbers
    }
    3.generateFermatNumbers shouldBe List(3)
  }

  test("Testing of generateEratosthenesPrimes") {
    17.generateEratosthenesPrimes shouldBe List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59)
    (-1).generateEratosthenesPrimes shouldBe List()
  }

}
