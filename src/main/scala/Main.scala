import functionalAlgorithms._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future


object Main extends App {


  println(isPalindrome(List("aba")))
  println(isPalindrome("aba"))
  println(121.toString.reverse)
  println(isPalindrome('a'))

}
