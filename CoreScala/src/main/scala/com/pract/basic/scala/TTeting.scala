package com.pract.basic.scala
import slick.jdbc.MySQLProfile.api._
import resource._
import java.io._
import scala.concurrent._
import scala.concurrent.duration._
import com.pract.db.Alltable._
import com.pract.db.Alltable.ee
import slick.jdbc.MySQLProfile

object TTeting extends App {

  val db = Database.forURL("jdbc:mysql://192.168.131.3/test?autoReconnect=true&characterEncoding=UTF-8",
    driver = "com.mysql.jdbc.Driver", user = "scott", password = "tiger")
  val ee = TableQuery[ee]
  try {
    import scala.concurrent.ExecutionContext.Implicits.global
     Await.result(db.run(ee += ("wfrf45","The Spy",45,45,45,565.56)),Duration.Inf)
    
  } finally db.close()
  //  var ss: Option[String] = None
  //  for (input <- resource.managed(new BufferedReader(new java.io.FileReader("C:\\Users\\Sourav\\Documents\\data\\orders.txt")))) {
  //    ss = Option(input.readLine())
  //    while (ss != None) {
  //      println(ss.get)
  //      ss = Option(input.readLine())
  //    }
  //
  //  }

}