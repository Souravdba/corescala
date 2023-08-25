/**
  * Created by Sourav on 10/19/2017.
  */

import akka.actor.Actor.Receive
import akka.actor._
class person1 extends Actor{
  def receive = {
    case "hello" => println("I recieved a hello")
    case ForceR => throw new Exception("Boom")
  }

  override def preRestart(reason: Throwable, message: Option[Any])
    {
      println("I am prerestart")
      super.preRestart(reason, message)
    }
}

case object ForceR

object ScalaActor  extends App{
  val system=ActorSystem("AS")
  val acc=system.actorOf(Props[person1],"SimpleActor")
  acc ! "hello"
//  Thread.sleep(2000)
//  println("make kenny restart")
  acc ! ForceR
  Thread.sleep(2000)
  system.terminate()
}
