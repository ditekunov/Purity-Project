package dataStructures

import integerOperations.IntegerProperties._

//case class Branch(min: Int, left: Heap, right: Heap, size: Int, height: Int) extends Heap {
//  def isEmpty: Boolean = false
//}
//
//case object Leaf extends Heap {
//  def min: Nothing = throw new NoSuchElementException("Heap is empty")
//  def left: Heap = throw new NoSuchElementException("Heap is empty")
//  def right: Heap = throw new NoSuchElementException("Heap is empty")
//  def size: Int = 0
//  def height: Int = 0
//  def isEmpty: Boolean = true
//}
//
//abstract sealed class Heap {
//
//  def min: Int
//  def left: Int
//  def right: Int
//  def size: Int
//  def height: Int
//  def isEmpty: Boolean
//
//  def insert(element: Int): Heap = {
//    if (isEmpty) Heap.make(x)
//    else if (left.size < left.height.sqr - 1)
//  }
//}
//
//object Heap {
//
//  def empty: Heap = Leaf
//
//  def create(minElement: Int, leftBranch: Heap = Leaf, rightBranch: Heap = Leaf) = {
//    Branch(
//      minElement,
//      leftBranch,
//      rightBranch,
//      leftBranch.size + rightBranch.size + 1,
//      math.max(leftBranch.height, rightBranch.height) + 1)
//  }
//}


