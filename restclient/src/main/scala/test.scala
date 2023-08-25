/**
  * Created by Sourav on 10/1/2017.
  */

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.typesafe.sslconfig.ssl.SystemConfiguration
import com.typesafe.sslconfig.ssl.debug.DebugConfiguration
import play.api._
import play.api.libs.ws._
import play.api.libs.ws.ahc._
import play.api.libs.ws.ahc.AhcWSClient
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import play.api.libs.ws.ahc.AhcWSClientConfigFactory
import com.typesafe.config._
import scala.concurrent.Future
import java.io._
import org.asynchttpclient.AsyncHttpClientConfig
import play.shaded.ahc.org.asynchttpclient.uri.Uri
import play.shaded.ahc.org.asynchttpclient.{ Response => AHCResponse, _ }
import com.typesafe.config.Config



object test extends App {

  import scala.concurrent.ExecutionContext.Implicits._
  def call(wsClient: StandaloneWSClient): Future[Unit] = {
    wsClient.url("http://www.google.com").get().map { response =>
      val statusText: String = response.statusText
      println(s"Got a response $statusText")
    }

  }

  implicit val system = ActorSystem()
  system.registerOnTermination {
    System.exit(0)
  }
  implicit val materializer = ActorMaterializer()
  AhcWSClientConfigFactory.forConfig(ConfigFactory.load)
  val wsClient = StandaloneAhcWSClient()
  call(wsClient)
    .andThen { case _ => wsClient.close() }
    .andThen { case _ => system.terminate() }
}
