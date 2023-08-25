package basic.pract

/**
  * Created by Sourav on 7/20/2018.
  */

final case class CustomException(private val message: String = "",
                                 private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
object tstin extends  App{

  val sss="hello world"
  print("ssss")
  try{
    if(sss.length > 5)
    {
      throw new CustomException("Some Error")
    }
    else
      {
        println("OKK")
      }
  }
  catch {
    case e:CustomException=>println(e)
  }



}
