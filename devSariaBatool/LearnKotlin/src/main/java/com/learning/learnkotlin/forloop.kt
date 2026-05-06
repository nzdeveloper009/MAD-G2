package com.learning.learnkotlin

//for loop
fun main(){
    //for(i in 1..5 step 2){
      //  println(i)
    //}
    //println("Until")
    //for (i in 1 until 5){
     //   println(i)
   // }

    for (i in 10 downTo 1 step 2){
        println(i)
    }
    number()
}
fun number(){
    val number = 2
    for( i in 1.. 10){

        //println(number.toString() + "x" +i+ "=" +(number*i))
        //string templating
        println( "$number x $i = ${number * i }")
    }
}