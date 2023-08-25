/**
  * Created by Sourav on 10/2/2017.
  */
import slick.jdbc.MySQLProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
class slickdemo {

}

  object tg extends App{
    val db = Database.forURL("jdbc:mysql://192.168.56.101/test?autoReconnect=true&characterEncoding=UTF-8",
      driver = "com.mysql.jdbc.Driver", user = "appsql",password= "welcome")
    class Book(tag: Tag) extends Table[(Int,String, String)](tag, "books") {
      def id = column[Int]("id",O.PrimaryKey,O.AutoInc)
      def name = column[String]("title")
      def isbn = column[String]("isbn")
      def * = (id,name, isbn)
      def isbnrel = foreignKey("AUTHOR",isbn,authors)(_.isbn)
    }
    lazy val books = TableQuery[Book]


    class Authors(tag: Tag) extends Table[(String,String)](tag,"author") {
      def isbn = column[String]("isbn",O.PrimaryKey)
      def company = column[String]("company")
      def * = (isbn,company)
    }
    lazy  val authors = TableQuery[Authors]


    val bookname: Future[MySQLProfile.InsertActionExtensionMethods[(String,String)]#SingleInsertResult] = db.run(
      books.map(b => (b.isbn,b.name)) +=("wfrf45","The Spy")
    )
    val bookList:MySQLProfile.InsertActionExtensionMethods[(String,String)]#SingleInsertResult = Await.result(bookname,1.minute)
    print(bookList)

}