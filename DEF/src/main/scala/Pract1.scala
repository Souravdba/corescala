import scala.runtime.RichInt

/**
  * Created by Sourav on 8/13/2017.
  */

object Pract1 extends App{
  def gcd(x: Int, y: Int): Int = (x, y) match {
    case (0, 0)  => throw new IllegalArgumentException("(0, 0)");
    case (xx, 0) => xx;
    case (0, yy) => yy;
    case _       => gcd(y, x % y)
  }


  @annotation.tailrec
  def factorial(n:Int,k:BigInt):BigInt={
    if (n == 0) k
    else
      factorial(n-1,n*k)
  }

//  print(factorial(20,1))

  def fiboncie(n:Int):Int={
    var count=3
    var e1 = 0
    var e2 = 1
    var e3 = e1 + e2
    while(count<n)
     {
       e1 = e2
       e2 = e2 + 1
       e3 = e1 + e2
       count+=1
     }
    e3
  }

@annotation.tailrec
def fiboncie1(n:Int,k:Int,l:Int):Int=
{
  n match {
    case 0 => k
    case _ => fiboncie1(n-1,l,k+l)
  }
}

  val devide=new PartialFunction[Int,Int] {
    def apply(n:Int)= 42/n
    def isDefinedAt(nj: Int) = nj != 0

  }


}

