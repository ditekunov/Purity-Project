import scala.math.{abs, sqrt}

/**
  * Purity project by Daniil Tekunov.
  */
object KolmogorovSmirnovTest {

  /**
    * Returns, whether the distribution of the value increased or not, using Kolmogorov-Smirnov test.
    */
  def ColmogorovSmirnov(n: List[Int], m: List[Int]): Boolean = {

    val nLen = n.length

    val mLen = m.length

    val tRange = n ++ m

    val t = tRange.min until tRange.max

    (for (i <- t) yield {
      val localN = n.count { x => x <= i } / nLen

      val localM = m.count { x => x <= i } / mLen

      (localN - localM).abs

    }).max > 1.36 * sqrt((nLen + mLen) / (nLen * mLen))
  }
}
