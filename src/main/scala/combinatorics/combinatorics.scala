package object combinatorics {

import integerOperations.IntegerProperties._
  
  /**
    * Contains basic combinatorics formulas.
    *
    * Purity project by Daniil Tekunov.
    */
  def permutationsCount(n: Int): Int = n!

  def accomodations(m: Int, n: Int) = (n!) / ((n - m)!)

  def combinations(m : Int, n: Int) = (n!) / ( ((n - m)!) * (m!) )

  

}
