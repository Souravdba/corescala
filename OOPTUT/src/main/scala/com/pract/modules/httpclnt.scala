package com.pract.modules

import akka.actor.ActorSystem
import play.api.libs.json.JsValue
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import akka.stream.ActorMaterializer
import play.api.libs.ws._
import play.api.libs.ws.ahc._
import play.api.libs.json._
import play.api.libs.ws.DefaultBodyReadables._
import play.api.libs.ws.DefaultBodyWritables._
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.JsonBodyWritables._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

/**
  * Created by Sourav on 8/26/2018.
  */
object httpclnt extends App{
  import scala.concurrent.ExecutionContext.Implicits._

  implicit val system = ActorSystem()
  system.registerOnTermination {
    System.exit(0)
  }
  implicit val materializer = ActorMaterializer()
  val wsClient = StandaloneAhcWSClient()
  val jsonBody:Future[JsValue]= wsClient.url("https://api.github.com/events").get().map { Response  ⇒
    Response.body[JsValue]

  }

  val AR=Await.result(jsonBody,Duration.Inf)
  println(AR)
  wsClient.close()
  system.terminate()

}
