package com.example.amanlearnkotlin

import kotlin.math.pow

fun main() {
    // Higher-Order Function call
    calculator(10.0, 5.0, ::sumFn)
    calculator(2.0, 3.0, ::powerFn)
}

fun calculator(a: Double, b: Double, gn: (Double, Double) -> Double) {
    val result = gn(a, b)
    println("Result: $result")
}

// Inka naam change kar diya taake conflict na ho
fun sumFn(a: Double, b: Double): Double {
    return a + b
}

fun powerFn(a: Double, b: Double): Double {
    return a.pow(b)
}