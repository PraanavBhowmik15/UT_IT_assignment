package com.knoldus.question3.validator

import com.knoldus.question3.models.{Company, Employee}
import com.knoldus.question3.db.CompanyReadDto

class EmployeeValidator (companyReadDto: CompanyReadDto){

  def employeeIsValid(employee: Employee): Boolean  = ???

}
