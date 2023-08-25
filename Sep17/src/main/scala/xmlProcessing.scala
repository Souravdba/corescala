/**
  * Created by Sourav on 9/26/2017.
  */

import scala.xml

object XMLProcessing
{
  def toGrade(c:Comment,rem:String):xml.Node={
    def insertcomment=c.Remark match {
      case Some(c)=> <comment>{c}</comment>
      case None => ""
      }
    rem match{
      case "quiz" => <quiz value={c.Grade.toString}>
      {insertcomment}
      </quiz>
      case "test" => <test value={c.Grade.toString}>
        {insertcomment}
      </test>
    }
  }
  def toXML(s:Student):xml.Node={
    <student name={s.name}>
      {s.quiz.map(n=>toGrade(n,"quiz"))}
      {s.test.map(n=>toGrade(n,"test"))}
    </student>
  }
  def toComment(nn: xml.Node): Comment = {
    val Grade = (nn \ "@value").text.toInt
    val Remark = (nn \ "comment").map(_.text).toList
    val SRemark = if (Remark.isEmpty) None else Some(Remark.head)
    Comment(Grade, SRemark)
  }
  def toStudent(node: xml.Node): Student = {
    val name = (node \ "@name").text
    val quiz = (node \ "quiz").map(toComment).toList
    val tests = (node \ "test").map(toComment).toList
    new Student(name, quiz, tests)
  }
}
  case class Comment(Grade:Int,Remark:Option[String])
  class Student(val name:String,val quiz:List[Comment],val test:List[Comment]) {
  override def toString: String = "%s(%s,%s,%s)".format(this.getClass.getName, this.name,this.quiz,this.test)
  }
  object df extends App {
  val nn=xml.XML.load("C:\\Users\\Sourav\\Documents\\data\\grades.xml")
    val students=(nn\"student").map(XMLProcessing.toStudent)
    xml.XML.save("C:\\Users\\Sourav\\Documents\\data\\newfile.xml", <grading>{students.map(XMLProcessing.toXML)}</grading> )
  }
