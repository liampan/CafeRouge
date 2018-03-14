package cafe

case class Water(temp :Int)
case class coffeeBean(bean: String)
case class groundCoffee(bean: String)

object coffee {

  def heat(water: Water,heatTo :Int): Water ={

    Water(heatTo)
  }

  def grind(input: coffeeBean) : groundCoffee = {
    println(s"currently grinding ${input.bean}")
    Thread.sleep(1000)
    groundCoffee(input.bean)
  }

}
