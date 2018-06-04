package unitTests

import org.scalatest.Matchers._
import org.scalatest.FunSuite
import utils.InputException
import time.Time._


class TimeTests extends FunSuite {

  test("Testing of basic time functions") {
    10.hoursToSeconds shouldBe 3600
    360.secondsToHours shouldBe 1
    60.secondsToMinutes shouldBe 1
    10.minutesToSeconds shouldBe 60

    assertThrows[InputException] {
      -1.secondsToMinutes
    }
}
