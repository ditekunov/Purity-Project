package persistentDataStructures.miscellaneous

/**
  * Basic class for handling data structures exceptions.
  */
class DataStructureException(message: String = null, cause: Exception = null) extends Exception(message, cause) {
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
