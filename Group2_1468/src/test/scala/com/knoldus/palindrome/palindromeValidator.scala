package com.knoldus.palindrome

import org.scalatest.flatspec.AnyFlatSpec

class palindromeValidator extends AnyFlatSpec {
  "The number" should " is Palindrome number" in {
    val palin = new palindrome(number = 101)
    assert(palin.isPalindrome)
  }
  "The number" should " is also Palindrome number" in {
    val palin = new palindrome(number = 10145)
    assert(!palin.isPalindrome)
  }
}
