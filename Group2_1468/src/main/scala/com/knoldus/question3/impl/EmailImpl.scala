package com.knoldus.question3.impl
import com.knoldus.question3.validator.EmailValidator

class EmailImpl (emailValidator: EmailValidator){

  val VerifiedEmail = "yes"
  val UnVerifiedEmail = "no"

  def getEmailId(email  :String) :String = {
    if(emailValidator.emailIdIsValid(email)) {
      println("Valid Email Id")
      VerifiedEmail
    }
    else {
      println("InValid Email Id")
      UnVerifiedEmail
    }
  }

}
