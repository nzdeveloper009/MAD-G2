package com.example.amanlearnkotlin


fun main() {
    val arr = arrayOf(1, 2, 3)

    try {
        // Aisa code jisme error aa sakta hai
        println(arr[5])
    } catch (e: ArrayIndexOutOfBoundsException) {
        // Sirf specific error handle karne ke liye
        println("Specific Error: Index galat hai.")
    } catch (e: Exception) {
        // Kisi bhi aur tarah ki exception ke liye (Parent class)
        println("General Error: Kuch masla hua hai -> ${e.message}")
    } finally {
        // Ye block hamesha chalega, chahe error aaye ya na aaye
        println("Cleanup: Process khatam.")
    }

    // Custom Exception throw karna
    try {
        createUserList(-2)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

fun createUserList(count: Int) {
    if (count < 0) {
        // Jan boojh kar error generate karna
        throw IllegalArgumentException("Count zero se kam nahi ho sakta")
    }
    println("User list created with $count users")
}