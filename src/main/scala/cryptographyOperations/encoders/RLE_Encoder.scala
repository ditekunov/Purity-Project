package cryptographyOperations.encoders

import utils.InputException
import utils.ExceptionMessages.EmptyInput

/**
  * Contains realisation of RLE encoder: https://en.wikipedia.org/wiki/Run-length_encoding
  *
  * Purity project by Daniil Tekunov.
  */
object RLE_Encoder {

  /**
    * Packs repeated elements in a list of lists
    */
  private def pack[A](input: List[A]): List[List[A]] = {
    if (input.isEmpty) List(List())
    else {
      val (packed, next) = input span { _ == input.head }

      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  /**
    * Returns RLE-encoded sequence of tuples in (7, 'a) style
    */
  def encode[A](input: List[A]): List[(Int, A)] = {
    ( if (input.isEmpty) throw new InputException("\"RLE encoding\" " + EmptyInput)
    else {
      val (packed, next) = input span { _ == input.head }

      if (next == Nil) List(packed)
      else packed :: pack(next)

    }) map { element => (element.length, element.head) }
  }
}
