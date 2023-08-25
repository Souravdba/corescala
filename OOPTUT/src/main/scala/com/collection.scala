package com
import scala.reflect.runtime.universe._
import scala.reflect.{ClassTag, classTag}
/**
  * Created by Sourav on 8/26/2018.
  */


object collection extends App{
  def getInnerType[T](list:List[T])(implicit tag:ClassTag[T]) = tag
  val StringClass = classTag[String]
  val IntClass = classTag[Int]
  val fg= getInnerType(List(1, 2, 3))
  println(fg.getClass)
  print(IntClass.getClass)
   fg match
    {
    case StringClass => "It's a String!"
    case IntClass => "It is Integer"
    case _ => "UNKN"
  }


//    tag match {
//      case StringClass => "It's a String!"
//      case IntClass => "It's an Integer."
//      case _ => "It's something else entirely"
//    }
//  }
//
//  println(getInnerType(List(1, 2, 3)))
}
