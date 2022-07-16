package Visitor
import Composite.Directory
import Composite.File

/**
 * method that returns the number of directories and files through which it passes
 */
class CounterVisitor extends Visitor {
  var files: Int = 0
  var dirs: Int = 0

  /**
   * It goes through all the children and every time this function is called it will be that it has visited a new directory
   * @param trate directory
   */
  override def visit(trate: Directory): Unit = {
    dirs += 1
    for (child <- trate.children)
      child.accept(this)
  }

  /**
   * every time this function is called it will be that it has visited a new file
   * @param trate file
   */
  override def visit(trate: File): Unit = {
    files += 1
  }

}
