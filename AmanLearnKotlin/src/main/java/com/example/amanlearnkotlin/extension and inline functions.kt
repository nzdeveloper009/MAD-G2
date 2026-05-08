package com.example.amanlearnkotlin

fun main() {
    // 1. Extension Function ka istemal
    val message = "Hello CheezyCode"
    println(message.formattedString())

    // 2. Inline Function ka istemal
    calculateTime {
        // Koi bhi kaam jo time lega
        loop(1000000)
    }
}

// EXTENSION FUNCTION: String class mein naya method add karna
fun String.formattedString(): String {
    return "--------------------\n$this\n--------------------"
}

// INLINE FUNCTION: Performance behtar karne ke liye
inline fun calculateTime(fn: () -> Unit) {
    val start = System.currentTimeMillis()
    fn() // Function execute karna
    val end = System.currentTimeMillis()
    println("Time taken: ${end - start} ms")
}

fun loop(n: Long) {
    for (i in 1..n) {
        // Sirf loop chal raha hai
    }
}