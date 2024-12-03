package adventofcode
import scala.io.Source.*


@main def day2() = 
  val inputPath = helpers.InputDir + "2.txt"

  val reports: Seq[Array[Int]] = scala.io.Source.fromFile("./inputs/2.txt", "UTF-8")
    .getLines.toSeq
    .map(_.split(" "))
    .map(_.map(_.toInt))
  //println(reports.length)

  //This won't filter out if window.head == window.last
  val reportsWithOnlyIncOrDec: Seq[Array[Int]] = 
    reports.filter(report =>
      report
      .sliding(2)
      .map(window => window.head > window.last).toSeq
      .distinct.length == 1
    )

  val reportsWithGoodIncOrDec: Seq[Array[Int]] =
    reports.filter(report =>
      report
      .sliding(2)
      .map(window => (window.head - window.last).abs >= 1 && (window.head - window.last).abs <= 3)
      .toSeq
      .contains(false) != true 
    )

  val goodReports = reportsWithGoodIncOrDec.intersect(reportsWithOnlyIncOrDec)

  println("Part 1: " + goodReports.length)
