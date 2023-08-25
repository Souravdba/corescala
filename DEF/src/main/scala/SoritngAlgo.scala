/**
  * Created by Sourav on 7/23/2017.
  */
import scala.collection.mutable.{ArrayBuffer => ar}

object l extends App{
  var k = ar[Int](4,343,23,12,2)
  for(m <-1 until k.length )
    {
      var key=k(m)
      var i=m-1
     while(i>0 & k(i)> key)
       {
         k(i+1)=k(i)
         i=i-1
       }
      k(i+1)=key
    }

//  println(k)
k.foreach(println)
}
