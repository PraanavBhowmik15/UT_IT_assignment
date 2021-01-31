package com.knoldus.question3.Unit_Testing

import com.knoldus.question3.impl.EmailImpl
import com.knoldus.question3.validator.EmailValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestEmailValidator extends AsyncFlatSpec {
  val MockedEmailValidator: EmailValidator = mock[EmailValidator]
  val EmailId = new EmailImpl(MockedEmailValidator)

  // Unit Test Cases for Email Validation

  "Email Id " should "be Valid" in {
    when(MockedEmailValidator.emailIdIsValid("knoldus@gmail.net")) thenReturn true
    val result = EmailId.getEmailId("knoldus@gmail.net")
    assert(result == "yes")
  }

  "Email Id with wrong Recipient name " should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("!@praanav@gmail.com")) thenReturn false
    val result = EmailId.getEmailId("!@praanav@gmail.com")
    assert(result == "no")
  }

  "Email Id without @ symbol" should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("bhowmikgmail.com")) thenReturn false
    val result = EmailId.getEmailId("bhowmikgmail.com")
    assert(result == "no")
  }

  "Email Id with wrong Domain name " should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("knoldus@!gmail.com")) thenReturn false
    val result1 = EmailId.getEmailId("knoldus@!gmail.com")
    assert(result1 == "no")
  }

  "Email Id with wrong Top-Level Domain name " should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("praanav15@gmail.ccom")) thenReturn false
    val result1 = EmailId.getEmailId("praanav15@gmail.ccom")
    assert(result1 == "no")
  }

}
