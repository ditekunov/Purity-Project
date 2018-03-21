package functionalAlgorithms.miscellaneous

object CustomImplicitConversions {

  /**
    * Applies Tuple3[Int, Int, Int] to a case class implicitly.
    */
  implicit def tuple3ToSignCounters(a: (Int, Int, Int)): CurrentAndPositiveNegativeCounters = {
    CurrentAndPositiveNegativeCounters.apply(
      current = a._1,
      counterOfPositiveToNegative = a._2,
      counterOfNegativeToPositive = a._3)
  }

  /**
    * Applies Tuple3[Char, Int, Int] to a case class implicitly.
    */
  implicit def tuple3ToLetterCounters(a: (Char, Int, Int)): CurrentAndVowelConsonantCounters = {
    CurrentAndVowelConsonantCounters.apply(
      current = a._1,
      counterOfVowelToConsonant = a._2,
      counterOfConsonantToVowel = a._3)
  }

}


