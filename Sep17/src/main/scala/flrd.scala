/**
  * Created by Sourav on 9/24/2017.
  */
import slick.jdbc.MySQLProfile.api._
import scala.concurrent._
import scala.concurrent.duration._

object flrd  extends App{
  val db = Database.forURL("jdbc:mysql://192.168.56.101/test?autoReconnect=true&characterEncoding=UTF-8",
    driver = "com.mysql.jdbc.Driver", user = "appsql",password= "welcome")
  val getUUID = sql"""select id,title from books""".as[(Int,String)]
  val uuidFuture:Future[Seq[(Int,String)]]  = db.run(getUUID)
  val uuid:Seq[(Int,String)] = Await.result(uuidFuture, Duration.Inf)
  uuid.foreach(println)
}
