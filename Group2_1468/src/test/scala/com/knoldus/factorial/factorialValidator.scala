package com.knoldus.factorial

import org.scalatest.flatspec.AnyFlatSpec

class factorialValidator extends AnyFlatSpec {
  "The result " should " is factorial" in {
    val fact = new factorial(number = 5)
    val result = fact.isFactorial
    assertResult(120)(result)
  }

}
