package charOperations

import charOperations.miscellaneous.ImportantConstants._
import utils.InputException
import utils.ExceptionMessages.DeprecatedSymbolInput


/**
  * Contains functions, affecting char properties.
  *
  * Purity project by Daniil Tekunov.
  */
class CharProperties(val firstChar: Char) {
  import CharProperties._

  /**
    * Checks, whether the char is vowel
    */
  def isVowel: Boolean = {
    if (Vowels.contains(firstChar.toLower)) true
    else if (Consonants.contains(firstChar.toLower) || firstChar == '\0') false
    else throw new InputException("\"isVowel\" " + DeprecatedSymbolInput)
  }

  /**
    * Checks, whether the char is consonant
    */
  def isConsonant: Boolean = {
    if (Consonants.contains(firstChar.toLower)) true
    else if (Vowels.contains(firstChar.toLower) || firstChar == '\0') false
    else throw new InputException("\"isConsonant\" " + DeprecatedSymbolInput)
  }

}

object CharProperties {
  implicit def charToImplicitProps(a: Char): CharProperties = new CharProperties(a)
}
