/**
  * Created by Sourav on 10/1/2017.
  */
import akka.actor.{Actor, ActorRef, ActorSystem, PoisonPill, Props}

case class child(name:String)
case class startArmy(name:String)

class Army extends  Actor
{
  val name= "No name"
  override def receive = {
    case child(name) => println(name+"Child started")
    case _ => println("Some other msg for Army")
  }
  override def postStop {
    println(s"D'oh! They killed me ($name): ${self.path}")
  }
}

class people extends Actor
{
  override def receive = {
    case startArmy(name) =>
             val kk = context.actorOf(Props[Army],name=s"$name")
             kk ! child(name)
    case _ => println("Some other msg for parent")
  }
}



object tts extends App{
//     val Actsystem= ActorSystem("TRX")
//     val clientActor = Actsystem.actorOf(Props[client],name="clientActor")
     val system = ActorSystem("LifecycleDemo")
     val kenny = system.actorOf(Props[people], name = "Kenny")
     kenny ! startArmy("sd")
//     clientActor ! "hello"
//     Thread.sleep(1000)
        Thread.sleep(5000)
//      system.stop(kenny)
     val childsd = system.actorSelection("/user/Parent/sd")
     childsd ! PoisonPill

     Thread.sleep(5000)
     system.terminate()
}
