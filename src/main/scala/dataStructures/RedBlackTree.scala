package dataStructures

import dataStructures.miscellaneous.DataStructuresExceptionMessages.EmptyRBTreeException

/**
  * Colors of a tree
  */
abstract sealed class Color
case object Red extends Color
case object Black extends Color

abstract sealed class RedBlackTree[+A] {

  /**
    * Color of a tree
    */
  def color: Color

  /**
    * Current value
    */
  def value: Int

  /**
    * The left branch of a tree
    */
  def left: RedBlackTree[Int]

  /**
    * The right branch of a tree
    */
  def right: RedBlackTree[Int]

  /**
    * Checks whether this tree is empty or not
    */
  def isEmpty: Boolean

  /**
    * Adds an element into a tree
    */
  def add(x: Int): RedBlackTree[Int] = {
    def balancedAdd(t: RedBlackTree[Int]): RedBlackTree[Int] =
      if (t.isEmpty) RedBlackTree.make(Red, x)
      else if (x < t.value) balanceLeft(t.color, t.value, balancedAdd(t.left), t.right)
      else if (x > t.value) balanceRight(t.color, t.value, t.left, balancedAdd(t.right))
      else t

    def balanceLeft(c: Color, x: Int, l: RedBlackTree[Int], r: RedBlackTree[Int]) = (c, l, r) match {
      case (Black, RBBranch(Red, y, RBBranch(Red, z, a, b), c), d) =>
        RedBlackTree.make(Red, y, RedBlackTree.make(Black, z, a, b), RedBlackTree.make(Black, x, c, d))
      case (Black, RBBranch(Red, z, a, RBBranch(Red, y, b, c)), d) =>
        RedBlackTree.make(Red, y, RedBlackTree.make(Black, z, a, b), RedBlackTree.make(Black, x, c, d))
      case _ => RedBlackTree.make(c, x, l, r)
    }

    def balanceRight(c: Color, x: Int, l: RedBlackTree[Int], r: RedBlackTree[Int]) = (c, l, r) match {
      case (Black, a, RBBranch(Red, y, b, RBBranch(Red, z, c, d))) =>
        RedBlackTree.make(Red, y, RedBlackTree.make(Black, x, a, b), RedBlackTree.make(Black, z, c, d))
      case (Black, a, RBBranch(Red, z, RBBranch(Red, y, b, c), d)) =>
        RedBlackTree.make(Red, y, RedBlackTree.make(Black, x, a, b), RedBlackTree.make(Black, z, c, d))
      case _ => RedBlackTree.make(c, x, l, r)
    }

    def blacken(t: RedBlackTree[Int]) = RedBlackTree.make(Black, t.value, t.left, t.right)

    blacken(balancedAdd(this))
  }

  def height: Int =
    if (isEmpty) 0
    else math.max(left.height, right.height) + 1
}

case class RBBranch[Int](color: Color,
                         value: Int,
                         left: RedBlackTree[Int],
                         right: RedBlackTree[Int]) extends RedBlackTree[Int] {
  def isEmpty = false
}

case object Leaf extends RedBlackTree[Nothing] {
  def color: Color = Black
  def value: Nothing = EmptyRBTreeException()
  def left: RedBlackTree[Nothing] = EmptyRBTreeException()
  def right: RedBlackTree[Nothing] = EmptyRBTreeException()
  def isEmpty = true
}

object RedBlackTree {

  /**
    * Returns an empty red-black tree
    */
  def empty[Int]: RedBlackTree[Int] = Leaf

  /**
    * Creates a branch
    */
  def make(c: Color, x: Int, l: RedBlackTree[Int] = Leaf, r: RedBlackTree[Int] = Leaf): RedBlackTree[Int] =
    RBBranch(c, x, l, r)

}
