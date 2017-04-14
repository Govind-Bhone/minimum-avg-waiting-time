package riskident.coding.challenge

/**
  * Created by govind.bhone on 4/10/2017.
  */

import scala.collection.mutable.ListBuffer

class CustomerMeanHeap(implicit comparator:Ordering[Long]) {

  private val GREATER_THAN = 1
  private val LESS_THAN = -1

  private val customers = new ListBuffer[Customer]()

  private def lastIndex = customers.size - 1

  private def valueOf(index: Int): Customer = customers(index)

  def size = customers.size
  def isEmpty =customers.isEmpty

  def add(item: Customer): CustomerMeanHeap = {
    customers.append(item)
    bubbleUp(lastIndex)
    this
  }

  def swap(index1: Int, index2: Int) {
    val temp = valueOf(index1)
    customers.update(index1, valueOf(index2))
    customers.update(index2, temp)
  }

  def bubbleUp(currentIndex: Int) {
    def getParent(i: Int) = (i - 1) / 2

    if (currentIndex > 0) {
      val parentIndex = getParent(currentIndex)

      comparator.compare(valueOf(currentIndex).cookTime, valueOf(parentIndex).cookTime) match {
        case LESS_THAN =>
          swap(currentIndex, parentIndex)
          bubbleUp(parentIndex)
        case _ =>
      }
    }
  }

  def bubbleDown(currentIndex: Int) {
    getLowerChild(currentIndex) match {
      case Some((lowerChildIndex, lowerChildValue)) =>
        if (comparator.compare(valueOf(currentIndex).cookTime, lowerChildValue.cookTime) == GREATER_THAN) {
          swap(currentIndex, lowerChildIndex)
          bubbleDown(lowerChildIndex)
        }
      case None =>
    }
  }

  def getLowerChild(index: Int): Option[(Int, Customer)] = {
    def getChildrenIndices(parentIndex: Int): (Int, Int) = (2 * parentIndex + 1, 2 * parentIndex + 2)

    val (leftChildIndex, rightChildIndex) = getChildrenIndices(index)

    val areChildrenInBoundsOfHeap = (rightChildIndex <= lastIndex) && (leftChildIndex <= lastIndex)
    if (!areChildrenInBoundsOfHeap) return None

    val (leftChildValue, rightChildValue) = (customers(leftChildIndex), customers(rightChildIndex))

    comparator.compare(leftChildValue.cookTime, rightChildValue.cookTime) match {
      case LESS_THAN => Some((leftChildIndex, leftChildValue))
      case _ => Some((rightChildIndex, rightChildValue))
    }
  }

  def pop: Option[Customer] =
    if (customers.isEmpty) None
    else {
      val firstValue = customers(0)
      if (customers.size == 1) {
        customers.remove(0)
      }
      else {
        swap(0, lastIndex)
        customers.remove(lastIndex)
        bubbleDown(0)
      }
      Some(firstValue)
    }


  override def toString = {
    s"[$customers](${customers.size})"
  }

}
