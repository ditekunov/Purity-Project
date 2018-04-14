package dataStructures
import miscellaneous.DataStructureException
import miscellaneous.DataStructuresExceptionMessages.EmptyQueueException

/**
  * Contains functional realisation of a standard queue.
  *
  * https://en.wikipedia.org/wiki/Queue_(abstract_data_type)
  *
  * Purity project by Daniil Tekunov.
  */
class Queue[+A](in: List[A] = Nil, out: List[A] = Nil) {

  /**
    * Checks, whether the queue is empty.
    */
  def isEmpty: Boolean = (in, out) match {
    case (Nil, Nil) => true
    case (_, _) => false
  }

  /**
    * Adds an element to a queue.
    */
  def enqueue[B >: A](element: B): Queue[B] = new Queue(element :: in, out)

  /**
    * Removes an element from a queue.
    */
  def dequeue: (A, Queue[A]) = out match {
    case last :: previous => (last, new Queue(in, previous))
    case Nil => in.reverse match {
      case last :: previous => (last, new Queue(in, previous))
      case Nil => throw new DataStructureException(EmptyQueueException)
    }
  }

  /**
    * Takes the first element from a queue.
    */
  def first: A = dequeue match {case (element, _) => element}

  /**
    * Takes the whole queue, except the last element.
    */
  def init: Queue[A] = dequeue match {case (_, element) => element }

}

object Queue { def createEmptyQueue[A]: Queue[A] = new Queue() }


