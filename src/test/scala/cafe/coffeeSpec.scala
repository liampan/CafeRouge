package cafe

import org.scalatest.{MustMatchers, WordSpec}


class coffeeSpec extends WordSpec with MustMatchers {

  "Cafe" must {

    "return heatedWater temp as '40' when given water" in {

      coffee.heat(Water(20), 40) mustEqual Water(40)
    }

    "return 'GroundCoffee' when 'CoffeeBeans' given to grinder" in {

      coffee.grind(coffeeBean("ArabicaBeans")) mustEqual groundCoffee("ArabicaBeans")
    }
    "return 'not real beans' when given 'jelly beans' " in {

      val i = intercept[BeanException](coffee.grind(coffeeBean("jellyBeans")))

       i.getMessage mustEqual "jellyBeans are not accepted"
    }


    "return 'FrothedMilk' when given 'WholeMilk'" in {

      coffee.frother(milk("WholeMilk")) mustEqual frothedMilk("WholeMilk")
    }

    "return 'FrothedMilk' when given 'SkimmedMilk'" in {

      coffee.frother(milk("SkimmedMilk")) mustEqual frothedMilk("SkimmedMilk")
    }

    "return illegalArg... when given 'SemiSkimmedMilk'" in {

      val i = intercept[IllegalArgumentException](coffee.frother(milk("SemiSkimmedMilk")))

      i.getMessage mustEqual "Your milk is minging fam"


    }


    "return 'Espresso' when given 'Water', 'GroundCoffee' " in {

      coffee.brew(groundCoffee("ArabicaBeans"), Water(50)) mustEqual espresso(50)
    }

    "return 'Too cold' when given 'Water of 35' 'GroundCoffee'" in {

      val i = intercept[BrewException](coffee.brew(groundCoffee("ArabicaBeans"), Water(35)))

      i.getMessage mustEqual "The water is too cold"

    }

    "return 'Latte' when given 'espresso' and 'frothedMilk" in {
      coffee.combine(espresso(50), frothedMilk("WholeMilk")) mustEqual latte("WholeMilk", 45)
    }

    "return 'Latte(WholeMilk, 50)' when given 'ArabicaBeans, WholeMilk, 50'" in {

      coffee.barista(coffeeBean("ArabicaBeans"), milk("WholeMilk"), 50) mustEqual latte("WholeMilk", 45)
    }





  }
}
