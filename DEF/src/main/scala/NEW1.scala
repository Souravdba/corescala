/**
  * Created by Sourav on 7/11/2017.
  */
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.duration._
import scala.concurrent.{Await}
import scala.concurrent.ExecutionContext.Implicits.global

object NEW1 extends App {
  val connectionUrl = "jdbc:mysql://192.168.56.101/test?user=appsql&password=welcome"
  val db=Database.forURL(connectionUrl,driver = "com.mysql.jdbc.Driver")
  val action = sql"select statname from StateRTOCode".as[String]
  Await.result(
    db.run(action).map { res =>
      println(res)
    },60 second)

}
