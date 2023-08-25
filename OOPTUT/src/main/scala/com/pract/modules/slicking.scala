package com.pract.modules
import org.joda.time.Seconds
import slick.jdbc.MySQLProfile.api._

import scala.concurrent._
import scala.concurrent.duration._

/**
  * Created by Sourav on 8/25/2018.
  */
object slicking  extends  App{

  final case class eef(employee_id:Int,first_name:String,salary:Double)
  class eees(tag:Tag) extends Table[eef](tag,"eef")
  {
    def employee_id = column[Int]("employee_id")
    def first_name = column[String]("first_name")
    def salary = column[Double]("salary")
    def * = (employee_id,first_name,salary).mapTo[eef]
  }

  val db = Database.forURL("jdbc:mysql://192.168.131.4/adb?autoReconnect=true&characterEncoding=UTF-8",
    driver = "com.mysql.jdbc.Driver", user = "appsql",password= "Welcome#123")

  val eeesQ=TableQuery[eees]
  val action:DBIO[Seq[Double]] = eeesQ.filter(_.salary < 100d).map(_.salary).result
//  val action: DBIO[Unit] = eeesQ.schema.create
  val resule:Future[Seq[Double]]=db.run(action)
  val sddfd=Await.result(resule,2.seconds)
  println(sddfd)
}

