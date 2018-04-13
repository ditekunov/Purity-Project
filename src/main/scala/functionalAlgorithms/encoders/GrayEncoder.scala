package functionalAlgorithms.encoders

import utils.InputException
import utils.ExceptionMessages.NegativeOrZeroInput

/**
  * Contains realisation of a Gray encoding: https://en.wikipedia.org/wiki/Gray_code
  *
  * Purity project by Daniil Tekunov.
  */
object GrayEncoder {
  def encode(input: Int): Int = {
    if (input >= 0) input ^ (input >> 1)
    else throw new InputException("\"Gray encode\" " + NegativeOrZeroInput)
  }
}
