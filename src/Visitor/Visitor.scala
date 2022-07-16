package Visitor
import Composite.Directory
import Composite.File

/**
 * trait that includes the functions of the visitor
 */
trait Visitor {
  def visit(trate: Directory): Unit

  def visit(trate: File): Unit


}
