package riskident.coding.challenge.test

import org.scalatest.FunSpec
import riskident.coding.challenge.{Customer, MinAvgWaitingTimeCalculator}

import scala.collection.mutable.ArrayBuffer


/**
  * Created by govind.bhone on 1/27/2017.
  */
class SolutionTest extends FunSpec {

  describe("Checking output") {
    it("find the mean average waiting time first run") {
      val arrayBuffer1 = new ArrayBuffer[Customer]()
      arrayBuffer1.+=(Customer(1, 3))
      arrayBuffer1.+=(Customer(2, 9))
      arrayBuffer1.+=(Customer(3, 6))

      val arrayBuffer2 = new ArrayBuffer[Customer]()
      arrayBuffer2.+=(Customer(1, 3))
      arrayBuffer2.+=(Customer(2, 9))
      arrayBuffer2.+=(Customer(3, 5))

      assertResult(9)(MinAvgWaitingTimeCalculator().process(arrayBuffer1.toArray))
      assertResult(8)(MinAvgWaitingTimeCalculator().process(arrayBuffer2.toArray))
    }
  }
}