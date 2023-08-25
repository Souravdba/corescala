package com.oop.typesafe
//
//
///**
//  * Created by Sourav on 10/3/2017.
//  */
//
//class LinkedList[A]
//{
//  private class Node[A](elem:A)
//  {
//    var next:Node[A] = _
//    override def toString = elem.toString
//  }
//  private var head:Node[A]=_
//
//  def add(el:A): Unit =
//  {
//    val kl=new Node[A](el)
//    kl.next=head
//    head=kl
//  }
//
//  private def printNode(elem:Node[A]): Unit =
//  {
//    if(elem != null)
//      {
//        println(elem)
//        printNode(elem.next)
//      }
//  }
//
//  def prinAll(): Unit =
//  {
//   printNode(head)
//  }
//}
//
//
//object tpsf extends App{
//
//  trait Animal
//  class Dog() extends Animal {
//    override def toString: String = "Normal Dog"}
//
//  class DesiDog extends  Dog{
//    override def toString: String = "Desi Dog"
//    def bark():Unit=println("Bow..")
//  }
//
//  class ForeignDog extends Dog{
//    override def toString: String = "Foreign Dog"
//  }
//
//  val ll=new LinkedList[Animal]()
//  ll.add(new DesiDog)
//  ll.add(new ForeignDog)
//
//  def printDogtype[A<:{ def bark():Unit}](ele:A):Unit =
//  {
//    ele.bark()
//  }
//
//    val lll=new LinkedList[DesiDog]()
//    printDogtype(new ForeignDog)
//
//
//}
