package sortingAlgorithms.unseriousAlgorithms

/**
  * This object contains function, that realises sleep sort algorithm.
  *
  * https://rosettacode.org/wiki/Sorting_algorithms/Sleep_sort
  *
  * Worst speed: O(max(input) + n)
  *
  * Average speed: O(max(input) + n)
  *
  * Best speed: O(max(input) + n)
  *
  */
object SleepSort {

  def sleepSort(input: List[Int]): Unit =
    input.foreach(i => new Thread {
      override def run() {
        Thread.sleep(i * 10)
        print(i)
      }
    }.start())


}
