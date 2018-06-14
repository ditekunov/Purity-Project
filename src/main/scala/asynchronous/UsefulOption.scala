 /**
    * Contains functions that affect Option.
    *
    * Purity project by Daniil Tekunov.
    */
object UsefulOption {

  /**
    * Contains useful functions for built-in Int type
    */
  implicit class IntOption(input: Option[Int]) {
    def getOrZero: Int = input.getOrElse(0)

    def getOrMax: Int = input.getOrElse(2147483647)
  }

  /**
    * Contains useful functions for built-in Long type
    */
  implicit class LongOption(input: Option[Long]) {
    def getOrZeroL: Long = input.getOrElse(0L)

    def getOrMaxL: Long = input.getOrElse(9223372036854775807L)
  }

  /**
    * Contains useful functions for built-in String type
    */
  implicit class StringOption(input: Option[String]) {
    def getOrEmpty: String = input.getOrElse("")
  }

  /**
    * Contains useful functions for throwable type
    */
  implicit class ThrowableOption[T](input: Option[T]) {
    def getOrThrow(ex: Throwable) = input.getOrElse(ex)
  }
}
