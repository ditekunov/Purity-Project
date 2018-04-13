package functionalAlgorithms.decoders

import utils.InputException
import utils.ExceptionMessages.DeprecatedSymbolInput

import scala.util.{Failure, Success, Try}

/**
  * Contains realisation of Morse decoding: https://en.wikipedia.org/wiki/Morse_code
  *
  * | is a separator between letters in a word (equivalent to three units in official Morse)
  *
  * / is a separator between words in a sentence (equivalent to seven units in official Morse)
  *
  * Purity project by Daniil Tekunov.
  */
object MorseDecoder {

  private final val Codes: Map[String, Char] = Map(
    'a' -> ".-", 'b' -> "-...", 'c' -> "-.-.", 'd' -> "-..",
    'e' -> ".", 'f' -> "..-.", 'g' -> "--.", 'h' -> "....",
    'i' -> "..", 'j' -> ".---", 'k' -> "-.-", 'l' -> ".-..",
    'm' -> "--", 'n' -> "-.", 'o' -> "---", 'p' -> ".--.",
    'q' -> "--.-", 'r' -> ".-.", 's' -> "...", 't' -> "-",
    'u' -> "..-", 'v' -> "...-", 'w' -> ".--", 'x' -> "-..-",
    'y' -> "-.--", 'z' -> "--..", '1' -> ".----", '2' -> "..---",
    '3' -> "...--", '4' -> "....-", '5' -> ".....", '6' -> "-....",
    '7' -> "--...", '8' -> "---..", '9' -> "----.", '0' -> "-----",
    ' ' -> "/").map(_.swap)

  def decode(input: String): String = Try(decodeLogic(input)) match {
    case Success(string) => string
    case Failure(ex) => throw new InputException(ex + DeprecatedSymbolInput)
  }

  private def decodeLogic(input: String): String = (input.split('|') map Codes).mkString

}
