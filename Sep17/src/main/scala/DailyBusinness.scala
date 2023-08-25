/**
  * Created by Sourav on 9/24/2017.
  */

import org.joda.time._
import org.joda.time.format._
import org.joda.time.DateTimeZone._


case class Aperson(val name:String,val Age:Int,val PAN:String)
{
  override def toString()=s"${name},${PAN}"
}
class DailyBusinness {


}
object execute extends  App{
  var nadn=new Bank("SBI","HYDRABAD")
  var p1=Aperson("Rama",20,"abjjjdef")
  var tow=nadn.appyforAcnt(p1)
  print(tow)
  if(tow._2 == -1)
    {
        bankutil.writeMeta("%s,%s,%s,%d".format(p1.name,p1.PAN,tow._1,(new DateTime().getMillis)/1000))
    }

}
