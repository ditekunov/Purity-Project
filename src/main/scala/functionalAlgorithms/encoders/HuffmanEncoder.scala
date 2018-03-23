package functionalAlgorithms.encoders

import collection.immutable.Queue

/**
  * Contains functional realisation of a Huffman encoding algorithm.
  */
object HuffmanEncoder {

  /**
    * Basic class, that contains:
    *
    * frequency - frequency of a given symbol, used to create a unique code.
    *
    * emptyPrefix - adds an "empty string" prefix, when there are no new nodes
    *
    * prefix - contains the whole code of a symbol
    *
    */
  private abstract sealed class Tree[Char] {
    val frequency: Int

    def emptyPrefix: List[(Char, String)] = prefix("")

    def prefix(prefix: String): List[(Char, String)]
  }

  private final case class InternalNode(left: Tree[Char], right: Tree[Char]) extends Tree[Char] {

    val frequency: Int = left.frequency + right.frequency

    def prefix(prefix: String): List[(Char, String)] =
      left.prefix(prefix + "0") ::: right.prefix(prefix + "1")
  }
  private final case class LeafNode(element: Char, frequency: Int) extends Tree[Char] {
    def prefix(prefix: String): List[(Char, String)] = List((element, prefix))
  }

  def encode(input: String): List[(Char, String)] = {


    val frequencies: List[(Int, Char)] = RLE_Encoder.encode(input.toList.sorted)
    val frequenciesSort: List[(Char, Int)] = frequencies.map { tup: (Int, Char) => (tup._2, tup._1) }

    def dequeueSmallest(q1: Queue[Tree[Char]], q2: Queue[Tree[Char]]) = {
      if (q2.isEmpty) (q1.front, q1.dequeue._2, q2)
      else if (q1.isEmpty || q2.front.frequency < q1.front.frequency) (q2.front, q1, q2.dequeue._2)
      else (q1.front, q1.dequeue._2, q2)
    }

    def mainAlgorithm(q1: Queue[Tree[Char]], q2: Queue[Tree[Char]]): List[(Char, String)] = {
      if (q1.length + q2.length == 1) (
        if (q1.isEmpty) q2.front else q1.front
        ).emptyPrefix
      else {
        val (v1, q3, q4) = dequeueSmallest(q1, q2)
        val (v2, q5, q6) = dequeueSmallest(q3, q4)
        mainAlgorithm(q5, q6.enqueue(InternalNode(v1, v2)))
      }
    }
    mainAlgorithm(Queue.empty.enqueue(frequenciesSort sortWith  { _._2 < _._2 } map { e => LeafNode(e._1, e._2) }),
      Queue.empty)
  }
}
