package com.learning.learnkotlin

fun main() {

    val message = "Hello Cheezy Code"
    println("Original: $message")

    val formatted = message.formattedString()
    println("Formatted: $formatted")

    println("-------------------------")

    calculateTime {
        executeLoop(1000000L)
    }
}


fun String.formattedString(): String {
    return "------------------\n$this\n------------------"
}


inline fun calculateTime(fn: () -> Unit) {
    val start = System.currentTimeMillis()

    fn()

    val end = System.currentTimeMillis()
    println("Time Taken: ${end - start} ms")
}


fun executeLoop(n: Long) {
    for (i in 1..n) {
        // Just simulating work
    }
}