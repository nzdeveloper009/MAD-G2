package com.example.amanlearnkotlin

fun main(){
    /*val above50=true
    val expertprogramming= false
    var callForInterview= above50 && expertprogramming
    println(callForInterview)

    callForInterview= above50 || expertprogramming
    println(callForInterview)
*/
    //shortcircuting
    //or operator if one var is true the first becomes true and it doesnt check the second condition
   /*
    var i=10
    var j=11
    var result = i==10|| j++ ==11
    println(i)
    println(j)

    */

    //false ---> !---> true
    //true ---> !=false

    val answer=false
    val result=!answer
    println(result)
}