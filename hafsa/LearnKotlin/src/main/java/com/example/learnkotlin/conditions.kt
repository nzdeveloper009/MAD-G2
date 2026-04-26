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

    // take input from user and check
    // if  a person is eligible to vote
    print("Enter your age: ")
    val age= readLine()!!.toInt()
    if(age>=18)
    {
        println("Eligible...")
    }
    else{
        println("Not Eligible")
    }


    //print days of week using when
    print("Enter a day number (1 to 7): ")
    var day= readLine()!!.toInt()
    when(day){
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        6 -> println("Saturday")
        7 -> println("Sunday")
        else -> "Invalid Input"
    }
}