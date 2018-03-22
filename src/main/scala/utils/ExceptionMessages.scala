package utils

object ExceptionMessages {
  lazy val EmptyInput: String = "function got empty input"
  lazy val NoneInput: String = "function got None instead of Some()"
  lazy val NegativeInput: String = "function got negative input, expected n >= 0"
  lazy val PositiveInput: String = "function got positive input, expected n < 0"
  lazy val StackOverflowInput: String = "function's recursion in too deep, expected smaller input"
}
