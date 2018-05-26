package dataStructures

import dataStructures.miscellaneous.DataStructuresExceptionMessages.EmptyRBTreeException

/**
  * Colors of a tree
  */
abstract sealed class Color
case object Red extends Color
case object Black extends Color

abstract sealed class RedBlackTree[+Int] {

}
