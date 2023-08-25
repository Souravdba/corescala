

/**
  * Created by Sourav on 9/24/2017.
  */
import java.io.{FileWriter, PrintWriter}
import bankutil.getClass
import execute.getClass
import org.joda.time._
import org.joda.time.format._
import org.joda.time.DateTimeZone._
import resource._
import scala.util.control.Breaks
object bankutil {


  /**
    * Created by Sourav on 9/24/2017.
    */
    def getIFSC(name: String, location: String): String = {
      val genera = (n: String) => {
        n match {
          case name: String => if (name.length >= 3) name.substring(0, 3)
          else (name + "00").substring(0, ((name + "00").length - name.length) + 1)
        }
      }
      var namepart = genera(name)
      var locationpart = genera(location)
      val random = scala.util.Random
      var randomgen = "%04d".format(random.nextInt(10000))
      namepart + locationpart + randomgen
    }

    def writeMeta(info: String) = {
      val writer = new PrintWriter(new FileWriter("C:\\Users\\Sourav\\IdeaProjects\\Sep17\\src\\main\\resources\\tt\\Application", true))
      writer.println(info)
      writer.close()
    }

    def SearchMeta(info: String): Int = {
      var location = getClass.getResource("tt/Application")
      var path = location.getPath
      var endSuccess=0
      var errResult=0
      var newrequest=0
      var cnt=0
      var nowtime = new DateTime()
      var pannumber = info.split(',')(1).trim
      for (source <- managed(scala.io.Source.fromFile(path))) {
          for (line <- source.getLines) {
              var linfo: Array[String] = line.split(',')
              var dttime = new DateTime(linfo.last.toLong * 1000)
              linfo match {
                case s@Array(_,pan, _*) =>    cnt+=1
                                             if(pan!=pannumber && Days.daysBetween(dttime, nowtime).getDays() < 30){
                                               newrequest+=1
                                             }
                                             else if (pan==pannumber && Days.daysBetween(dttime, nowtime).getDays() > 30) {
                                                  endSuccess+=1
                                                  }
                                              else {

                                                   errResult+=1
                                                   }

                case s:Array[String] => println("hello")
                case _ => print("NNNNNNNNNNNNN")
                          errResult+=1
              }
            }
      }
      if(newrequest>0)
        {
          -1
        }
      else
      {
        endSuccess
      }
//      endResult

    }


}
