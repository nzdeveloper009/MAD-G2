package com.example.lib

fun main(){
    val name: String= "Sanila"// non null able
    val age: String?=null
    val isadult: Boolean?=null// null able
    if (age != null) {// null check
        age.uppercase()
    }
    println(age?.uppercase())// safe call operator
    isadult?.let {
        println(" Line 1")
        println("Line 2 $isadult")
        println("Line 2 $it")// there it appoint isadult
    }
    val vale=age?:"NA"// IF age is null then it take NA collsing operator
    val val1=age!!.uppercase()// !! means if age is null it show an exception otherwise call the operator
}