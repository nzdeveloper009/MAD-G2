package com.learning.learnkotlin

import kotlin.math.pow


fun sum(a: Double, b: Double): Double {
    return a + b
}

fun Power(a: Double, b: Double): Double {
    return a.pow(b)
}

fun hello() {
    println("Hello!")
}

fun calculate(a: Double, b: Double, gn: (Double, Double) -> Double) {
    val result = gn(a, b)
    println("Result of calculation is: $result")
}

fun main() {

    var fn: (Double, Double) -> Double = ::sum

    println("Calling stored sum function: ${fn(2.0, 3.0)}")


    fn = ::power
    println("Calling stored power function: ${fn(2.0, 3.0)}")



    println("\n--- Higher Order Function Calls ---")


    calculate(5.0, 10.0, ::sum)

    calculate(2.0, 3.0, ::power)


    calculate(10.0, 2.0) { x, y ->
        x - y
    }
}
