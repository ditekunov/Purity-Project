package complexOperations.ArithmeticComplex

case class Complex(real: Double = 0.0, imag: Double = 0.0) {
  def this(s: String) =
    this("[\\d.]+(?!i)".r findFirstIn s getOrElse "0" toDouble,
      "[\\d.]+(?=i)".r findFirstIn s getOrElse "0" toDouble)

  def +(firstComplex: Complex, secondComplex: Complex): Complex = Complex(firstComplex.real + secondComplex.real)
}


