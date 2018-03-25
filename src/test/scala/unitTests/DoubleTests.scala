package unitTests
import org.scalatest.FunSuite
import org.scalatest.Matchers._
import doubleOperations.DoubleProperties._

class DoubleTests extends FunSuite {

  test("Testing of inverse") {
    17.inverse shouldBe 0.058823529411764705
    2.inverse shouldBe 0.5
    -1.inverse shouldBe -1
  }

  test("Testing of sqrDouble") {
    17.0.sqrDouble shouldBe 289.0
    0.sqrDouble shouldBe 0
    -1.0.sqrDouble shouldBe 1
  }

}
