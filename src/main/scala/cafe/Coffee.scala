package cafe
import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

case class Water(temp : Int)
case class CoffeeBean(beanType : String)
case class GroundCoffee(bean : String)
case class Milk(milkType : String)
case class FrothedMilk(fat : String)
case class Espresso(beanType : GroundCoffee, temp : Int)
case class CoffeeCup(shot : Espresso, frothedMilk : FrothedMilk)

case class BeanException(msg : String) extends Exception
case class BrewException(msg : String) extends Exception


object Coffee extends App {

  implicit def ec : ExecutionContext = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())


  def heat(water : Water, heatTo : Int) : Future[Water] = Future {
    Thread.sleep(Random.nextInt(1000))
    water.copy(heatTo)
  }

  def grind(beanInput : CoffeeBean) : Future[GroundCoffee] = Future {

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

  def milkFoam(milkInput : Milk) : Future[FrothedMilk] = Future {

    lazy val foam = {println(s"frothing ${milkInput.milkType}")
      Thread.sleep(Random.nextInt(1000))
      FrothedMilk(milkInput.milkType)}

    milkInput.milkType match {
      case "Whole Milk" => foam
      case "Skimmed Milk" => foam
      case "no Milk" => foam
      case _ => throw new IllegalArgumentException("That milk is not usable")
    }

  }

  def brew(coffee : GroundCoffee, water : Water) : Future[Espresso] = Future {

  if (water.temp >=40) throw {BrewException("The water is too cold")}

  else {Thread.sleep(Random.nextInt(1000))
    Espresso(coffee, water.temp-5)}
  }


  def barista(bean: CoffeeBean, milk: Milk, temp: Int) : Future[CoffeeCup] = {

    val hotWater = heat(Water(20), temp)
    val ground = grind(bean)
    val foam = milkFoam(milk)

    println(s"You have brewed the following coffee: Coffee made with ${bean.beanType} at $temp degrees with ${milk.milkType}")

    for {
      water <- hotWater
      frothedMilk <- foam
      groundCoffee <- ground
      shot <- brew(groundCoffee,water)
    } yield {
      CoffeeCup(shot, frothedMilk)
    }


  }
barista(CoffeeBean("Jelly Beans"), Milk("Cashew Milk"), 50)
}
