package com.knoldus.palindrome

class palindrome(number : Int) extends palindromeImpl {
  def isPalindrome: Boolean = {
    val str = number.toString            //converting the number to string
    val reverse = str.reverse            //reversing the string number
    if(str == reverse)                   //if both number and reversed number are same then return true
      true
    else
      false
  }
}
