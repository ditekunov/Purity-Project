package sortingAlgorithms

import scala.annotation.tailrec

sealed abstract class HeapSort[+A] { def rank: Int }
case object EmptyHeapSort extends HeapSort[Nothing] { def rank = 0 }
case class NonEmptyHeapSort(rank: Int, element: Int, left: HeapSort[Int], right: HeapSort[Int]) extends HeapSort[Int]

object HeapSort {
  def apply(x: Int): HeapSort[Int] =
    this(x, EmptyHeapSort, EmptyHeapSort)

  def apply(x: Int, a: HeapSort[Int], b: HeapSort[Int]): HeapSort[Int] =
    if (a.rank > b.rank)
      NonEmptyHeapSort(b.rank + 1, x, a, b)
    else
      NonEmptyHeapSort(a.rank + 1, x, b, a)

  private def merge(a: HeapSort[Int], b: HeapSort[Int]): HeapSort[Int] =
    (a, b) match {
      case (x, EmptyHeapSort) => x
      case (EmptyHeapSort, x) => x
      case (x: NonEmptyHeapSort, y: NonEmptyHeapSort) =>
        if (x.element >= y.element)
          HeapSort(x.element, x.left, merge(x.right, y))
        else
          HeapSort(y.element, y.left, merge(x, y.right))
    }

  private def toList(heap: HeapSort[Int]): List[Int] =
    toListWithMemory(List(), heap)

  @tailrec
  private def toListWithMemory(memo: List[Int], heap: HeapSort[Int]): List[Int] =
    heap match {
      case EmptyHeapSort => memo
      case x: NonEmptyHeapSort =>
        toListWithMemory(x.element :: memo, merge(x.left, x.right))
    }

  def heapSort(xs: List[Int]): List[Int] =
    toList(xs.foldLeft(EmptyHeapSort: HeapSort[Int])((memo, x) => merge(HeapSort(x), memo)))
}
