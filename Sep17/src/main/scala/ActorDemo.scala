/**
  * Created by Sourav on 10/19/2017.
  */
import akka.actor.Actor.Receive
import akka.actor._
import scala.concurrent.duration._

case class user(name:String,age:Int)
case object Forcerestart

class customvalidator extends  Actor{
  override def preStart(): Unit = {println("Called before start")}

  override def postStop(): Unit = {println("Called after stop")}
  override def preRestart(reason: Throwable, message: Option[Any]) {
    super.preRestart(reason, message)
    println("kenny: preRestart")
    println(s" MESSAGE: ${message.getOrElse("")}")
    println(s" REASON: ${reason.getMessage}")

  }

  def receive={
    case n:user => if (n.age > 20) println("PASSED") else println("Not Passed")
    case Forcerestart =>   println("Force restart requested")
//                           val k=10/0
                           throw new IllegalStateException
    case _ => println("Not a valid customer")
  }
}
object ActorDemo extends App{
  val user1=user("Hari",12)
  val system = ActorSystem("FirstAS")
  val customerActor=system.actorOf(Props[customvalidator],name = "CustomerValidator")
  customerActor ! user1

  customerActor ! Forcerestart
  Thread.sleep(1000)
  system.terminate()

}
