package com.learning.learnkotlin
import kotlin.math.pow

// same name different parameters , type or number of parameters different
fun main() {
    var fn = ::addition
    println(fn(1.0, 2.0))
    // println(addition( a = 2, b= 3))
    //println(addition(b=2,a=5))
    //println(addition(1.0,2.0))
    fn = ::power
    println(fn(2.0,3.0))

//named argument
//fun addition(a:Int,b:Int) :Int{
    //  return a+b
//}
}
fun addition(a: Double,b: Double): Double{
    return a + b
}
fun power(a: Double,b: Double): Double{
    return a.pow(b)
}
