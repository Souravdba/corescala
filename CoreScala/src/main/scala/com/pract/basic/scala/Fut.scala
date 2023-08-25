package com.pract.basic.scala
import java.time.LocalDateTime;
import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, Future }
import scala.concurrent.ExecutionContext.Implicits.global

object Prog {
  def taskA(): Future[Unit] = Future {
    debug("Starting Task A ")
    Thread.sleep(5000)
    debug("Ending Task A ")
  }
  def taskB(): Future[Unit] = Future {
    debug("Starting Task B ")
    Thread.sleep(5000)
    debug("Ending Task B ")
  }

  def taskC(): Future[Unit] = Future {
    debug("Starting Task C ")
    Thread.sleep(5000)
    debug("Ending Task C ")
  }

  def debug(msg: String) = {
    val time = LocalDateTime.now()
    val thdname = Thread.currentThread().getName()
    println(time + " [" + thdname + "] " + msg)
  }
}

object Fut extends App {
  Prog.debug("Starting Main")
  val a=Prog.taskA()
  val b=Prog.taskB()
  val c=Prog.taskC()
  Await.result(a zip b, Duration.Inf)
}