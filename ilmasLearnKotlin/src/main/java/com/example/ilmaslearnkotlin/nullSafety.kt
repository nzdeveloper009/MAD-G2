package com.example.ilmaslearnkotlin
fun main(){
    val name: String= "Ahmad"// non null able
    val password: String? = null
    val isadult: Boolean? = null// null able-----absence og value
    if (password != null) {// null check
        password.uppercase()
    }
    println(password?.uppercase())// safe call operator ?
    isadult?.let { //multiple statements execute
        println(" Line 1")
        println("Line 2 $isadult")   // not safe operator as we know in body cant be null
        println("Line 2 $it")// there it appoint isadult
    }
    val vale=password ?: "NA"// IF age is null then it take default value NA (elvis operator ?:)
    // val val1=age !! .uppercase()// !! means if age is null it show an exception otherwise call the operator
}