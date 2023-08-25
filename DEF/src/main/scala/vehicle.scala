/**
  * Created by Sourav on 8/12/2017.
  */
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import scala.util.Try
case class CustomException(s: String)  extends Exception(s)

object EngineType extends Enumeration{
  type EngineType = Value
  val Disel = Value("Disel")
  val Patrol = Value("Patrol")
  val Gasoline = Value("Gasoline")
  val Unknown = Value("Unknown")
  def withNamedefault(k:String):Value = values.find(_.toString==k).getOrElse(Unknown)

}
import EngineType._

abstract class runnable(wheel:Int,Engine:EngineType)
{
  def getWheelnum:Int
  def getEngineType:EngineType
}
class vehicle private(wheel:Int,private[this] var Engine:EngineType,private[this] var Cost:Float=0,var color:String="") extends runnable(wheel,Engine) {
  def getWheelnum=wheel
  def getEngineType=Engine
  def setCost(Cost:Int)=this.Cost=Cost
  def getCost(Cost:Int)=this.Cost

  override def toString: String = s"$wheel - $Engine - $color - $Cost"

  override def equals(that: Any): Boolean ={
    try
      {
        if(that.isInstanceOf[runnable] && this.getEngineType == that.asInstanceOf[runnable].getEngineType)
        {
          true
        }
        else
        {
          false
        }
      }
    catch
      {
        case e:Exception=> false

      }

  }

}

object vehicle
{
  def produceVehicle(Astring:Array[String]):vehicle={

        if(EngineType.values.exists(_.toString == Astring(1)))
        {
          var wheel=Astring(0).toInt
          var Engine=Astring(1)
          var Cost=Try(Astring(2).toInt).toOption.getOrElse(0)
          var color=Astring(3)
          new vehicle(wheel,EngineType.withName(Engine),Cost,color)

        }
        else {
          throw new CustomException("No proper Value")
        }
  }
}


object Driver extends  App
{

  val File="C:\\Users\\Sourav\\Documents\\spark & scala\\vehicle.txt"
  val FH=io.Source.fromFile(File)
  val logger = LoggerFactory.getLogger(classOf[vehicle])
  for((i,c)<-FH.getLines().zipWithIndex)
    {
      var m=i.split(":",-1)
      try{
        vehicle.produceVehicle(m)
        logger.info(" LineNumner "+(c+1)+" : "+"Vehicle Created ["+ m.mkString(",")+ "]")
      }

      catch
        {
          case e:CustomException =>
            logger.error("LineNumner "+(c+1)+" : "+"Vehicle Creation Failed ["+ m.mkString(",")+ "]")
        }
    }
   FH.close
}
