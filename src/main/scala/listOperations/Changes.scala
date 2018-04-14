package listOperations

import charOperations.CharProperties._
import listOperations.miscellaneous.CustomImplicitConversions._
import listOperations.miscellaneous.{CurrentAndPositiveNegativeCounters, CurrentAndVowelConsonantCounters}
import utils.ExceptionMessages.EmptyInput
import utils.InputException

/**
  * Purity project by Daniil Tekunov.
  */
object Changes {

  /**
    * Checks if element's sign changed from positive to negative
    */
  private def isPositiveToNegative(a: Int, b: Int): Boolean =  a > 0 && b < 0

  /**
    * Checks if element changed from vowel to consonant
    */
  private def isVowelToConsonant(a: Char, b: Char): Boolean = a.isVowel &&  b.isConsonant

  /**
    * Counts, whether there were changes from positive integer to negative integer in a list
    */
  def countSignChanges(input: List[Int]): List[Int] = input match {
    case List() =>
      throw new InputException("\"Sign changes counter\" " + EmptyInput)
    case _ =>
      val outcomeTuple = input.foldLeft(CurrentAndPositiveNegativeCounters()) (
        (fin: CurrentAndPositiveNegativeCounters, cur: Int) =>
          (cur,
            if (isPositiveToNegative(fin.current, cur)) fin.counterOfPositiveToNegative + 1
            else fin.counterOfPositiveToNegative,

            if (isPositiveToNegative(cur, fin.current)) fin.counterOfNegativeToPositive + 1
            else fin.counterOfNegativeToPositive)
    )

    List(outcomeTuple.counterOfPositiveToNegative, outcomeTuple.counterOfNegativeToPositive)
  }

  /**
    * Counts, whether there were changes from vowel to consonant letter in a list
    */
  def countLetterChanges(input: List[Char]): List[Int] = input match {
    case List() =>
      throw new InputException("\"Letter changes counter\" " + EmptyInput)
    case _ =>
      val outcomeTuple = input.foldLeft(CurrentAndVowelConsonantCounters()) (
        (fin: CurrentAndVowelConsonantCounters, cur: Char) =>
          (cur,
            if (isVowelToConsonant(fin.current, cur)) fin.counterOfVowelToConsonant + 1
            else fin.counterOfVowelToConsonant,

            if (isVowelToConsonant(cur, fin.current)) fin.counterOfConsonantToVowel + 1
            else fin.counterOfConsonantToVowel)
      )

      List(outcomeTuple.counterOfVowelToConsonant, outcomeTuple.counterOfConsonantToVowel)
  }



}
