package com.knoldus.factorial

class factorial (number : Int) extends factorialImpl {
  def isFactorial: Int = {
    var fact = 1
    for(i <- 1 to number)        //iterating till the number is reached
      fact = fact * i
    fact
  }
}
