package riskident.coding.challenge.test

import org.scalatest.FunSpec
import riskident.coding.challenge.{Customer, CustomerMeanHeap}

/**
  * Created by govind.bhone on 1/27/2017.
  */
class MeanHeapTest extends FunSpec {

  describe("Checking the MeanHeap working") {
    it("adding the customer to the heap") {
      val heap = new CustomerMeanHeap()(scala.math.Ordering.Long)
      heap.add(Customer(1,3))
      heap.add(Customer(2,9))
      heap.add(Customer(3,6))
      assertResult(3)(heap.size)

    }

    it("checking the top pop element") {
      val heap = new CustomerMeanHeap()(scala.math.Ordering.Long)
      heap.add(Customer(1,3))
      heap.add(Customer(2,9))
      heap.add(Customer(3,6))
      assertResult(Customer(1,3))(heap.pop.get)
    }
  }
}
