import listOperations.ListProperties._

import scala.concurrent.ExecutionContext.Implicits.global
import charOperations.CharProperties._
import integerOperations.IntegerProperties._
import integerOperations.IntegerMath._
import integerOperations.IntegerGenerators._
import doubleOperations.DoubleProperties._
import functionalAlgorithms.decoders.GrayDecoder
import functionalAlgorithms.encoders.{GrayEncoder, HuffmanEncoder, RLE_Encoder}

import scala.concurrent.Future


object Main extends App {
  println(GrayEncoder.encode(4))




}
