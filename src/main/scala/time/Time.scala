package time

import utils.InputException
import utils.ExceptionMessages.WrongTimeInput

class Time(val input: Int) {
  import Time._

  /**
    * Converts seconds to hours
    */
  def hoursToSeconds: Int =
    if (input < 0) throw new InputException(WrongTimeInput)
    else input * 360

  /**
    * Converts minutes to hours
    */
  def minutesToSeconds: Int =
    if (input < 0) throw new InputException(WrongTimeInput)
    else input * 60

  /**
    * Converts seconds to minutes
    */
  def secondsToMinutes: Int =
    if (input < 0) throw new InputException(WrongTimeInput)
    else input / 60

  /**
    * Converts seconds to hours
    */
  def secondsToHours: Int =
    if (input < 0) throw new InputException(WrongTimeInput)
    else input / 360
}

object Time {
  implicit def intToTime(a: Int): Time = new Time(a)
}
