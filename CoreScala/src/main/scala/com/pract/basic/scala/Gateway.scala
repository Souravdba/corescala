
/**
  * Created by Sourav on 10/25/2017.
  */

class LinkedList[A] {
  private class node[A](elem:A){
    var next:node[A]=_

    override def toString: String = elem.toString
  }
  private var head:node[A]= _

  def add(elem:A)={
    val n = new node(elem)
    n.next = head
    head=n
  }
  private def printNode(n:node[A]): Unit =
  {
    if(n!=null)
      {
        println(n)
        printNode(n.next)
      }
  }

  def printall()={printNode(head)}
}


object Gateway extends  App{

  trait animal
  class dog extends animal {
    override def toString: String = "Dog"}
  class superdog extends dog {
    override def toString: String = "SuperDog"
  }
  class Dunnydog extends dog {
    override def toString: String = "FunnyDog"
  }
  val tipu=new dog
  val bravo=new superdog
  val lipu=new Dunnydog
  val nn=new LinkedList[dog]()
  nn.add(tipu)
  nn.add(bravo)
  nn.printall()

  println("++++++++++++++++++++++++++++++")

  def printdog

}
