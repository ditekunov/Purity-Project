import functionalAlgorithms.FunctionalAlgorithms._

import scala.concurrent.ExecutionContext.Implicits.global
import charOperations.CharProperties._
import integerOperations.IntegerProperties._
import functionalAlgorithms.encoders.RLE_Encoder

import scala.concurrent.Future


object Main extends App {

  //print(16.listBinaryDivisors)
  print(16.listN_MultipleDivisors(1))

}
