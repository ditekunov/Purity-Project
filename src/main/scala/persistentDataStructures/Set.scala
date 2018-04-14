package persistentDataStructures

import scala.annotation.tailrec

/**
  * Contains functional realisation of a mathematical meaning of a set.
  *
  * https://en.wikipedia.org/wiki/Set_(mathematics)
  *
  * Purity project by Daniil Tekunov.
  */
object Set {

  type Set[A] = A => Boolean

  /**
    * Fundamental operation for a mathematical set, realised via apply operation.
    */
  def contains[A](set: Set[A], element: A): Boolean = set(element)

  /**
    * Creation of a basic set, that contains a single element.
    */
  def basicSet[A](element: A): Set[A] = (param: A) => param == element

  /**
    * Realisation of <Union> operation.
    *
    * An element should be either in a first Set, or in the second Set
    */
  def union[A](firstSet: Set[A], secondSet: Set[A]): Set[A] = (param: A) => firstSet(param) || secondSet(param)

  /**
    * Realisation of <Intersect> operation.
    *
    * An element should be either in both sets.
    */
  def intersect[A](firstSet: Set[A], secondSet: Set[A]): Set[A] = (param: A) => firstSet(param) && secondSet(param)

  /**
    * Realisation of <Difference> operation.
    *
    * An element should be in a first set, but should not be in a second.
    */
  def difference[A](firstSet: Set[A], secondSet: Set[A]): Set[A] = (param: A) => firstSet(param) && !secondSet(param)

  /**
    * Realisation of a filter using given function.
    *
    * Returns elements in a given set, that exist in a given function.
    */
  def filter[A](firstSet: Set[A], f: A => Boolean): Set[A] = (param: A) => firstSet(param) && f(param)

  /**
    * Realisation of a forall using given function.
    *
    * Returns whether elements refer to a given function in a given range.
    */
  def forall(firstSet: Set[Int], f: Int => Boolean, rangeWithinZero: Int): Boolean = {

    @tailrec
    def check(cur: Int = -rangeWithinZero): Boolean = {
      if (cur > rangeWithinZero) true
      else if (firstSet(cur) && !f(cur)) false
      else check(cur + 1)
    }

    check()
  }

  /**
    * Realisation of exists using given function.
    *
    * Returns whether there exists a bounded element, that satisfies a given function.
    */
  def exists(firstSet: Set[Int], f: Int => Boolean, rangeWithinZero: Int): Boolean =
    !forall(firstSet, param => !f(param), rangeWithinZero)

  /**
    * Converts a set to a string.
    */
  def convertToString(s: Set[Int], rangeWithinZero: Int): String = {
    val xs = for (i <- -rangeWithinZero to rangeWithinZero if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }
}



