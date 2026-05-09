package com.learning.learnkotlin

fun main() {

    val sumLambda = { x: Int, y: Int -> x + y }
    println("Sum using basic lambda: ${sumLambda(5, 10)}")

    val multiLineLambda = {
        println("Executing multi-line lambda...")
        val a = 10
        val b = 20
        a + b
    }
    println("Result of multi-line lambda: ${multiLineLambda()}")


    val squareLambda: (Int) -> Int = { it * it }
    println("Square of 5: ${squareLambda(5)}")


    calculate(10, 20, { a, b -> a + b })


    calculate(50, 50) { a, b ->
        a + b
    }
}


fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int) {
    val result = operation(a, b)
    println("Calculation Result: $result")
}