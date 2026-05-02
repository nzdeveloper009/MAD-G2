package com.example.learnkotlin

fun main() {

    // nullable & non-nullable
    val name: String = "Ahmad"
    var password: String? = null
    var age: Int? = null

    if (password != null) {
        println(password.uppercase())
    }

    // safe call
    println(password?.uppercase())

    // let (multiple operations)
    password?.let {
        println("Inside let")
        println(it.uppercase())
    }

    // elvis operator
    val pass = password ?: "DEFAULT"
    println(pass)

    // not null assertion
    // println(password!!.uppercase())

    // safe casting
    val obj: Any = "Hello"
    val str: String? = obj as? String
    println(str)

    // with + let combo
    age?.let {
        println(it + 10)
    }
}