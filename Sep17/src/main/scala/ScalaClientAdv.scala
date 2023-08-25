/**
  * Created by Sourav on 10/2/2017.
  */

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws._
import play.api.libs.ws.ahc._
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
object ScalaClientAdv {
  import scala.concurrent.ExecutionContext.Implicits._

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    system.registerOnTermination { System.exit(0) }
    implicit val materializer = ActorMaterializer()

    val wsClient = StandaloneAhcWSClient()
    def fetchOrFailClient = fetchOrFail(wsClient)_

    val attempt = for (
      step1 <- fetchOrFailClient(Left("foo"));
      step2 <- fetchOrFailClient(step1);
      step3 <- fetchOrFailClient(step2)
    ) yield step3

    attempt.onComplete(result => {
      process(result)
      shutdown(system,wsClient)
    })
  }
  def process(result: Try[Either[String,String]]) = result match {
    case Success(value) => {
      value match {
        case Left(result) => println(s"Retrieved $result from server")
        case Right(error) => println(s"Error: $error")
      }
    }
    case Failure(ex) => println("Damn you Network!!!")
  }
  def fetchOrFail(client: StandaloneWSClient)(input: Either[String,String]): Future[Either[String,String]] = {
    val rootUrl = "http://services.groupkt.com/country/get/iso2code/AU"
    return client.url(rootUrl + input.left).get().map(resp => resp.status match {
      case 200 => Left(resp.body)
      case _ => Right("Damn you Tara!!!")
    })
  }
  private def shutdown(system: ActorSystem, wsClient: StandaloneAhcWSClient) = {
    wsClient.close()
    system.terminate()
  }

}
