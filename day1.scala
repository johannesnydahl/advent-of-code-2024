package adventofcode

import scala.io.Source.*

val inputPath = Helpers.InputDir + "1.txt"

@main def main() = 
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
  
