package persistentDataStructures

import utils.ExceptionMessages.NegativeInput
import persistentDataStructures.miscellaneous.DataStructuresExceptionMessages.{EmptyHeadException, EmptyListException, EmptyTailException}
import persistentDataStructures.miscellaneous.DataStructureException

/**
  * Contains functional realisation of a standard linked list.
  *
  * https://en.wikipedia.org/wiki/Linked_list
  *
  * Purity project by Daniil Tekunov.
  */
abstract sealed class LinkedList[+A] {

  /**
    * First element of a list
    */
  def head: A

  /**
    * Tail of the list
    */
  def tail: LinkedList[A]

  /**
    * Basic function to check whether the list is empty
    */
  def isEmpty: Boolean

  /**
    * Appends an element to a list
    */
  def join[B >: A](element: B): LinkedList[B] =
    if (isEmpty) LinkedList.create(element)
    else LinkedList.create(head, tail.join(element))

  /**
    * Adds an element to a list
    */
  def add[B >: A](element: B): LinkedList[B] = LinkedList.create(element, this)

  /**
    * Concatenates two lists
    */
  def concatenate[B >: A](addingPart: LinkedList[B]): LinkedList[B] =
    if (isEmpty) addingPart
    else tail.concatenate(addingPart).add(head)

  /**
    * Removes an element from a list
    */
  def remove[B >: A](element: B): LinkedList[B] =
    if (isEmpty) throw new DataStructureException(EmptyListException)
    else if (element == head) tail
    else LinkedList.create(head, tail.remove(element))

  /**
    * Finds an element in a list by index
    */
  def apply(element: Int): A =
    if (isEmpty) throw new DataStructureException(EmptyListException)
    else if (element < 0) throw new DataStructureException(NegativeInput)
    else if (element == 0) head
    else tail(element - 1)

  /**
    * Checks, whether the list contains an element
    */
  def contains[B >: A](element: B): Boolean =
    if (isEmpty) false
    else if (element != head) tail.contains(element)
    else true
}

case object NilType extends LinkedList[Nothing] {
  def head: Nothing = throw new DataStructureException(EmptyHeadException)
  def tail: LinkedList[Nothing] = throw new DataStructureException(EmptyTailException)
  def isEmpty: Boolean = true
}

case class ListStructure[A](head: A, tail: LinkedList[A]) extends LinkedList[A] {
  def isEmpty: Boolean = false
}

object LinkedList {

  def empty[A]: LinkedList[A] = NilType

  /**
    * Basic creation of a list
    */
  def create[A](element: A, tail: LinkedList[A] = NilType): LinkedList[A] = ListStructure(element, tail)

}