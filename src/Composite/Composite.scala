package Composite
import Visitor.Visitor

/**
 * Trait that includes the functions that the composite will have
 */
trait Composite {
  def at(row: Int, label: String): String
  def columns(): Int
  def size(): Int
  def setParent(dad: Composite): Unit
  def getName(): String
  def accept(visitor: Visitor): Unit
}
