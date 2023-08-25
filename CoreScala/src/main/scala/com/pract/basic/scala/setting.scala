package com.pract.basic.scala
import com.typesafe.config._
import com.typesafe.config.ConfigFactory

trait setting {
  
  val conf=ConfigFactory.load().getString("file.name")
  
}