package com.pract.modules
import java.io.{BufferedReader, FileInputStream, FileReader}

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsValue, Json}
import resource._
import slick.jdbc.MySQLProfile.api._

import scala.collection.mutable.ListBuffer
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Try, Success, Failure}

/**
  * Created by Sourav on 8/26/2018.
  */
object jsoPrs extends App {

  case class person(id: String, firstname: String, surname: String, motivation: Option[String], share: Option[String])

  case class nobelites(year: String, category: String, laureates: List[person])

  val ff = new java.io.File("C:\\Users\\Sourav\\IdeaProjects\\OOPTUT\\src\\main\\resources\\prize.json")
  val wholeFile = scala.io.Source.fromFile(ff).mkString
  val jsddf = Json.parse(wholeFile)
  implicit val personReader = Json.reads[person]

  implicit val nobelitesReader = new Reads[nobelites] {
    override def reads(json: JsValue) = JsSuccess(nobelites((json \ "year").as[String], (json \ "category").as[String], (json \ "laureates").as[List[person]]))
  }
  val allprize = (jsddf \ "prizes").as[List[nobelites]]

  case class rownovel(year: Int, category: String, laureates_id: Long, motivation: String, share: String)

  case class rowlaurate(id: Long, firstname: String, surname: String)

  val als: ListBuffer[rownovel] = ListBuffer.empty
  val alsp: ListBuffer[rowlaurate] = ListBuffer.empty
  for (i <- allprize) {
    for (j <- i.laureates) {
      als.append(rownovel(i.year.toInt, i.category, j.id.toInt,j.motivation.getOrElse(""), j.share.getOrElse("")))
      alsp += rowlaurate((j.id).toLong, j.firstname, j.surname )

    }
  }

  val db = Database.forURL("jdbc:mysql://192.168.131.4/adb",
    driver = "com.mysql.jdbc.Driver", user = "appsql", password = "Welcome#123")

  class laureates(tag: Tag) extends Table[rowlaurate](tag, "person") {

    def id = column[Long]("id",O.PrimaryKey)

    def firstname = column[String]("firstname")

    def surname = column[String]("surname")



    def * = (id, firstname, surname).mapTo[rowlaurate]
  }

  lazy val laureatesQ = TableQuery[laureates]

  class tablenobel(tag: Tag) extends Table[rownovel](tag, "nobel") {
    def year = column[Int]("year")

    def category = column[String]("category")

    def laureates_id = column[Long]("laureates_id")

    def motivation = column[String]("motivation")

    def share = column[String]("share")

    def * = (year, category, laureates_id, motivation, share).mapTo[rownovel]

    def supplier = foreignKey("supp_fk", laureates_id, TableQuery[laureates])(_.id)
  }

  lazy val tablenobelQ = TableQuery[tablenobel]
//   val acti: DBIO[Unit] = (laureatesQ.schema ++ tablenobelQ.schema).create
  //  val resu = db.run(acti)
  //  val result = Await.result(resu, 2.seconds)

  //  alsp.foreach(println)
    import ExecutionContext.Implicits.global
    val nnewalsp=(alsp sortBy (_.id)).toSet
    val acti:DBIO[Option[Int]] = laureatesQ ++= nnewalsp
    val acti1:DBIO[Option[Int]] = tablenobelQ ++=als
    val action: DBIO[(Option[Int], Option[Int])]= for {
      result1 <- acti
      result2 <- acti1
    } yield (result1, result2)
    val resu=db.run(action)
    val result = Try(Await.result(resu, 2.minute))
    result match {
      case Success(line) => println(line)
      case Failure(e) => println(e)
}

}
