package cafe

import org.scalatest.{MustMatchers, WordSpec}


class coffeeSpec extends WordSpec with MustMatchers {

  "Cafe" must {

    "return heatedWater temp as '40' when given water" in {

      coffee.heat(Water(20), 40) mustEqual Water(40)
    }

    "return heatedWater temp as '40' when no temperature is given" ignore {

      coffee.heat(Water(20), 0) mustEqual Water(40)
    }

    "return 'GroundCoffee' when 'CoffeeBeans' given to grinder" in {

      coffee.grind(coffeeBean("ArabicaBeans")) mustEqual groundCoffee("ArabicaBeans")
    }

    "return 'FrothedMilk' when given 'WholeMilk'" in {

      coffee.frother(milk("WholeMilk")) mustEqual frothedMilk("WholeMilk")
    }

    "return 'Espresso' when given 'Water', 'GroundCoffee' and 'FrothedMilk'" in {

      coffee.brew(groundCoffee("ArabicaBeans"), Water(50)) mustEqual espresso(50)
    }

    "return 'Latte' when given 'espresso' and 'frothedMilk" in {
      coffee.combine(espresso(50), frothedMilk("WholeMilk")) mustEqual latte("WholeMilk", 45)
    }

    "return 'Latte(WholeMilk, 50)' when given 'ArabicaBeans, WholeMilk, 50'" in {

      coffee.barista(coffeeBean("ArabicaBeans"), milk("WholeMilk"), 50) mustEqual latte("WholeMilk", 45)
    }




  }
}
