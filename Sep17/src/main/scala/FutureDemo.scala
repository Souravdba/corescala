/**
  * Created by Sourav on 10/2/2017.
  */

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
//import scala.concurrent.ExecutionContext.Implicits.global

object FutureDemo {
  implicit val executor =  scala.concurrent.ExecutionContext.global

  def debug(s:String):Unit={
    val now = java.time.format.DateTimeFormatter.ISO_INSTANT
      .format(java.time.Instant.now)
      .substring(11, 23) // keep only time component
    val thread = Thread.currentThread.getName()
    println(s"$now [$thread] $s")
  }

  def taskA(): Future[Unit] = Future{
    debug("Starting taskA")
    Thread.sleep(2000)
    debug("Stopping taskA")
  }
  def taskB(): Future[Unit] = Future{
    debug("Startign taskB")
    Thread.sleep(2000)
    debug("Stoping taskB")
  }

  def main(args: Array[String]): Unit = {
    debug("This is main")
    val fuA=taskA()
    val fuB=taskB()

//    Await.result(fuA zip fuB,Duration.Inf)
    Await.result(Future.sequence(List(fuA,fuB)),Duration.Inf)
    debug("This is main")

  }
}
