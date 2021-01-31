package com.knoldus.question3.impl
import com.knoldus.question3.models.Employee
import com.knoldus.question3.validator.EmployeeValidator

class EmployeeImpl(employeeValidator: EmployeeValidator) {

  def createEmployee(employee: Employee): Option[String] = {
    if (employeeValidator.employeeIsValid(employee)) Option(employee.emailId)
    else None
  }
}