package functionalAlgorithms.encoders

import utils.InputException
import utils.ExceptionMessages.DeprecatedSymbolInput

import scala.util.{Failure, Success, Try}


/**
  * Contains realisation of Morse encoding: https://en.wikipedia.org/wiki/Morse_code
  *
  * | is a separator between letters in a word (equivalent to three units in official Morse)
  *
  * / is a separator between words in a sentence (equivalent to seven units in official Morse)
  *
  */
object MorseEncoder {
  private final val Codes: Map[Char, String] = Map(
    'a' -> ".-", 'b' -> "-...", 'c' -> "-.-.", 'd' -> "-..",
    'e' -> ".", 'f' -> "..-.", 'g' -> "--.", 'h' -> "....",
    'i' -> "..", 'j' -> ".---", 'k' -> "-.-", 'l' -> ".-..",
    'm' -> "--", 'n' -> "-.", 'o' -> "---", 'p' -> ".--.",
    'q' -> "--.-", 'r' -> ".-.", 's' -> "...", 't' -> "-",
    'u' -> "..-", 'v' -> "...-", 'w' -> ".--", 'x' -> "-..-",
    'y' -> "-.--", 'z' -> "--..", '1' -> ".----", '2' -> "..---",
    '3' -> "...--", '4' -> "....-", '5' -> ".....", '6' -> "-....",
    '7' -> "--...", '8' -> "---..", '9' -> "----.", '0' -> "-----",
    ' ' -> "/")

  def encode(input: String): String = Try(encodeLogic(input)) match {
    case Success(string) => string
    case Failure(ex) => throw new InputException(ex + DeprecatedSymbolInput)
  }

  private def encodeLogic(input: String): String = "|" + input.toLowerCase.toList.map(cur => Codes(cur) + "|").mkString


}
