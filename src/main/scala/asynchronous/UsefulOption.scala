object UsefulOption {

  implicit class IntOption(input: Option[Int]) {
    def getOrZero: Int = input.getOrElse(0)

    def getOrMax: Int = input.getOrElse(2147483647)
  }

  implicit class LongOption(input: Option[Long]) {
    def getOrZeroL: Long = input.getOrElse(0L)

    def getOrMaxL: Long = input.getOrElse(9223372036854775807L)
  }

  implicit class StringOption(input: Option[String]) {
    def getOrEmpty: String = input.getOrElse("")
  }

  implicit class ThrowableOption[T](input: Option[T]) {
    def getOrThrow(ex: Throwable) = input.getOrElse(ex)
  }
}
