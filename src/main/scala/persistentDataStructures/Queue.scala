package persistentDataStructures

class Queue[+A](in: List[A] = Nil, out: List[A] = Nil) {

  def isEmpty: Boolean = (in, out) match {
    case (Nil, Nil) => true
    case (_, _) => false
  }



}
