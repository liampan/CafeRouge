package cafe

import org.scalatest.{MustMatchers, WordSpec}


class coffeeSpec extends WordSpec with MustMatchers {

  "Cafe" must {

    "return heatedWater temp as '40' when given water" in {

      Coffee.heat(Water(20), 40) mustEqual Water(40)
    }

    "return 'GroundCoffee' when 'CoffeeBeans' given to grinder" in {

      Coffee.grind(CoffeeBean("Arabica Beans")) mustEqual GroundCoffee("Arabica Beans")
    }
    "return 'not real beans' when given 'jelly beans' " in {

      val i = intercept[BeanException](Coffee.grind(CoffeeBean("Jelly Beans")))

       i.getMessage mustEqual "Jelly Beans are not accepted"
    }


    "return 'FrothedMilk' when given 'Whole Milk'" in {

      Coffee.milkFoam(Milk("Whole Milk")) mustEqual FrothedMilk("Whole Milk")
    }

    "return 'FrothedMilk' when given 'Skimmed Milk'" in {

      Coffee.milkFoam(Milk("Skimmed Milk")) mustEqual FrothedMilk("Skimmed Milk")
    }

    "return illegalArg... when given 'Semi Skimmed Milk'" in {

      val i = intercept[IllegalArgumentException](Coffee.milkFoam(Milk("Semi Skimmed Milk")))

      i.getMessage mustEqual "That milk is not usable"


    }


    "return 'Espresso' when given 'Water', 'GroundCoffee' " in {

      Coffee.brew(GroundCoffee("Arabica Beans"), Water(50)) mustEqual Espresso(GroundCoffee("Arabica Beans"),50)
    }

    "return 'Too cold' when given 'Water of 35' 'GroundCoffee'" in {

      val i = intercept[BrewException](Coffee.brew(GroundCoffee("Arabica Beans"), Water(35)))

      i.getMessage mustEqual "The water is too cold"

    }

    "return 'Latte' when given 'espresso' and 'frothedMilk" in {
      Coffee.combine(Espresso(GroundCoffee("Arabica Beans"), 50), FrothedMilk("Whole Milk")) mustEqual Latte("Whole Milk", 45)
    }

    "return 'Latte(Whole Milk, 50)' when given 'Arabica Beans, Whole Milk, 50'" in {

      Coffee.barista(CoffeeBean("Arabica Beans"), Milk("Whole Milk"), 50) mustEqual Latte("Whole Milk", 45)
    }






  }
}
