package cafe

case class Water(temp :Int)
case class coffeeBean(bean: String)
case class groundCoffee(bean: String)
case class milk(fatFactor : String)
case class frothedMilk(fat: String)
case class espresso(temp :Int)
case class latte(fatFactor: String, temp: Int)

object coffee {

  def heat(water: Water,heatTo :Int): Water ={

    Water(heatTo)
  }

  def grind(input: coffeeBean) : groundCoffee = {
    println(s"currently grinding ${input.bean}")
    Thread.sleep(1000)
    groundCoffee(input.bean)
  }

  def frother(input: milk) : frothedMilk = {

    frothedMilk(input.fatFactor)
  }

  def brew(coffee: groundCoffee, water: Water) : espresso = {

  espresso(water.temp)
  }

  def combine(espresso: espresso, milk : frothedMilk) : latte = {

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
