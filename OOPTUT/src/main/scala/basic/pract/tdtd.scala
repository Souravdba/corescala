package basic.pract

/**
  * Created by Sourav on 8/15/2018.
  */

class person(var name:String,var age:Int)
class employee(name:String,sal:Int) extends person(name,sal)

object tdtd  extends App{
  val dd=new employee("Hari",24)
  println()
}
