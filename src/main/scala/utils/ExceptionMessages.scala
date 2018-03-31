package utils

/**
  * Utility messages to handle exceptions
  */
object ExceptionMessages {
  lazy val EmptyInput: String = "function got empty input"
  lazy val NoneInput: String = "function got None instead of Some()"
  lazy val NegativeOrZeroInput: String = "function got negative input, expected n >= 0"
  lazy val ZeroInput: String = "function got 0, expected n != 0"
  lazy val NegativeInput: String = "function got negative input, expected n > 0"
  lazy val PositiveInput: String = "function got positive input, expected n < 0"
  lazy val BorderInput: String = "function got border input, expected valid n"
  lazy val StackOverflowInput: String = "function's recursion in too deep, expected smaller input"
  lazy val DeprecatedSymbolInput: String = "function got deprecated symbol"
}
