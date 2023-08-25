package com.pract.db.Alltable
import slick.jdbc.MySQLProfile.api._
import slick.driver.MySQLDriver.api._
import scala.concurrent._
import scala.concurrent.duration._

case class employee(region_id:Int,region_name:String)

object employee {
  
  class regionTable(tag:Tag) extends Table[employee](tag,"regions") {
    def id = column[Int]("region_id")
    def name = column[String]("region_name")
    def * = (id,name) <> ((employee.apply _).tupled, employee.unapply _)
//    <> ((employee.apply _).tupled, employee.unapply _)
  }
}