package unitTests

import org.scalatest.Matchers._
import org.scalatest.FunSuite
import rationalOperations.Rational

class RationalOperationsTests extends FunSuite {

  val firstRational = new Rational(12,1)
  val secondRational = new Rational(8,2)

  test("Testing of the basic rational operations") {
    (firstRational / secondRational).toString shouldBe "3/1"
    (firstRational * secondRational).toString shouldBe "48/1"
    (firstRational - secondRational).toString shouldBe "3/1"
    (firstRational + secondRational).toString shouldBe "3/1"
    (firstRational > secondRational) shouldBe True
    (firstRational < secondRational) shouldBe False
    (firstRational >= secondRational) shouldBe True
    (firstRational <= secondRational) shouldBe False
    firstRational.sqr.toString shouldBe "144/1"
  }
}
