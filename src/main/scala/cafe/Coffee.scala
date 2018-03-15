package cafe
import scala.util.Random

case class Water(temp : Int)
case class CoffeeBean(beanType : String)
case class GroundCoffee(bean : String)
case class Milk(milkType : String)
case class FrothedMilk(fat : String)
case class Espresso(beanType : GroundCoffee, temp : Int)
case class Latte(fatFactor : String, temp : Int)

case class BeanException(msg : String) extends Exception(msg)
case class BrewException(msg : String) extends Exception(msg)


object Coffee extends App {

  def heat(water : Water, heatTo : Int) : Water = {
    Thread.sleep(Random.nextInt(3000))
    water.copy(heatTo)
  }

  def grind(beanInput : CoffeeBean) : GroundCoffee = {
    lazy val grinder = {
      println(s"currently grinding ${beanInput.beanType}")
      Thread.sleep(Random.nextInt(1000))
      GroundCoffee(beanInput.beanType)}
    beanInput.beanType match {
      case "Arabica Beans" => grinder
      case "Italian Beans" => grinder
      case _ => throw BeanException(s"${beanInput.beanType} are not accepted")
    }

  }

  def milkFoam(milkInput : Milk) : FrothedMilk = {
    lazy val foam = {println(s"frothing ${milkInput.milkType}")
      Thread.sleep(Random.nextInt(1000))
      FrothedMilk(milkInput.milkType)}
    milkInput.milkType match {
      case "Whole Milk" => foam
      case "Skimmed Milk" => foam
      case _ => throw new IllegalArgumentException("That milk is not usable")
    }

  }

  def brew(coffee : GroundCoffee, water : Water) : Espresso = {
  if (water.temp <40) {throw BrewException("The water is too cold")}
  else {Thread.sleep(Random.nextInt(1000))
    Espresso(coffee, water.temp)}
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
    println(s"You have brewed the following coffee: Coffee made with ${bean.beanType} at $temp degrees with ${milk.milkType}")

    combine(shot, foam)
  }

}
