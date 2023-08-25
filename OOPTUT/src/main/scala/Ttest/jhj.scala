package Ttest
import Ttest.tt1
trait currency
{
  def getCurrencyConvertRupees:String
}

object currencyConverter
{
  object dollarToRupee extends currency{
    override def getCurrencyConvertRupees = "60"
  }
  object EuroToRupee extends currency {
    override def getCurrencyConvertRupees = "80"
  }
  object Noidea extends currency {
    override def getCurrencyConvertRupees = "Noidea"
  }
  def apply(s:String): currency = {
    if(s=="Dollar")
      {
       dollarToRupee

      }
    else if (s=="EURO"){
      EuroToRupee
    }
    else
      {
        Noidea
      }
  }
}

object jhj extends  App{
val kk=currencyConverter("Dollar")
  val ssss=kk.getCurrencyConvertRupees
  println(ssss)
}
