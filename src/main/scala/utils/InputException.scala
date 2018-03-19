package utils


/**
  * Default class+object for handling Input exceptions
  */
class InputException(message: String = null, cause: Exception = null) extends Exception(message, cause) {
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
  def apply(message: String) = new InputException(message, null)
  def apply(cause: Exception) = new InputException(null, cause)
}

