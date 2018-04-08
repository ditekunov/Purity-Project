package persistentDataStructures
import miscellaneous.DataStructureException
import miscellaneous.DataStructuresExceptionMessages.EmptyQueueException


class Queue[+A](in: List[A] = Nil, out: List[A] = Nil) {

  def isEmpty: Boolean = (in, out) match {
    case (Nil, Nil) => true
    case (_, _) => false
  }

  def enqueue[B >: A](element: B): Queue[B] = new Queue(element :: in, out)

  def dequeue: (A, Queue[A]) = out match {
    case last :: previous => (last, new Queue(in, previous))
    case Nil => in.reverse match {
      case last :: previous => (last, new Queue(in, previous))
      case Nil => throw new DataStructureException(EmptyQueueException)
    }
  }

  def first: A = dequeue match {case (element, _) => element}

  def init: Queue[A] = dequeue match {case (_, element) => element }

}


  object Queue { def createEmptyQueue[A]: Queue[A] = new Queue() }


