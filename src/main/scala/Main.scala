import listOperations.ListProperties._

import scala.concurrent.ExecutionContext.Implicits.global
import charOperations.CharProperties._
import integerOperations.IntegerProperties._
import integerOperations.IntegerMath._
import integerOperations.IntegerGenerators._
import doubleOperations.DoubleProperties._
import functionalAlgorithms.decoders.{GrayDecoder, HuffmanDecoder, MorseDecoder}
import functionalAlgorithms.encoders.{GrayEncoder, HuffmanEncoder, RLE_Encoder, MorseEncoder}
import sortingAlgorithms.QuickSort._
import sortingAlgorithms.unseriousAlgorithms.SleepSort.sleepSort

import scala.concurrent.Future


object Main extends App {
sleepSort(List(5,4,2,1,7,3))
}
