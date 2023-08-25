package com.pract.basic.scala
import slick.jdbc.MySQLProfile.api._
import slick.driver.MySQLDriver.api._
import scala.concurrent._
import scala.concurrent.duration._
import com.pract.db.Alltable.employee.regionTable



object td1 extends App {
  val db = Database.forURL("jdbc:mysql://192.168.131.3/hr?autoReconnect=true&characterEncoding=UTF-8",
    driver = "com.mysql.jdbc.Driver", user = "scott", password = "tiger")
  val region=TableQuery[regionTable]
  val regionName:Future[Seq[(String,Int)]]=db.run(
    region.map(x=>(x.name,x.id)).result  
  )
  val regionNamelist:List[(String,Int)]=Await.result(regionName, 1.minute).toList
  print(regionNamelist)
}