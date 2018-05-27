package object combinatorics {

  /**
    * Contains basic combinatorics formulas.
    *
    * Purity project by Daniil Tekunov.
    */
  import integerOperations.IntegerProperties._

  /**
    * Returns number of permutations of n objects.
    */
  def permutationsCount(n: Int): Int = n!

  /**
    * Returns number of accomodations of n objects at m places.
    */
  def accomodations(m: Int, n: Int): Int = (n!) / ((n - m)!)

  /**
    * Returns number of combinations of n objects at m places.
    */
  def combinations(m : Int, n: Int) = (n!) / ( ((n - m)!) * (m!) )

  /**
    * Returns number of combinations with repeats of n objects at m places.
    */
  def combinationsWithRepeats(m : Int, n: Int): Int = ((n + m - 1)!) / ((m!) * (n - 1)!)

  /**
    * Returns number of accomodations with repeats of n objects at m places.
    */
  def accomodationsWithRepeats(m : Int, n: Int): Int = n.powN(m)
}

