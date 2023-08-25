/**
  * Created by Sourav on 10/2/2017.
  */
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.joda.time.Minutes
import play.api.libs.ws._
import play.api.libs.ws.ahc._
import play.api.libs.json._
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import play.api.libs.ws.DefaultBodyReadables._
import play.api.libs.ws.DefaultBodyWritables._
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.JsonBodyWritables._
object ScalaClient {
  import scala.concurrent.ExecutionContext.Implicits._

  def main(args: Array[String]): Unit = {
    // Create Akka system for thread and streaming management
    implicit val system = ActorSystem()
    system.registerOnTermination {
      System.exit(0)
    }
    implicit val materializer = ActorMaterializer()
    val wsClient = StandaloneAhcWSClient()
    val jsonBody:Future[JsValue]= wsClient.url("http://services.groupkt.com/country/get/iso2code/AM").get().map { Response  ⇒
     Response.body[JsValue]

    }

    val AR=Await.result(jsonBody,5000 millis)
    println(AR\\"messages")
    wsClient.close()
    system.terminate()

  }

//  def call(wsClient: StandaloneWSClient): Future[Unit] = {
//    val jsonBody:Future[JsValue]=wsClient.url("http://services.groupkt.com/country/get/iso2code/AM").get().map { response ⇒
////      val statusText: String = response.statusText
//      response.body[JsValue]
////      println(s"Got a response $statusText $body")
//    }
//  }
}
