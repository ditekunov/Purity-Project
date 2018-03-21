package charOperations

import charOperations.miscellaneous.ImportantConstants._

class CharProperties(val firstChar: Char) {
  import CharProperties._

  /**
    * Checks, whether the char is vowel
    */
  def isVowel: Boolean = Vowels.contains(firstChar.toLower)

  /**
    * Checks, whether the char is consonant
    */
  def isConsonant: Boolean = Consonants.contains(firstChar.toLower)

}

object CharProperties {
  implicit def charToCharProperties(a: Char) = new CharProperties(a)
}
