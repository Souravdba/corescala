package com.pract.db.Alltable
import slick.jdbc.MySQLProfile.api._

class job(tag:Tag) extends Table[(String,String,Long,Long)](tag,"jobs"){
  def job_id = column[String]("job_id")
  def job_title = column[String]("job_title")
  def min_salary = column[Long]("min_salary")
  def max_salary = column[Long]("max_salary")
  def * = (job_id,job_title,min_salary,max_salary)
}

