package com.example.ayeshalearnkotlin

fun main() {
    var count = 10
    //first condition will be executed , then the attched statements will execute accordingly
    while (count > 0) {
        println(count.toString() + "  I'm going to be a dveloper")
        // we have used an integer with a string statement , for that purpose we have used ".tostring" with the int value and "+" to attach to statements
        count--
    }
    var index = 0
    do {
        println("I've started learning kotlin!!")
        index++
    } while (index < 10)
     // for loop: no need to initialize variable before , can do it directly using range .
     // range: in range we keyword "in" to find required value in the range , in given case , starts from 1 to 10
    //in case of for loop , loop runs until the last value of range.
    for (z in 1..10) {
        println(z)
    }
    //table of 5:
    var num=5
    for (i in 1..10){
        println(" $num x $i = ${num * i } ")
        //string templating is used here, its also used to attach a int amd a string statement, its more readable.
        //println(num.tostring + "x" + i.tostring "=" + (num*i)
    }
}