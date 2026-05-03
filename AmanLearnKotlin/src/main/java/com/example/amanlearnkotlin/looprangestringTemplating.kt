package com.example.amanlearnkotlin

fun main(){
    /*
    for(i in 1..5 step 2){
        println(i)
    }
    //iterations known use for loop
        //iterations unknown use while loop
    for(i in 1 until 5){
        println(i)
    }

     */

    //for(i in 10 downTo 1 step 2){
   //     println(i)
  // }
    val number = 2
    for (i in 1..10) {
        println("$number X $i = ${number * i}") //string templating
    }
}