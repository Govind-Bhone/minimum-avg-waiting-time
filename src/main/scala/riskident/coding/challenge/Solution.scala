package riskident.coding.challenge

import scala.io.StdIn

/**
  * Created by govind.bhone on 4/9/2017.
  */
object Solution {

  def singleIteration(inputStream: StdIn.type): Long = {
    println("Enter the no of input : ")
    val N = inputStream.readInt()

    val customers = (for {
      i <- 0 to N - 1
    } yield {
      val lineSplits = inputStream.readLine().split("\\s+")
      Customer(lineSplits(0).toLong, lineSplits(1).toLong)
    }).toArray.sorted(Ordering[Long].on[Customer](_.orderTime))
    MinAvgWaitingTimeCalculator().process(customers)
  }

  def main(args: Array[String]): Unit = {
    val inputStream = scala.io.StdIn
    var tryOneMoreRun = "NO"
    do {
      println(s"Minimum average waiting time is ${singleIteration(inputStream)}")
      println("Do you want to try again (YES/NO) :")
      tryOneMoreRun = inputStream.readLine()
    } while (tryOneMoreRun.equalsIgnoreCase("YES"))
    println("Exiting the Application.....")
    sys.exit(0)

  }

}
