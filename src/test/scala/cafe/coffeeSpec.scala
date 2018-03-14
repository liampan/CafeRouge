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




  }
}
