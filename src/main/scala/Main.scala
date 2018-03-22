import functionalAlgorithms.FunctionalAlgorithms._

import scala.concurrent.ExecutionContext.Implicits.global
import charOperations.CharProperties._
import integerOperations.IntegerProperties._
import functionalAlgorithms.encoders.RLE_Encoder

import scala.concurrent.Future


object Main extends App {
  final val TestList = List('a, 'a, 'a, 'b, 'b, 'b, 'a, 'a, 'c)

  println(RLE_Encoder.encode(TestList))

  println(166.isSquared())
}
