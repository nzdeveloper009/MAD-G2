package com.example.learnkotlin

fun divide(a: Int, b: Int): Int {
    if (b == 0) throw IllegalArgumentException("Cannot divide by zero")
    return a / b
}

fun main() {

    try {
        val result = divide(10, 0)
        println(result)
    } catch (e: ArithmeticException) {
        println("Arithmetic Error")
    } catch (e: Exception) {
        println("General Error: ${e.message}")
    } finally {
        println("Finally block executed")
    }

    // try as expression
    val value = try {
        10 / 2
    } catch (e: Exception) {
        0
    }
    println(value)
}