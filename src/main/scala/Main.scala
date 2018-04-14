import listOperations.ListProperties._

import scala.concurrent.ExecutionContext.Implicits.global
import charOperations.CharProperties._
import complexOperations.ArithmeticComplex.Complex
import integerOperations.IntegerProperties._
import integerOperations.IntegerGeneratorsMath._
import integerOperations.IntegerMath._
import integerOperations.IntegerGenerators._
import doubleOperations.DoubleProperties._
import cryptographyOperations.decoders.{GrayDecoder, HuffmanDecoder, MorseDecoder}
import cryptographyOperations.encoders.{GrayEncoder, HuffmanEncoder, MorseEncoder, RLE_Encoder}
import sortingAlgorithms.QuickSort._
import sortingAlgorithms.unseriousAlgorithms.SleepSort
import sortingAlgorithms.unseriousAlgorithms.SleepSort.sleepSort
import persistentDataStructures.Stack._
import persistentDataStructures.Set._
import persistentDataStructures.Set


import scala.concurrent.Future
import complexOperations.ArithmeticComplex.Complex._


object Main extends App {

  val a: Set[Int] = basicSet(14)

  print(convertToString(filter(a, basicSet(14)), 1000))

}
