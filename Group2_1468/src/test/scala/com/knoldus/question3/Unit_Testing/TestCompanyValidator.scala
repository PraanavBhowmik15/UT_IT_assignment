package com.knoldus.question3.Unit_Testing

import com.knoldus.question3.impl.CompanyImpl
import com.knoldus.question3.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestCompanyValidator extends AsyncFlatSpec {
  val MockedCompanyValidator: CompanyValidator = mock[CompanyValidator]
  val Company = new CompanyImpl(MockedCompanyValidator)

  // Company should not already exists in database
  "Company " should "already not exist in database" in {
    when(MockedCompanyValidator.companyIsValid("Microsoft")) thenReturn false
    val result = Company.doCompanyExist("Microsoft")
    assert(result == "yes")
  }

  "Company " should "already exist in database" in {
    when(MockedCompanyValidator.companyIsValid("Knoldus")) thenReturn true
    val result = Company.doCompanyExist("Knoldus")
    assert(result=="no")
  }

  // Email Validation
  val MockedEmailValidation: CompanyValidator = mock[CompanyValidator]
  val Email = new CompanyImpl(MockedEmailValidation)
  "Email Id " should "be Valid" in {
    when(MockedEmailValidation.emailIdIsValid("praanav15@gmail.net")) thenReturn true
    val result = Email.getEmailId("toshima@gmail.net")
    assert(result == "valid")
  }

  "Email Id with wrong Recipient name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("@praanav@gmail.com")) thenReturn false
    val result = Email.getEmailId("!!Gupta@gmail.com")
    assert(result == "invalid")
  }

  "Email Id without @ symbol" should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("praanav15gmail.com")) thenReturn false
    val result = Email.getEmailId("toshima@gmail.com")
    assert(result == "invalid")
  }

  "Email Id with wrong Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("praanaaaaavvv@gmail.com")) thenReturn false
    val result1 = Email.getEmailId("praanav@gmail.com")
    assert(result1 == "invalid")
  }

  "Email Id with wrong Top-Level Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("praanav15@gmail.ccom")) thenReturn false
    val result1 = Email.getEmailId("praanav15@gmail.ccom")
    assert(result1 == "invalid")
  }

}
