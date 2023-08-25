package com.pract.modules

import play.api.libs.json._
import play.api.libs.json._
import play.api.libs.functional.syntax._


/**
  * Created by Sourav on 8/25/2018.
  */
object jsonbasic extends  App{
  val strgg="""{"items":[{"name":"Rama","Age":45},{"name":"Rama","Age":45},{"name":"Rama","Age":45}]}"""
  val sdfd="""{"name":"Rama","Age":45}"""
  case class person(name:String,age:Int)
  implicit val dfd=new Reads[person] {
    override def reads(json: JsValue) = JsSuccess(person((json\"name").as[String],(json\"Age").as[Int]))
  }

  val sdss=Json.parse(sdfd).as[person]
  println(sdss)
}
