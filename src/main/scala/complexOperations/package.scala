package object complexOperations {
    val i: Complex = Complex(0, 1)

    implicit def fromDouble(d: Double): Complex = Complex(d)
    implicit def fromInt(i: Int): Complex = Complex(i.toDouble)
  }
