package Composite

import Visitor.Visitor

import scala.collection.mutable.ListBuffer

/**
 * constructor directory
 * @param name name of the directory
 */
class Directory(val name: String) extends Composite {
  var children = new ListBuffer[Composite]()
  var parent: Composite = null
  var nom: String =name

  /**
   * method that takes the specific position according to a key of all the files in the directory
   * @param row row=position of the key array
   * @param label key name
   * @return string containing all elements that satisfy the conditions
   */
  override def at(row: Int, label: String): String = {
    var result: String = ""
    for (child <- children) {
      result = result.concat(child.at(row, label)+"\n")
    }
    result
  }

  /**
   * method that return the number of keys of all the files of a directory
   * @return number of keys of all the files of a directory
   */
  override def columns(): Int = {
    var result: Int = 0
    for (child <- children) {
      result += child.columns()
    }
    result
  }

  /**
   * method that returns the name of all the files in a directory
   * @return the name of all the files
   */
  override def getName(): String = {
    var result: String=""
    for (child <- children) {
      result =result.concat(child.getName())
      result+=" "
    }
    result
  }

  /**
   * method that return the size of all the files of a directory
   * @return size of all the files of a directory
   */
  override def size(): Int = {
    var result: Int = 0
    for (child <- children) {
      result += child.size()
    }
    result
  }

  /**
   * set the parent directory to this subdirectory
   * @param dad parent directory
   */
  override def setParent(dad: Composite): Unit = {
    parent = dad: Composite
  }

  /**
   * add a new file or subdirectory to this directory
   * @param child child directory or file
   */
  def addChild(child: Composite): Unit = {
    children +=child
    child.setParent(this)
  }

  /**
   * remove a selected child in a directory
   * @param child removed
   */
  def removeChild(child: Composite): Unit = {
    children -= child
  }

  /**
   * Method that accepts a visitor and performs the type of visitor to the list of datagrams of a directory
   * @param visitor type of visitor
   */
  override def accept(visitor: Visitor):Unit = {
    visitor.visit(this)
  }
}
