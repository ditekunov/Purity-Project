package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import persistentDataStructures.{ListStructure, NilType, Queue, Stack}
import persistentDataStructures.LinkedList._
import persistentDataStructures.miscellaneous.DataStructureException
import persistentDataStructures.Queue._
import persistentDataStructures.Stack._


class DataStructuresTests extends FunSuite {

  test("CRUD testing of a LinkedList") {
    create(1) shouldBe ListStructure(1, NilType)

    val a  = create(1, create(2))
    a shouldBe ListStructure(1, ListStructure(2, NilType))

    val b = a.remove(1)
    b shouldBe ListStructure(2, NilType)

    val c = b.remove(2)
    c shouldBe NilType
  }

  test("Additional testing of a LinkedList") {

  }

  test("CRUD testing of a Queue") {
    val a: Queue[Nothing] = createEmptyQueue

    a.isEmpty shouldBe true

    val b = a.enqueue("Element1")

    val (c, d): (String, Queue[String]) = b.dequeue

    //d shouldBe a

    c shouldBe "Element1"
  }

  test("CRUD testing of a Stack") {
    val a: Stack[Nothing] = createEmptyStack

    a.isEmpty shouldBe true

    val b: Stack[String] = a.add("Element1")

    val (c, d): (String, Stack[String]) = b.remove

    //d shouldBe a

    c shouldBe "Element1"
  }

}
