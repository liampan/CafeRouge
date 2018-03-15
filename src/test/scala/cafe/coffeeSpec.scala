package cafe

import org.scalatest.{MustMatchers, WordSpec}


class coffeeSpec extends WordSpec with MustMatchers {

  "Cafe" must {

    "return heatedWater temp as '40' when given water" in {

      Coffee.heat(Water(20), 40) mustEqual Water(40)
    }

    "return 'GroundCoffee' when 'CoffeeBeans' given to grinder" in {

      Coffee.grind(CoffeeBean("ArabicaBeans")) mustEqual GroundCoffee("ArabicaBeans")
    }
    "return 'not real beans' when given 'jelly beans' " in {

      val i = intercept[BeanException](Coffee.grind(CoffeeBean("jellyBeans")))

       i.getMessage mustEqual "jellyBeans are not accepted"
    }


    "return 'FrothedMilk' when given 'WholeMilk'" in {

      Coffee.milkFoam(Milk("WholeMilk")) mustEqual FrothedMilk("WholeMilk")
    }

    "return 'FrothedMilk' when given 'SkimmedMilk'" in {

      Coffee.milkFoam(Milk("SkimmedMilk")) mustEqual FrothedMilk("SkimmedMilk")
    }

    "return illegalArg... when given 'SemiSkimmedMilk'" in {

      val i = intercept[IllegalArgumentException](Coffee.milkFoam(Milk("SemiSkimmedMilk")))

      i.getMessage mustEqual "That milk is not usable"


    }


    "return 'Espresso' when given 'Water', 'GroundCoffee' " in {

      Coffee.brew(GroundCoffee("ArabicaBeans"), Water(50)) mustEqual Espresso(50)
    }

    "return 'Too cold' when given 'Water of 35' 'GroundCoffee'" in {

      val i = intercept[BrewException](Coffee.brew(GroundCoffee("ArabicaBeans"), Water(35)))

      i.getMessage mustEqual "The water is too cold"

    }

    "return 'Latte' when given 'espresso' and 'frothedMilk" in {
      Coffee.combine(Espresso(50), FrothedMilk("WholeMilk")) mustEqual Latte("WholeMilk", 45)
    }

    "return 'Latte(WholeMilk, 50)' when given 'ArabicaBeans, WholeMilk, 50'" in {

      Coffee.barista(CoffeeBean("ArabicaBeans"), Milk("WholeMilk"), 50) mustEqual Latte("WholeMilk", 45)
    }





  }
}
