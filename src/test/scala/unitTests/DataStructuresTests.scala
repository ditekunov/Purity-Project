package unitTests

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import persistentDataStructures.{ListStructure, NilType}
import persistentDataStructures.LinkedList._
import persistentDataStructures.miscellaneous.DataStructureException


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

}
