package com.pract.loop

/**
  * Created by Sourav on 3/26/2018.
  */
object matching extends App{
  case class Emp(name:String,sal:Int)
  def guessTheInput(inp:Any)= inp match {
    case i:List[_] => println("List")
    case i:Array[Int] => println("Array")
    case i:(_) => println("Tuple")
    case _ =>println("Not found")
  }
  var st=List(1,2,3,4)
  guessTheInput(st)
  var st1=Array(2,4,5)
  guessTheInput(st1)
  var st2=(2,4)
  guessTheInput(st2)


}
