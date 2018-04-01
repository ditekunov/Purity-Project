package functionalAlgorithms.decoders

import utils.InputException
import utils.ExceptionMessages.NegativeOrZeroInput

import scala.annotation.tailrec

object GrayDecoder {
  def decode(input: Int) = {
    if (input > -1) decodeLogic(input)
    else throw new InputException("\"GrayDecoder\" " + NegativeOrZeroInput)}

  @tailrec
  private def decodeLogic(cur: Int, outcome: Int = 0): Int = {
    if (cur != 0) decodeLogic(cur >> 1, outcome ^ cur)
    else outcome
  }

}
