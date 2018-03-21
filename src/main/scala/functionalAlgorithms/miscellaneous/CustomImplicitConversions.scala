package functionalAlgorithms.miscellaneous

object CustomImplicitConversions {

  /**
    * Applies Tuple3[Int, Int] to a case class implicitly.
    */
  implicit def tuple3ToCurrentToCounters(a: (Int, Int, Int)): CurrentAndPositiveNegativeCounters = {
    CurrentAndPositiveNegativeCounters.apply(
      current = a._1,
      counterOfPositiveToNegative = a._2,
      counterOfNegativeToPositive = a._3)
  }

}


