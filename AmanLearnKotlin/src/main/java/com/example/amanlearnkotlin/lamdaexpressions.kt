package com.example.amanlearnkotlin


fun main() {
    // 1. Simple Lambda (Do numbers ko jama karne ke liye)
    val sum = { x: Int, y: Int -> x + y }
    println("Sum: ${sum(10, 20)}")

    // 2. Multi-line Lambda (Aakhri line return value hoti hai)
    val multiLineLambda = {
        println("Calculating...")
        val result = 5 + 5
        result // Ye value return hogi
    }
    println("Result: ${multiLineLambda()}")

    // 3. Single Parameter Lambda ('it' keyword ka use)
    val square: (Int) -> Int = { it * it }
    println("Square: ${square(5)}")

    // 4. Lambda as Function Parameter (Higher-Order Function)
    calculator(10, 5, { a, b -> a + b })

    // 5. Trailing Lambda (Agar lambda aakhri parameter ho to use bracket se bahar likh sakte hain)
    calculator(20, 10) { a, b ->
        a - b
    }
}

fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int) {
    val result = operation(a, b)
    println("Calculator Result: $result")
}