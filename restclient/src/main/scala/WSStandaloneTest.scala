/**
  * Created by Sourav on 10/2/2017.
  */

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws._
import play.api.libs.ws.ahc.AhcWSClient
import play.api.libs.iteratee.Iteratee

import scala.concurrent.Future

object WSStandaloneTest {
  import scala.concurrent.ExecutionContext.Implicits._
  def main(args: Array[String]) {
    // set up the client
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    val wsClient = AhcWSClient()

    call(wsClient)
      .andThen { case _ => wsClient.close() }
      .andThen { case _ => system.terminate() }

  }
  def call(wsClient: WSClient): Future[Unit] = {
    wsClient.url("http://www.google.com").get().map { response =>
      val statusText: String = response.statusText
      println(s"Got a response $statusText")
    }
  }

}
