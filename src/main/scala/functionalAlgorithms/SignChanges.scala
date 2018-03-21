package functionalAlgorithms

import functionalAlgorithms.miscellaneous.CurrentAndPositiveNegativeCounters
import functionalAlgorithms.miscellaneous.CustomImplicitConversions._
import utils.InputException
import utils.ExceptionMessages.emptyInput

object SignChanges {

  /**
    * Checks if element's sign changed from positive to negative
    */
  private def isPositiveToNegative(a: Int, b: Int): Boolean =  a > 0 && b < 0

  /**
    * Checks if element's sign changed from negative to positive
    */
  private def isNegativeToPositive(a: Int, b: Int): Boolean =  a < 0 && b > 0

  /**
    * Counts, whether there were changes form positive integer to negative integer
    */
  def countSignChanges(input: List[Int]): List[Int] = input match {
    case List() =>
      throw new InputException("\"RLE encoding\" " + emptyInput)
    case _ =>
      val outcomeTuple = input.foldLeft(CurrentAndPositiveNegativeCounters()) (
        (fin: CurrentAndPositiveNegativeCounters, cur: Int) =>
          (cur,
            if (isPositiveToNegative(fin.current, cur)) fin.counterOfPositiveToNegative + 1
            else fin.counterOfPositiveToNegative,

            if (isNegativeToPositive(fin.current, cur)) fin.counterOfNegativeToPositive + 1
            else fin.counterOfNegativeToPositive)
    )

    List(outcomeTuple.counterOfPositiveToNegative, outcomeTuple.counterOfNegativeToPositive)
  }

}
