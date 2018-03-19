package functionalAlgorithms.decoders

import utils.ExceptionMessages.emptyInput
import utils.InputException

object RLE {
  /**
    * Decoder itself, returns outcome List.
    */
  private def makeList[A](countOfElements: Int, element: A, customList: List[A] = List()): List[A] =
    countOfElements match {
      case 0 => customList
      case _ => makeList(countOfElements - 1, element, customList :+ element)
  }

  /**
    * Sub-function for decoder, that checks input and flatmaps the List.
    */
  def RLEdecoder[A](input: List[(Int, A)]): List[A] = {
    if (input.isEmpty) throw new InputException("\"getElement\" " + emptyInput)
    else input flatMap { element => makeList(element._1, element._2) }
  }


}
