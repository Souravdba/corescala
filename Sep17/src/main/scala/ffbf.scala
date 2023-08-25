/**
  * Created by Sourav on 9/18/2017.
  */
class person(var name:String,var age:Int)
{
  def this()
  {
    this("xxxx",33)
  }
  var acnt:Int=_
  def myemail:String = return s"${name+'.'+age}@gmail.com"

}
class employee(name:String,age:Int,var emplyer:String) extends person(name,age)
{
  acnt=29019
  def this(name:String,age:Int)
  {
    this(name,age,"UNKN");
  }
  def this(name:String)
  {
    this(name,18)
  }

  def myemail(efd:String) { return s"${name+'.'+age+'@'+emplyer} "}
}
object ffbf {
  def main(args: Array[String]): Unit = {
    var pee=new person{ var emplyer="sdsds"}
    print(pee.emplyer)
  }
}
