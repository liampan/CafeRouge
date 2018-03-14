package cafe

import scala.util.Random

case class Water(temp :Int)
case class coffeeBean(bean: String)
case class groundCoffee(bean: String)
case class milk(fatFactor : String)
case class frothedMilk(fat: String)
case class espresso(temp :Int)
case class latte(fatFactor: String, temp: Int)

case class BeanException(msg: String) extends Exception(msg)
case class BrewException(msg: String) extends Exception(msg)


object coffee {

  def heat(water: Water,heatTo:Int ): Water ={
    Thread.sleep(Random.nextInt(3000))
    Water(heatTo)
  }

  def grind(input: coffeeBean) : groundCoffee = {
    lazy val grindr = {
      println(s"currently grinding ${input.bean}")
      Thread.sleep(Random.nextInt(1000))
      groundCoffee(input.bean)}
    input.bean match {
      case "ArabicaBeans" => grindr
      case "italianBean" => grindr
      case _ => throw BeanException(s"${input.bean} are not accepted")
    }

  }

  def frother(input: milk) : frothedMilk = {
    lazy val frothr = {println(s"frothing ${input.fatFactor}")
      Thread.sleep(Random.nextInt(1000))
      frothedMilk(input.fatFactor)}
    input.fatFactor match {
      case "WholeMilk" => frothr
      case "SkimmedMilk" => frothr
      case _ => throw new IllegalArgumentException("Your milk is minging fam")
    }

  }

  def brew(coffee: groundCoffee, water: Water) : espresso = {
  if (water.temp <40) {throw BrewException("The water is too cold")}
  else {Thread.sleep(Random.nextInt(1000))
    espresso(water.temp)}
  }

  def combine(espresso: espresso, milk : frothedMilk) : latte = {
    Thread.sleep(Random.nextInt(1000))
    latte(milk.fat,espresso.temp-5)
  }

  def barista(bean: coffeeBean, milk: milk, temp: Int) : latte = {
    val hotwater = heat(Water(20),temp)
    val grinded = grind(bean)
    val foam = frother(milk)
    val shot = brew(grinded,hotwater)
    combine(shot,foam)
  }

}
