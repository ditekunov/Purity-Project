package cryptographyOperations.decoders

import cryptographyOperations.encoders.HuffmanEncoder.{CodeTree, Fork, Leaf}

object HuffmanDecoder {

  /**
    * Function, that decodes given List[Int] of Huffman codes to a normal string.
    *
    * Usage:
    *
    * HuffmanDecoder.decode(HuffmanEncoder.createCodeTree(String), String)
    *
    * Purity project by Daniil Tekunov.
    */
  def decode(tree: CodeTree, bits: List[Int]): String = {
    def traverse(remaining: CodeTree, bits: List[Int]): List[Char] = remaining match {
      case Leaf(c, _) if bits.isEmpty => List(c)
      case Leaf(c, _) => c :: traverse(tree, bits)
      case Fork(left, right, _, _) if bits.head == 0 => traverse(left, bits.tail)
      case Fork(left, right, _, _) => traverse(right, bits.tail)
    }

    traverse(tree, bits)
  }.mkString("")



}
