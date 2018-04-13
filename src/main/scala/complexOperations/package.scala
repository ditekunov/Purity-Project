import complexOperations.ArithmeticComplex.Complex

package object complexOperations {
  val i: Complex = Complex(0.0, 1.0)

  implicit def intToComplex(input: Int): Complex = Complex(input.toDouble)
  implicit def doubleToComplex(input: Int): Complex = Complex(input)

}
