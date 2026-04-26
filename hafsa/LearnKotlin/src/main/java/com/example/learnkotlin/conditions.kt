package com.example.learnkotlin

fun main() {
    println("learning conditions")

    // check username and password
    print("Enter your username: ")
    var username = readln()
    print("Enter password: ")
    var pass = readln()

    if(username == "hafsanoor091" && pass == "hafsa123")
    {
        println("successfully logIn")
    }
    else{
        println("invalid username or password")
    }


    // check value is positive or negative

    print("Enter a number: ")
    val x = readLine()!!.toInt()

    if (x == 0) {
        println("Number is ZERO")
    } else if (x < 0) {
        println("Number is negative")
    } else {
        println("Number is positive")
    }
}