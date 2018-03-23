import functionalAlgorithms.FunctionalAlgorithms._

import scala.concurrent.ExecutionContext.Implicits.global
import charOperations.CharProperties._
import integerOperations.IntegerProperties._
import functionalAlgorithms.encoders.{HuffmanEncoder, RLE_Encoder}

import scala.concurrent.Future


object Main extends App {

  //print(16.listBinaryDivisors)

print(HuffmanEncoder.encode("I am string, that really wants to be encoded. I may contain some rare symbols, like ~ or ^&."))
}
