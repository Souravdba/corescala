import java.beans.Expression

/**
  * Created by Sourav on 7/16/2017.
  */
//class OOPS1[T](m:T) extends Traversable[T]{
//
//  def foreach[B](f:T=>B)=f(m)
//
//}

object AGE {
  val DEFAULT_AGE = 0
  }
class person()
{
   var firstname:Option[String] = None
   var lastname:Option[String] = None
   var age:Int=AGE.DEFAULT_AGE
   def this(firstname:String,lastname:String)
   {
     this()
     this.firstname = Some(firstname)
     this.lastname = Some(lastname)
   }
  def this(firstname:String,lastname:String,age:Int)
  {
    this(firstname,lastname)
    this.age=age
  }
  def this(name:String)
  {
    this(name.split(",")(0),name.split(",")(1))
  }
  override def toString: String = s"${firstname.get}-${lastname.get},${lastname.get}"
}
object k extends  App{
  val pp = new person("Ravi","Sahoo")
  val pp1 = new person("Hari,Sahoo")
  val pp2 = new person("Shayam","Sahoo",30)
  val pp3 = new person()

  println(pp)
  println(pp1)
  println(pp2)
}
