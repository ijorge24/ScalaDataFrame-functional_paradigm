package Visitor

import Composite.{Directory, File}
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters.CollectionHasAsScala

/**
 * visitor that queries all values of a specified key that meet a specified condition
 * @param label key
 * @param condition condition to meet
 */
class FilterVisitor(val label: String, val condition: String => Boolean) extends Visitor {
  var elements = new ListBuffer[String]()

  /**
   * loop through the different children of the directory
   * @param trate directory to be treated
   */
  override def visit(trate: Directory): Unit = {
    for (child <- trate.children)
      child.accept(this)
  }

  /**
   * method that adds the values that satisfy the condition of a specific file
   * @param trate file to be treated
   */
  override def visit(trate: File): Unit = {
    for (element <- trate.getInfo.get(label).asScala.toList)
      {
        if (condition(element))
          elements.addOne(element)
      }
  }
}
