/**
  * Created by Sourav on 9/27/2017.
  */

import play.api.libs.json._
import play.api.libs.functional.syntax._

class jsonProcessing {

}
object jsoning extends  App{
  val json: JsValue = Json.parse("""
{
  "name" : "Watership Down",
  "location" : {
    "lat" : 51.235685,
    "long" : -1.309197
  },
  "residents" : [ {
    "name" : "Fiver",
    "age" : 4,
    "role" : null
  }, {
    "name" : "Bigwig",
    "age" : 6,
    "role" : "Owsla"
  } ]
}
""")

  val name = (json \ "name").as[String]
  print(name)

//  val jsonString = Json.stringify(json)
//  println(jsonString)
//  case class K(name: String, age: Int)
//  implicit val kl = Json.format[K]
////  print(userFormat)
//  val userList = List(K("Example 1", 20), K("Example 2", 42))
//  val users = Json.obj("users" -> userList)
//  println(users)

}
