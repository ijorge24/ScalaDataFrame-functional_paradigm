package Recursion

import scala.jdk.CollectionConverters._

class listFilterMap {
  /**
   * Stack recursion which performs an operation on the elements of a list that meet a specified condition
   * @param Condition condition that have to achieve to perform an operation
   * @param Operation operation
   * @param Collection list of values
   * @tparam T generic type
   * @return the set of values, those that touch with the operation done
   */
  def stack[T](Condition: T => Boolean, Operation: T =>T, Collection: java.util.List[T]): List[T] = Collection.asScala.toList match {
      case Nil => Nil
      case x :: xs => if (Condition(x)) Operation(x) :: stack(Condition, Operation, xs.asJava) else x :: stack(Condition, Operation, xs.asJava)
    }

  /**
   * Tail recursion which performs an operation on the elements of a list that meet a specified condition
   * @param Condition condition that have to achieve to perform an operation
   * @param Operation operation
   * @param Collection list of values
   * @tparam T generic type
   * @return the set of values, those that touch with the operation done
   */
  def tail[T](Condition: T => Boolean, Operation: T => T, Collection: java.util.List[T], Return: List[T]): List[T] = Collection.asScala.toList match {
      case Nil => Return
      case x :: xs => tail(Condition, Operation, xs.asJava, if (Condition(x)) Operation(x) :: Return else x :: Return)
    }
}
