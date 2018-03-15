package cafe
import scala.util.Random

case class Water(temp : Int)
case class CoffeeBean(bean : String)
case class GroundCoffee(bean : String)
case class Milk(fatFactor : String)
case class FrothedMilk(fat : String)
case class Espresso(temp : Int)
case class Latte(fatFactor : String, temp : Int)

case class BeanException(msg : String) extends Exception(msg)
case class BrewException(msg : String) extends Exception(msg)


object Coffee extends App {

  def heat(water : Water, heatTo : Int) : Water = {
    Thread.sleep(Random.nextInt(3000))
    water.copy(heatTo)
  }

  def grind(input : CoffeeBean) : GroundCoffee = {
    lazy val grinder = {
      println(s"currently grinding ${input.bean}")
      Thread.sleep(Random.nextInt(1000))
      GroundCoffee(input.bean)}
    input.bean match {
      case "ArabicaBeans" => grinder
      case "ItalianBeans" => grinder
      case _ => throw BeanException(s"${input.bean} are not accepted")
    }

  }

  def milkFoam(input : Milk) : FrothedMilk = {
    lazy val foam = {println(s"frothing ${input.fatFactor}")
      Thread.sleep(Random.nextInt(1000))
      FrothedMilk(input.fatFactor)}
    input.fatFactor match {
      case "WholeMilk" => foam
      case "SkimmedMilk" => foam
      case _ => throw new IllegalArgumentException("That milk is not usable")
    }

  }

  def brew(coffee : GroundCoffee, water : Water) : Espresso = {
  if (water.temp <40) {throw BrewException("The water is too cold")}
  else {Thread.sleep(Random.nextInt(1000))
    Espresso(water.temp)}
  }

  def combine(espresso : Espresso, milk : FrothedMilk) : Latte = {
    Thread.sleep(Random.nextInt(1000))
    Latte(milk.fat, espresso.temp-5)
  }

  def barista(bean: CoffeeBean, milk: Milk, temp: Int) : Latte = {
    val hotWater = heat(Water(20), temp)
    val ground = grind(bean)
    val foam = milkFoam(milk)
    val shot = brew(ground,hotWater)
    combine(shot, foam)
  }
}
