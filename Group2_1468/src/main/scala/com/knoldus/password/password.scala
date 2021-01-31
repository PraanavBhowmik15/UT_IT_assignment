package com.knoldus.password

class password(word : String) {
  def isValidPassword: Boolean = {
    var wordList = List.empty[Char]       //creating an empty character list
    //making four boolean variable to check values
    for (i <- word) wordList :+= i       //converting the string password into a character list
    var isSpecial : Boolean = false       //to check for special character
    var isSmall : Boolean = false         //to check for lowercase letter
    var isCapital : Boolean = false       //to check for uppercase letter
    var isNumber : Boolean = false        //to check for number
    var isSpace : Boolean = true
    val len: Int = wordList.length        //finding length of character list
    if(len >= 8 && len <=15) {            //Checking if password is within range of 8 to 15
      for (i <- wordList) {

          if(i == '@' || i == "#" || i == "%" || i == '&' || i == '!' || i == '$')       //checking for special character
            isSpecial = true
          if(i >= 'a' && i <= 'z')                                                       //checking for lowercase
            isSmall = true
          if(i >= 'A' && i <= 'Z')                                                       //checking for uppercase
            isCapital = true
          if(i >= '1' && i <= '9')                                                       //checking for number
            isNumber = true
          if(i == ' ')                                                                   //checking for spaces
            isSpace = false
        }
      }
    if(isCapital && isNumber && isSmall && isSpecial && isSpace)       //if all cases are true then return true
      true
    else
      false
  }
}
