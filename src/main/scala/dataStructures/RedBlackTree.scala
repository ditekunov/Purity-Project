package dataStructures

import dataStructures.miscellaneous.DataStructuresExceptionMessages.EmptyRBTreeException

/**
  * Colors of a tree
  */
abstract sealed class Color
case object Red extends Color
case object Black extends Color

abstract sealed class RedBlackTree[+Int] {
 
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

}
