package com.learning.learnkotlin

fun main() {

    var gender: String = "Male"
    var gender2: String? = null

    println("Gender 2 is: $gender2")


    if (gender2 != null) {
        println(gender2.uppercase())
    } else {
        println("Gender 2 is null")
    }


    println(gender2?.uppercase())


    gender2?.let {
        println("Line 1: Inside let block")
        println("Line 2: Value is $it")

        val selectedValue = gender2 ?: "NA"
        println("Selected Value: $selectedValue")

        try {

            println(gender2!!.uppercase())
        } catch (e: Exception) {
            println("Caught Exception: ${e.message}")
        }
    }
}