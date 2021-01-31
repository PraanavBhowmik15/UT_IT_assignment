package com.knoldus.password

import org.scalatest.flatspec.AnyFlatSpec
class passwordValidator extends AnyFlatSpec {
  "The password" should "is valid" in {
    val valid = new password(word = "Knoldus@1234")
    assert(valid.isValidPassword)
  }
  "The password" should "is missing number and special character" in {
    val valid = new password(word = "MynameisPraanav")
    assert(!valid.isValidPassword)
  }
  "The password" should " should not contain spaces" in {
    val valid = new password(word = "Hello@ Scala123")
    assert(!valid.isValidPassword)
  }
  "The password" should " is missing capital letter and special character" in {
    val valid = new password(word = "helloworld123")
    assert(!valid.isValidPassword)
  }
  "The password" should "is missing special character" in {
    val valid = new password(word = "Knoldus123")
    assert(!valid.isValidPassword)
  }
  "The password" should "is missing number" in {
    val valid = new password(word = "Knoldus@&")
    assert(!valid.isValidPassword)
  }
  "The password" should "is too longr" in {
    val valid = new password(word = "Praaaaaaaaanaaav@1548641")
    assert(!valid.isValidPassword)
  }
  "The password" should "is too short" in {
    val valid = new password(word = "Knol@12")
    assert(!valid.isValidPassword)
  }



}
