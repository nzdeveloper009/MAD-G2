package com.example.learnkotlin

fun main() {

    //print table using while
    print("Enter a positive number: ")
    val num = readLine()!!.toInt()
    var i= 1
    while(i<=10)
    {
        println("$num * $i = ${num*i}")
        i++
    }

    for(i in 10 downTo 1){
        println(i)
    }

    //print even numbers

    for(i in 2..100 step 2){
        println(i)
    }


    // SUM OF FIRST 10 NUMBERS
    var sum = 0
    for(i in 1..10 )
    {
        sum= sum+i

    }
    println("sum of First 10 natural numbers: $sum")


    //until
    println("Until")
    var first=0
    var second = 1
    var res = 0
    for(i in 0 until 5) {
        res = first + second
        print("$res ")
        first = second
        second = res
    }
}