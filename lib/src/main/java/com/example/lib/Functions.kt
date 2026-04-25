package com.example.lib

import kotlin.math.pow

//Function overloading
fun add( a: Int,b: Int): Int{
return a+b
}
fun add(a: Double,b: Double): Double{
    return a+b
}
fun power(a: Double,b: Double): Double{
    return a.pow(b)
}
