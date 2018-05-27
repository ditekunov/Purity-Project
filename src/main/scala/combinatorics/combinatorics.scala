 
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
  def accomodations(m: Int, n: Int) = (n!) / ((n - m)!)

  /**
    * Returns number of combinations of n objects at m places.
    */
  def combinations(m : Int, n: Int) = (n!) / ( ((n - m)!) * (m!) )
}
