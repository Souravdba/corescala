import java.io.{FileWriter, PrintWriter}
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
trait banking
{
  val name:String
  val location:String
  val IFSC_code:String
  protected  def policy_Topenacnt(s:Aperson):(Boolean,Int)
}

class Bank(val name: String, val location: String) extends  banking{
  val logg=LoggerFactory.getLogger(this.getClass)
  val IFSC_code = bankutil.getIFSC(name, location)

  protected  def policy_Topenacnt(s:Aperson):(Boolean,Int) = {
     logg.debug("Policy Validaton-I Last Application date ")
//     println("Policy Validaton-I Last Application date ")
     println(bankutil.SearchMeta(s.toString))
     if(bankutil.SearchMeta(s.toString) > 0)
       {
         logg.debug("Last apllication date more than 30 days")
         logg.debug("Policy Validaton-I Last Application date passed ")
         (true,bankutil.SearchMeta(s.toString))
       }
     else if (bankutil.SearchMeta(s.toString) == -1)
       {
         (false,-1)
       }
     else{
         logg.debug("Last apllication date lest than 30 days")
         logg.debug("Policy Validaton-I Last Application date failed ")
         (false,bankutil.SearchMeta(s.toString))
     }
    }
    def appyforAcnt(s:Any): (String,Int) =
    {
      logg.debug("Processing aplication request for "+s.toString)
      logg.debug("Validating Age")
      var Status=s match{
        case k:Aperson => if(k.Age > 18)
                          {
                            logg.debug("Validaton of Age passed")
                            logg.debug("Validation Policy")
                            var res=policy_Topenacnt(k)
                            println(res)
                            if(res._1==true) ("PASSED",res._2)
                            else ("FAILED",res._2)
                          }
                          else {
                            logg.debug("Validation of Age Failed")
                            ("FAILED",0)
                          }
        case _ => ("FAILED",0)
      }
      if(Status == ("FAILED",-1))
        {
          Status=("APPROVED",-1)
        }
      logg.debug("Final status  "+Status._1)
      Status
    }
  }


