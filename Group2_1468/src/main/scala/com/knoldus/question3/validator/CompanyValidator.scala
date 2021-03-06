package com.knoldus.question3.validator

import com.knoldus.question3.db.CompanyReadDto

class CompanyValidator (companyReadDto: CompanyReadDto){

  def companyIsValid(company: String): Boolean = {
    if(!companyReadDto.getCompanyByName(company:String).isEmpty)
      true
    else
      false
  }

  def emailIdIsValid(emailId: String): Boolean = {
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(emailId).isDefined
  }

}