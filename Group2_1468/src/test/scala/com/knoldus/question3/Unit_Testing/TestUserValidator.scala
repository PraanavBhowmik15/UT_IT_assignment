package com.knoldus.question3.Unit_Testing

import com.knoldus.question3.impl.UserImpl
import com.knoldus.question3.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestUserValidator extends AsyncFlatSpec {

  val MockedCompanyValidator: UserValidator = mock[UserValidator]
  val Company = new UserImpl(MockedCompanyValidator)

  // Checks if company exists in database
  "Company " should "exist in database" in {
    when(MockedCompanyValidator.companyExists("Knoldus")) thenReturn true
    val result = Company.doCompanyExist("Knoldus")
    assert(result == "yes")
  }

  "Company " should "not exist in database" in {
    when(MockedCompanyValidator.companyExists("Microsoft")) thenReturn false
    val result = Company.doCompanyExist("Microsoft")
    assert(result=="no")
  }

  // Email Validation
  val MockedEmailValidation: UserValidator = mock[UserValidator]
  val Email = new UserImpl(MockedEmailValidation)
  "Email Id " should "be Valid" in {
    when(MockedEmailValidation.emailIdIsValid("praanav15@gmail.net")) thenReturn true
    val result = Email.getEmailId("praanav15@gmail.net")
    assert(result == "valid")
  }

  "Email Id with wrong Recipient name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("!praa@av@gmail.com")) thenReturn false
    val result = Email.getEmailId("!praa@av@gmail.com")
    assert(result == "invalid")
  }

  "Email Id without @ symbol" should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("praanavgmail.com")) thenReturn false
    val result = Email.getEmailId("praanavgmail.com")
    assert(result == "invalid")
  }

  "Email Id with wrong Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("praanav@!gmail.com")) thenReturn false
    val result1 = Email.getEmailId("praanav@!gmail.com")
    assert(result1 == "invalid")
  }

  "Email Id with wrong Top-Level Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("praanav@gmail.ccom")) thenReturn false
    val result1 = Email.getEmailId("praanav@gmail.ccom")
    assert(result1 == "invalid")
  }

}
