package functionalAlgorithms.decoders

import utils.ExceptionMessages.EmptyInput
import utils.InputException

import scala.annotation.tailrec

object RLE_Decoder {

  /**
    * Decoder itself, returns outcome List.
    */
  @tailrec
  private def makeList[A](countOfElements: Int, element: A, customList: List[A] = List()): List[A] =
    countOfElements match {
      case 0 => customList
      case _ => makeList(countOfElements - 1, element, customList :+ element)
  }

  /**
    * Sub-function for decoder, that checks input and flatmaps the List.
    */
  def decode[A](input: List[(Int, A)]): List[A] = {
    if (input.isEmpty) throw new InputException("\"getElement\" " + EmptyInput)
    else input flatMap { element => makeList(element._1, element._2) }
  }


}
