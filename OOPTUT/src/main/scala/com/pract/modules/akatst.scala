package com.pract.modules
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
  * Created by Sourav on 8/26/2018.
  */
object akatst extends App{
 class simepleActor extends Actor
  {
   def receive={
     case s:String => println(s)
     case i:Int => println(i)
   }
    def foo=println("sdsd")
  }

  val system=ActorSystem("Simplesystem")

  val acto=system.actorOf(Props[simepleActor],"SA")

  acto ! "hello"

  system.terminate()

}
