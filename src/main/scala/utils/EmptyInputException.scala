package utils


/**
  * Default class for handling emptyInput exceptions
  */
class EmptyInputException(message: String = null, cause: Exception = null) extends Exception(message, cause) {
  def this() {
    this(null, null)
  }

  def this(message: String) {
    this(message, null)
  }

  def this(cause: Exception) {
    this(null, cause)
  }
}

object EmptyInputException {
  def apply(message: String) = new EmptyInputException(message, null)
  def apply(cause: Exception) = new EmptyInputException(null, cause)



}
