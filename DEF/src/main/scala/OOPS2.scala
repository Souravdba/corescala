

/**
  * Created by Sourav on 7/16/2017.
  */
object OOPS2 extends  App{
 var sPrint = s"The quick brown fox jumps over the lazy dog. "
  var count=0
  for(i<-1 to 10)
    {
     for(j<-sPrint)
       {
         if(count<77)
           {
             if(count==0)
               {
                 print(">"+j)
               }
             else
               {
                 print(j)
               }
           }
         else
           {
             print("\r\n"+">"+j.toString.trim)
             count = 0
           }
         count+=1
       }


    }
}
