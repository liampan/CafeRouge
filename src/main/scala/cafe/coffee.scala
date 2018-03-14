package cafe

case class Water(temp :Int)

object coffee {

  def heat(water: Water,heatTo :Int): Water ={
    Water(heatTo)
  }

}
