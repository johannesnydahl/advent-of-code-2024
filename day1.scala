package adventofcode
import scala.io.Source.*


@main def day1() = 
  val inputPath = helpers.InputDir + "1.txt"

  println("Part 1: " + 
    fromFile(inputPath, "UTF-8")
    .getLines.toSeq
    .map(_.split("   "))
    .transpose
    .map(column => column.map(cell => cell.toInt ).sorted)
    .transpose
    .map(pair => (pair.head - pair.last).abs)
    .sum
  )

  println("Part 2: " +
    fromFile(inputPath, "UTF-8")
      .getLines.toSeq
      .map(_.split("   "))
      .flatten
      .groupBy(f => f)
      .map(f => f._1.toInt * (f._2.length - 1))
      .sum 
  )
  
