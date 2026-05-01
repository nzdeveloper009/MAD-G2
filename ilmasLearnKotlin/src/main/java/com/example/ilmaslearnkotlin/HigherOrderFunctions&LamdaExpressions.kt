package com.example.ilmaslearnkotlin

import kotlin.math.pow

fun main() {
    val fn = ::power1
    println(fn(3.4, 8.9))// fun type
    calculator(3.0, 4.0, ::sum)


    //lambda expression
    val lam ={x: Int,y: Int-> x+y}
    // multi line lamda
    val lam1={
        println("Hello lambda")
        val a: Int=2+3
        "Hello world"//last expression will define its data type
    }
    println(lam1())
    val value=calculator(5.0,5.0,{a,b->a+b})// call calculator with lambda
    println(value)
}


//a function that store as parameter pass and a fun can return a function
fun sum(a: Double,b: Double): Double{
    return a+b
}
fun power1(a: Double,b: Double): Double{
    return a.pow(b)
}
//higher order function -> take function in input are give function in output
fun calculator(a: Double,b: Double,gn:(Double, Double)-> Double){
    val res=gn(a,b)
    println(res)
}
//lambadas expression are function without name
val singlelama={x: Int-> x*x}// single value lambda with variable
val lamb2:(Int)-> Int={it+it}//single value lambda with it
val sayHi={message: String->println(" the word is $message")}