package complexOperations

case class Complex(realPart: Double = 0.0, imagPart: Double = 0.0) {

  def this(s: String) =
    this("[\\d.]+(?!i)".r findFirstIn s getOrElse "0" toDouble,
      "[\\d.]+(?=i)".r findFirstIn s getOrElse "0" toDouble)

  private val real = realPart

  private val imaginary = imagPart

  override def toString = real + " + " + imaginary + "i"

  def +(secondsComplex: Complex): Complex = new Complex(real + secondsComplex.real, imaginary + secondsComplex.imaginary)

  def -(secondComplex: Complex): Complex = new Complex(real - secondComplex.real, imaginary - secondComplex.imaginary)

  def *(secondComplex: Complex): Complex = new Complex(
    real * secondComplex.real - imaginary * secondComplex.imaginary,
    real * secondComplex.imaginary + imaginary * secondComplex.real)

  def inverse: Complex = {
    val denominator = real * real + imaginary * imaginary
    new Complex(real / denominator, -imaginary / denominator)
  }

  def /(secondComplex: Complex): Complex = this * secondComplex.inverse
}

object Complex {
  def apply(s: String) = new Complex(s)
}
