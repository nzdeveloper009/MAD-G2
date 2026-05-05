package com.example.amanlearnkotlin

import kotlin.math.pow

fun main() {
    var fn = ::power

    println(fn(2.0, 3.0))           //  Variable se call - no named args
    println(addition(a = 2, b = 4))   //Direct call - named args theek hain
    println(addition(a = 4.5, b = 4.5)) //Direct call - named args theek hain
}

fun addition(a: Int, b: Int): Int {
    return a + b
}

fun addition(a: Double, b: Double): Double {
    return a + b
}

fun power(a: Double, b: Double): Double {
    return a.pow(b)
}