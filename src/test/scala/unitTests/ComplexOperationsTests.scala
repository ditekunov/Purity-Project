package unitTests

import org.scalatest.Matchers._
import org.scalatest.FunSuite
import complexOperations.Complex

class ComplexOperationsTests extends FunSuite {

  val firstRational = new Complex(12,1)
  val secondRational = new Complex(8,2)

  test("Testing of the basic rational operations") {
    (firstRational / secondRational).toString should be
    (firstRational * secondRational).toString should be
    (firstRational - secondRational).toString should be
    (firstRational + secondRational).toString should be
  }
}
