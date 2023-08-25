package com.pract.db.Alltable
import slick.jdbc.MySQLProfile.api._

class ee(tag:Tag) extends Table[(String,String,Int,Int,Int,Double)](tag,"ee"){
  def dt = column[String]("dt")
  def time = column[String]("time")
  def prim = column[Int]("prim")
  def sec = column[Int]("sec")
  def ter = column[Int]("ter")
  def value = column[Double]("value")
  def * = (dt,time,prim,sec,ter,value)
}
