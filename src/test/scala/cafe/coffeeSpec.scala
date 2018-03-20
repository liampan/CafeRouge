package cafe


import org.scalatest.AsyncFlatSpec


//
//    "return 'not real beans' when given 'jelly beans' " in {
//
//      val i = intercept[BeanException](Coffee.grind(CoffeeBean("Jelly Beans")))
//
//      i.getMessage mustEqual "Jelly Beans are not accepted"
//    }

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
    Coffee.brew(GroundCoffee("Arabica Beans"), Water(50)) map { result => assert(result == Espresso(GroundCoffee("Arabica Beans"), 50))}

  }

behavior of "Coffee.combine"

  it should "return 'Latte' when given 'espresso' and 'frothedMilk" in {
    Coffee.combine(Espresso(GroundCoffee("Arabica Beans"), 50), FrothedMilk("Whole Milk")) map { result => assert(result == Latte("Whole Milk", 45))}
  }




//behavior of "Coffee.barista"
//
//  it should "return 'CoffeeCup' when given 'Arabica Beans, Whole Milk, 50'" ignore  {
//
//    Coffee.barista(CoffeeBean("Arabica Beans"), Milk("Whole Milk"),50) map { result => assert(result == CoffeeCup(, FrothedMilk)}
//  }
//





//  "return 'Latte(Whole Milk, 50)' when given  in {
    //
    //      Coffee.barista(CoffeeBean("Arabica Beans"), Milk("Whole Milk"), 50) mustEqual Latte("Whole Milk", 45)
    //    }
    //  }
}




//  behavior of "Coffee.barista"
//
//
//      it should "return a valid Coffee with the input 'Coffee.barista(CoffeeBean('Arabica Beans'), Milk('Whole Milk'), 50)'" ignore {
////       val finishedCoffee = Coffee.barista(CoffeeBean("Arabica Beans"), Milk("Whole Milk"), 50)
//
//        Coffee.barista(CoffeeBean("Arabica Beans"), Milk("Whole Milk"), 50) map   {result => assert(result == "You have brewed the following coffee: Coffee made with Arabica Beans at 50 degrees with Whole Milk")
//        }
//      }




