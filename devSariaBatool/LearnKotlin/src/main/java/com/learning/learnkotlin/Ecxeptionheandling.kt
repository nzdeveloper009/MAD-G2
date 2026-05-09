package com.learning.learnkotlin

import java.lang.IllegalArgumentException

fun main() {

    val arr = arrayOf(1, 2, 3)

    println("--- Starting Try-Catch Example ---")
    try {

        println("Accessing element at index 5: ${arr[5]}")
    }
    catch (e: ArrayIndexOutOfBoundsException) {

        println("Caught Specific Error: Please check your array index! [00:05:27]")
    }
    catch (e: Exception) {

        println("Caught General Error: ${e.message}")
    }
    finally {

        println("Finally Block: I will execute no matter what. [00:05:36]")
    }

    println("\n--- Starting Throw Example ---")

    try {
        createUserList(5)
        createUserList(-2)
    } catch (e: IllegalArgumentException) {
        println("Error during user creation: ${e.message}")
    }
}


fun createUserList(count: Int) {
    if (count <= 0) {

        throw IllegalArgumentException("Count must be greater than zero. Received: $count")
    } else {
        println("User list of size $count created successfully!")
    }
}