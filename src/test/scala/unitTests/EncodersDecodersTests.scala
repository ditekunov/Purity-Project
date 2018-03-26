package unitTests

import org.scalatest.Matchers._
import functionalAlgorithms.encoders.{GrayEncoder, HuffmanEncoder, RLE_Encoder}
import functionalAlgorithms.decoders.{GrayDecoder, RLE_Decoder}
import org.scalatest.FunSuite
import utils.InputException

class EncodersDecodersTests extends FunSuite {

  test("Testing of RLE encoder/decoder") {

    val TestList = List('a, 'a, 'a, 'b, 'b, 'b, 'a, 'a, 'c)
    val RLE_EncodedResult: List[(Int, Symbol)] = List((3, 'a), (3, 'b), (2, 'a), (1, 'c))

    val encodeResult: List[(Int, Symbol)] = RLE_Encoder.encode(TestList)
    val decodeResult: List[Symbol] = RLE_Decoder.decode(RLE_EncodedResult)
    encodeResult shouldBe RLE_EncodedResult
    decodeResult shouldBe TestList
  }

  test("Testing of the Huffman encoder") {
    val testString = "I am string, that really wants to be encoded. I may contain some rare symbols, like ~ or ^&."

    val Huffman_encodedResult: List[(Char, String)] = List((' ', "00"), ('g', "010000"), ('h', "010001"),
      ('k', "010010"), ('w', "010011"), ('n', "0101"), ('r', "0110"), ('s', "0111"), ('o', "1000"),
      ('t', "1001"), ('i', "10100"), ('y', "10101"), ('a', "1011"), ('e', "1100"), ('~', "110100"),
      (',', "110101"), ('l', "11011"), ('m', "11100"), ('.', "111010"), ('I', "111011"), ('b', "111100"),
      ('c', "111101"), ('d', "111110"), ('&', "1111110"), ('^', "1111111"))

    val encodeResult: List[(Char, String)] = HuffmanEncoder.encode(testString)

    encodeResult shouldBe Huffman_encodedResult

  }

  test("Testing of Gray encoder/decoder") {

    GrayEncoder.encode(4) shouldBe 6
    assertThrows[InputException] {
      GrayEncoder.encode(-1)
    }

    GrayDecoder.decode(6) shouldBe 4
    assertThrows[InputException] {
      GrayDecoder.decode(-1)
    }

  }
}
