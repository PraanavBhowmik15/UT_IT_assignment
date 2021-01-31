package com.knoldus.question3.validator

import com.knoldus.question3.db.CompanyReadDto

class UserValidator (companyReadDto: CompanyReadDto){
  def companyExists(company: String): Boolean = {
    if(companyReadDto.getCompanyByName(company:String).isEmpty)
      false
    else
      true
  }

  def emailIdIsValid(emailId: String): Boolean = {
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(emailId).isDefined
  }

}
