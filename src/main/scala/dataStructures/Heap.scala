package dataStructures

import integerOperations.IntegerProperties._
import dataStructures.miscellaneous.DataStructureException
import dataStructures.miscellaneous.DataStructuresExceptionMessages.EmptyHeapException

case class HeapBranch(min: Int, left: Heap[Int], right: Heap[Int], size: Int, height: Int) extends Heap {
  def isEmpty: Boolean = false
}

case object Leaf extends Heap {
  def min: Nothing = throw new DataStructureException(EmptyHeapException)
  def left: Heap[Nothing] = throw new DataStructureException(EmptyHeapException)
  def right: Heap[Nothing] = throw new DataStructureException(EmptyHeapException)
  def size: Int = 0
  def height: Int = 0
  def isEmpty: Boolean = true
}

abstract sealed class Heap[+Int] {

  def min: Int
  def left: Int
  def right: Int
  def size: Int
  def height: Int
  def isEmpty: Boolean

  def insert(x: Int): Heap[Int] =
    if (isEmpty) Heap.make(x)
    else if (left.size < math.pow(2, left.height) - 1)
      Heap.bubbleUp(min, left.insert(x), right)
    else if (right.size < math.pow(2, right.height) - 1)
      Heap.bubbleUp(min, left, right.insert(x))
    else if (right.height < left.height)
      Heap.bubbleUp(min, left, right.insert(x))
    else Heap.bubbleUp(min, left.insert(x), right)
}

case object Leaf extends Heap[Nothing] {
  def min: Nothing = throw new DataStructureException(EmptyHeapException)
  def left: Heap[Nothing] = throw new DataStructureException(EmptyHeapException)
  def right: Heap[Nothing] = throw new DataStructureException(EmptyHeapException)
  def size: Int = 0
  def height: Int = 0
  def isEmpty: Boolean = true
}

object Heap {

  def empty: Heap[Int] = Leaf

  def make(x: Int, l: Heap[Int] = Leaf, r: Heap[Int] = Leaf): Heap[Int] =
    HeapBranch(x, l, r, l.size + r.size + 1, math.max(l.height, r.height) + 1)

  private[Heap] def bubbleUp(x: Int, l: Heap[Int], r: Heap[Int]): Heap[Int] = (l, r) match {
    case (HeapBranch(y, lt, rt, _, _), _) if x > y =>
      Heap.make(y, Heap.make(x, lt, rt), r)
    case (_, HeapBranch(z, lt, rt, _, _)) if x > z =>
      Heap.make(z, l, Heap.make(x, lt, rt))
    case (_, _) => Heap.make(x, l, r)
  }

  private[Heap] def bubbleDown(x: Int, l: Heap[Int], r: Heap[Int]): Heap[Int] = (l, r) match {
    case (HeapBranch(y, _, _, _, _), HeapBranch(z, lt, rt, _, _)) if z < y && x > z =>
      Heap.make(z, l, Heap.bubbleDown(x, lt, rt))
    case (HeapBranch(y, lt, rt, _, _), _) if x > y =>
      Heap.make(y, Heap.bubbleDown(x, lt, rt), r)
    case (_, _) => Heap.make(x, l, r)
  }
}
