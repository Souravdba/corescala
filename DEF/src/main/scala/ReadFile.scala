/**
  * Created by Sourav on 7/16/2017.
  */
import scala.io.Source
import resource._

object ops
{
  def factorial(n:Int):Long=
  {
    @annotation.tailrec
    def go(n:Int ,acc:Int): Int =
    {
      if(n==0) acc
      else go(n-1,acc*n)
    }
   go(n,1)
  }

  def fiboncie(n:Int):Unit=
  {
    var n1=0
    var n2=1
    var i=0
    println(n1)
    println(n1+n2)
    while(i<n)
      {
        var n3 = n1 + n2
        n1 = n2
        n2 = n3
        println(n3)
        i=i+1
      }
  }

}
object ReadFile extends  App{
//  println(ops.factorial(12))
  def wrapper(s:String,n:Int,f:Int=>Unit)=
  {
    println("Printing Factorial")
    f(n)
  }
  wrapper("Foctorial",5,ops.fiboncie)
}
