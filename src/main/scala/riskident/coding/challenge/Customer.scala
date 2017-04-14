package riskident.coding.challenge

/**
  * Created by govind.bhone on 4/9/2017.
  */

case class Customer(val orderTime:Long,val cookTime:Long){
  override def toString(): String = s"Customer orderTime: $orderTime And cookTime: $cookTime"
}
