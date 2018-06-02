package rationalOperations

import integerOperations.IntegerProperties._


/**
  * Contains operations in a field of rational numbers.
  *
  * Purity project by Daniil Tekunov.
  */
class Rational(numerator: Int, denominator: Int) {
  require(denominator != 0)

  private val gcd = numerator.abs gcdWith denominator.abs

  private val num: Int = numerator / gcd

  private val denom: Int = denominator / gcd

  override def toString: String = num + "/" + denom

  def this(firstInt: Int) = this(firstInt, 1)

  def +(secondRational: Rational) = new Rational(
    num * secondRational.denom + secondRational.num * denom,
    denom * secondRational.denom)

  def *(secondRational: Rational) = new Rational(
    num * secondRational.num,
    denom * secondRational.denom)

  def /(secondRational: Rational) = new Rational(
    num * secondRational.denom,
    denom * secondRational.num)

  def -(secondRational: Rational) = new Rational(
    num * secondRational.denom - secondRational.num * denom,
    denom * secondRational.denom)

  def >(secondRational: Rational): Boolean =
    this.num * secondRational.denom > this.denom * secondRational.num

  def <(secondRational: Rational): Boolean =
    this.num * secondRational.denom < this.denom * secondRational.num
}
