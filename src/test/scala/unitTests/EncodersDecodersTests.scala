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

    val encodedHuffmanString = List(1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0,
      1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1,
      0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0,
      0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0,
      1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0,
      1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1,
      1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1,
      0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1,
      1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0,
      0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0,
      0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0)

    HuffmanEncoder.encode(testString) shouldBe encodedHuffmanString

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
