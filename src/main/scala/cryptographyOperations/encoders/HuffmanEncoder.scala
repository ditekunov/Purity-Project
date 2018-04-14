package cryptographyOperations.encoders

import collection.immutable.Queue
import scala.annotation.tailrec

/**
  * Contains functional realisation of a Huffman encoding algorithm.
  *
  * Usage:
  *
  * HuffmanEncoder.encode() - to encode a string
  *
  * HuffmanEncoder.createCodeTree - to create a tree for decoder
  *
  * Purity project by Daniil Tekunov.
  */
object HuffmanEncoder {

  //TODO: Finalize the doc
  /**
    * Basic object, that contains:
    *
    * weight - function, that checks, whether the Node is a list and returns weight
    *
    * chars - Puts a weight to a List
    *
    * makeCodeTree - Forks a tree to a binary tree
    *
    * times - returns the frequencies of a symbol
    *
    */
  abstract class CodeTree

  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree

  case class Leaf(char: Char, weight: Int) extends CodeTree

  private def weight(tree: CodeTree): Int = tree match {
    case Fork(_, _, _, w) => w
    case Leaf(_, w) => w
  }

  private def chars(tree: CodeTree): List[Char] = tree match {
    case Fork(_, _, cs, _) => cs
    case Leaf(c, _) => List(c)
  }

  private def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))

  private def times(chars: List[Char]): List[(Char, Int)] = {
    def incr(acc: Map[Char, Int], c: Char) = {
      val count = (acc get c).getOrElse(0) + 1
      acc + ((c, count))
    }

    (Map[Char, Int]() /: chars) (incr).iterator.toList
  }

  private def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    freqs.sortWith((f1, f2) => f1._2 < f2._2).map((f) => Leaf(f._1, f._2))
  }

  private def singleton(trees: List[CodeTree]): Boolean = trees.size == 1

  private def combine(trees: List[CodeTree]): List[CodeTree] = trees match {
    case left :: right :: cs => (makeCodeTree(left, right) :: cs)
      .sortWith((t1, t2) => weight(t1) < weight(t2))
    case _ => trees
  }

  @tailrec
  private def until(p: List[CodeTree] => Boolean, f: List[CodeTree] => List[CodeTree])(trees: List[CodeTree]): List[CodeTree] = {
    if (p(trees)) trees
    else until(p, f)(f(trees))
  }

  def createCodeTree(inputChars: String): CodeTree = {
    val chars = inputChars.toList
    until(singleton, combine)(makeOrderedLeafList(times(chars))).head
  }

  def encode(inputText: String): List[Int] = {
    val text = inputText.toList
    val tree = createCodeTree(inputText)
    def lookup(tree:  CodeTree)(c: Char): List[Int] = tree match {
      case Leaf(_, _) => List()
      case Fork(left, right, _, _) if chars(left).contains(c) => 0 :: lookup(left)(c)
      case Fork(left, right, _, _) => 1 :: lookup(right)(c)
    }

    text flatMap lookup(tree)
  }
}