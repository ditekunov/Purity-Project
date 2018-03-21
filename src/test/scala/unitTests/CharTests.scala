package unitTests

import org.scalatest.Matchers._
import charOperations.CharProperties._
import org.scalatest.FunSuite



class CharTests extends FunSuite {

  final val Vowels: List[Char] = List(
    'a', 'e', 'i', 'o', 'u', 'y',
    'A', 'E', 'I', 'O', 'U', 'Y')

  final val Consonants: List[Char] = List(
    'b', 'c', 'd', 'f', 'g',
    'h', 'j', 'k', 'l', 'm',
    'n', 'p', 'q', 'r', 's',
    't', 'v', 'w', 'x', 'z')

  test("Testing of isVowel") {
    Vowels.foreach { cur: Char => cur.isVowel should be(true) }
    Vowels.foreach { cur: Char => cur.isConsonant should be(false) }
  }

  test("Testing of isConsonant") {
    Consonants.foreach { cur: Char => cur.isConsonant should be(true) }
    Consonants.foreach { cur: Char => cur.toUpper.isConsonant should be(true) }
    Consonants.foreach { cur: Char => cur.isVowel should be(false) }
  }
}
