package cafe

import org.scalatest.{MustMatchers, WordSpec}


class coffeeSpec extends WordSpec with MustMatchers {

  "Cafe" in {

    "return heatedWater temp as '40' when given water" in {
      heat(Water(20), 40) mustEqual Water(40)
    }
  }
}
