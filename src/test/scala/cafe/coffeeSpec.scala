package cafe


import org.scalatest.AsyncFlatSpec




//
//    "return illegalArg... when given 'Semi Skimmed Milk'" in {
//
//      val i = intercept[IllegalArgumentException](Coffee.milkFoam(Milk("Semi Skimmed Milk")))
//
//      i.getMessage mustEqual "That milk is not usable"

//    }
//
//    "return 'Too cold' when given 'Water of 35' 'GroundCoffee'" in {
//
//      val i = intercept[BrewException](Coffee.brew(GroundCoffee("Arabica Beans"), Water(35)))
//
//      i.getMessage mustEqual "The water is too cold"
//
//    }
//

//
//
//}
    class coffeeSpec extends AsyncFlatSpec {


  behavior of "Coffee.heat"

  it should "return heatedWater temp as '40' when given water" in {
    Coffee.heat(Water(20), 40) map { result => assert(result == Water(40))
    }
  }

  behavior of "Coffee.grind"

  it should "return 'GroundCoffee' when 'CoffeeBeans' given to grinder" in {

    Coffee.grind(CoffeeBean("Arabica Beans")) map { result => assert(result == GroundCoffee("Arabica Beans")) }
  }



  it should "return 'Jelly Beans are not accepted' when given 'Jelly Beans'" ignore  {

    assertThrows[BeanException] {
      Coffee.grind(CoffeeBean("Jelly Beans"))
    }


  }


  behavior of "Coffee.milkFoam"

  it should "return 'FrothedMilk' when given 'Whole Milk'" in {
    Coffee.milkFoam(Milk("Whole Milk")) map { result => assert(result == FrothedMilk("Whole Milk")) }
  }

  it should "return 'FrothedMilk' when given 'Skimmed Milk'" in {
    Coffee.milkFoam(Milk("Skimmed Milk")) map { result => assert(result == FrothedMilk("Skimmed Milk"))
    }
  }

behavior of "Coffee.brew"

  it should "return 'Espresso' when given 'Water', 'GroundCoffee'" in {
    Coffee.brew(GroundCoffee("Arabica Beans"), Water(50)) map { result => assert(result == Espresso(GroundCoffee("Arabica Beans"), 45))}

  }



  it should "return 'Too cold' when given 'Water(35)'  and 'GroundCoffee'" in  {


    assertThrows[BeanException]{
      Coffee.brew(GroundCoffee("Arabica Beans"), Water(35))
    }

  }


  //    "return 'Too cold' when given 'Water of 35' 'GroundCoffee'" in {
  //
  //      val i = intercept[BrewException](Coffee.brew(GroundCoffee("Arabica Beans"), Water(35)))
  //
  //      i.getMessage mustEqual "The water is too cold"
  //
  //    }


behavior of "Coffee.barista"

  it should "return 'CoffeeCup' when given 'Arabica Beans, Whole Milk, 50'" in  {

    Coffee.barista(CoffeeBean("Arabica Beans"), Milk("Whole Milk"),50) map { result => assert(result == CoffeeCup(Espresso(GroundCoffee("Arabica Beans"), 45), FrothedMilk("Whole Milk")))}
  }

}



