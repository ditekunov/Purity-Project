package time

import utils.InputException
import utils.ExceptionMessages.WrongTimeInput

class Time(val input: Int) {
  import Time._

  /**
    * Service functions
    */
  private def up60: Int = 
    if (input < 0) throw new InputException(WrongTimeInput)
    else input * 60

  private def down60: Int =
    if (input < 0) throw new InputException(WrongTimeInput)
    else input / 60

  /**
    * Converts seconds to hours
    */
  def hoursToSeconds: Int = (input up60) up60

  /**
    * Converts minutes to hours
    */
  def minutesToSeconds: Int = input up60

  /**
    * Converts seconds to minutes
    */
  def secondsToMinutes: Int = input down60

  /**
    * Converts seconds to hours
    */
  def secondsToHours: Int = (input down60) down60

  /**
    * Converts hours to minutes
    */
  def hoursToMinutes: Int = input up60

  /**
    * Converts minutes to hours
    */
  def minutesToHours: Int = input down60
  
}

object Time {
  implicit def intToTime(a: Int): Time = new Time(a)
}
