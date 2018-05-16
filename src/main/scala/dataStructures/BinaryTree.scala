package dataStructures

import dataStructures.miscellaneous.DataStructureException
import dataStructures.miscellaneous.DataStructuresExceptionMessages.EmptyLeafException
import dataStructures.miscellaneous.DataStructuresExceptionMessages.EmptyTreeException
import utils.InputException

import scala.annotation.tailrec

/**
  * Contains functional realisation of a standard binary tree.
  *
  * https://en.wikipedia.org/wiki/Linked_list
  *
  * Purity project by Daniil Tekunov.
  */
abstract sealed class BinaryTree[+A] {

  /**
    * Value of a node
    */
  def value: Int

  /**
    * Left branch 
    */
  def left: BinaryTree[A]

  /**
    * Right branch 
    */
  def right: BinaryTree[A]

  /**
    * Size of a tree
    */
  def size: Int

  /**
    * Whether the tree is empty
    */
  def isEmpty: Boolean

  /**
    * Checks, whether the tree is a valid binary tree
    */
  def isValid: Boolean = {
    if (isEmpty) true
    else if (left.isEmpty && right.isEmpty) true
    else if (left.isEmpty) right.value >= value && right.isValid
    else if (right.isEmpty) left.value <= value && left.isValid
    else (left.value <= value && left.isValid) && right.value >= value && right.isValid
  }
  /**
    * Adds an element to a tree
    */
  def addElement(element: Int): BinaryTree[A] = {
    if (isEmpty) BinaryTree.make(element)
    else if (element < value) BinaryTree.make(value, left.addElement(element), right)
    else if (element > value) BinaryTree.make(value, left, right.addElement(element))
    else this
  }

  /**
    * Removes an element from a tree
    */
  def removeElement(element: Int): BinaryTree[A] = {
    if (isEmpty) throw new InputException(EmptyTreeException)
    else if (element < value) BinaryTree.make(value, left.removeElement(element), right)
    else if (element > value) BinaryTree.make(value, left, right.removeElement(element))
    else {
      if (left.isEmpty && right.isEmpty) BinaryTree.empty
      else if (left.isEmpty) right
      else if (right.isEmpty) left
      else {
        val found = right.min
        BinaryTree.make(found, left, right.removeElement(found))
      }
    }
  }

  /**
    * Finds a minimum value in a tree
    */
  def min: Int = {
    @tailrec
    def find(tree: BinaryTree[A], cur: Int): Int =
      if (tree.isEmpty) cur
      else find(tree.left, tree.value)

    if (isEmpty) throw new InputException(EmptyTreeException)
    else find(left, value)
  }


}

/**
  * Basic object to describe a leaf
  */
case object Leaf extends BinaryTree[Nothing] {
  def value = throw new DataStructureException(EmptyLeafException)
  def left = throw new DataStructureException(EmptyLeafException)
  def right = throw new DataStructureException(EmptyLeafException)
  def size = 0
  def isEmpty = true
}

/**
  * Basic case class, to describe a branch
  */
case class Branch[A](value: Int,
                  left: BinaryTree[A],
                  right: BinaryTree[A],
                  size: Int) extends BinaryTree[A] {
  def isEmpty: Boolean = false
}

object BinaryTree {

  def empty[A]: BinaryTree[A] = Leaf

  def make[A](element: Int, left: BinaryTree[A] = Leaf, right: BinaryTree[A] = Leaf): BinaryTree[A] =
    Branch(element, left, right, left.size + right.size + 1)
}
