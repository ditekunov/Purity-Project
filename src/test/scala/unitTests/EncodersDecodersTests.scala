package unitTests

import org.scalatest.Matchers._
import functionalAlgorithms.encoders.RLE_Encoder
import functionalAlgorithms.decoders.RLE_Decoder
import org.scalatest.FunSuite

class EncodersDecodersTests extends FunSuite {

  test("Testing of RLE encoder/decoder") {

    val TestList =
    List('a, 'a, 'a, 'b, 'b, 'b, 'a, 'a, 'c)
    val RLE_EncodedResult: List[(Int, Symbol)] =
    List((3, 'a), (3, 'b), (2, 'a), (1, 'c))

    val encodeResult: List[(Int, Symbol)] = RLE_Encoder.encode(TestList)
    val decodeResult: List[Symbol] = RLE_Decoder.decode(RLE_EncodedResult)
    encodeResult shouldBe RLE_EncodedResult
    decodeResult shouldBe TestList
  }
}
