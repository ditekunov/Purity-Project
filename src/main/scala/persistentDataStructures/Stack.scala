package persistentDataStructures

import persistentDataStructures.miscellaneous.DataStructuresExceptionMessages.EmptyStackException
import persistentDataStructures.miscellaneous.DataStructureException


/**
  * Contains functional realisation of a standard stack.
  *
  * https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
  *
  * Purity project by Daniil Tekunov.
  */
class Stack[+A](inPart: List[A] = Nil) {

  /**
    * Checks, whether the stack is empty.
    */
  def isEmpty: Boolean = inPart match {
    case Nil => true
    case _ => false
  }

  /**
    * Adds an element to a stack.
    */
  def add[B >: A](element: B): Stack[B] = new Stack(element :: inPart)

  /**
    * Removes an element from a queue.
    */
  def remove: (A, Stack[A]) = inPart match {
    case outcomeElement :: tail => (outcomeElement, new Stack(tail))
    case Nil => throw new DataStructureException(EmptyStackException)
  }

  /**
    * Takes the first element from a queue.
    */
  def first: A = inPart match {
    case element :: tail => element
    case Nil => throw new DataStructureException(EmptyStackException)
  }

  /**
    * Returns the tail of a stack.
    */
  def init: Stack[A] = new Stack(inPart.tail)
}


object Stack { def createEmptyStack[A]: Stack[A] = new Stack() }