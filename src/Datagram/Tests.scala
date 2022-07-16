package Datagram

import Composite.{Directory, File}
import Recursion.listFilterMap
import Visitor.{CounterVisitor, FilterVisitor}

import scala.jdk.CollectionConverters.CollectionHasAsScala

/**
 * Testing the different features of the practice
 */
object Tests {
  def main(args: Array[String]) = {
    System.out.println("Creating and adding csv file test...")
    val dir_datagram: Directory = new Directory("datagram directory")
    val dir_datagram_dad: Directory = new Directory("datagram directory")
    val fileTest1: File = new File(new CSV().readFile("cities.csv"))
    val fileTest2: File = new File(new CSV().readFile("cities2.csv"))
    dir_datagram.addChild(fileTest1)
    dir_datagram.addChild(fileTest2)
    dir_datagram_dad.addChild(dir_datagram)
    System.out.println("The directory contain the next files: " + dir_datagram.getName())
    System.out.println("The information related to the fourth row of the column City is: " + dir_datagram.at(4, "City"))
    System.out.println("The total rows of the directory are: " + dir_datagram.size())
    System.out.println("The total columns of the directory are: " + dir_datagram.columns())
    val CounterVisit: CounterVisitor = new CounterVisitor()
    dir_datagram_dad.accept(CounterVisit)
    System.out.println("The path cross " + CounterVisit.dirs + " directories and " + CounterVisit.files + " files")
    val FilterVisit: FilterVisitor = new FilterVisitor("LonM", x => x.toInt < 10)
    dir_datagram.accept(FilterVisit)
    System.out.println("Set of values corresponding to LonM less than 10 of the directory: " + FilterVisit.elements)
    System.out.println("Testing recursive functions")
    val recursive = new listFilterMap()
    val resultFloat: List[Float]=List()
    val resultString: List[String]=List()
    val listFloat = new java.util.LinkedList[Float]()
    val listString = new java.util.LinkedList[String]()
    for (elem: String <- fileTest1.info.get("LonD").asScala.toList) {
      listFloat.add(elem.toFloat)
    }
    for (elem: String <- fileTest2.info.get("State").asScala.toList) {
      listString.add(elem)
    }
    System.out.println("Round numbers greater than 100 from LonD using stack recursion..." + recursive.stack[Float]((x: Float) => x >= 100, (x: Float) => x.round.toFloat, listFloat))
    System.out.println("Round numbers greater than 100 from LonD using tail recursion..." + recursive.tail[Float]((x:Float) => x >= 100, (x: Float) => x.round.toFloat, listFloat,resultFloat))
    System.out.println("Replacing state OH for TX using stack recursion..."+ recursive.stack[String]((x: String) => x.contains("OH"), (x: String) => x.replace("OH", "TX"), listString))
    System.out.println("Replacing state OH for TX using tail recursion..." + recursive.tail[String]((x: String) => x.contains("OH"), (x: String) => x.replace("OH", "TX"), listString,resultString))
  }
}
