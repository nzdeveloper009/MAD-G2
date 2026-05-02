package com.example.ayeshalearnkotlin

fun main() {

    // Nullable variable (can store a String OR null)
    var name: String? = "Ayesha"

    // 1. Direct access using safe call
    // If name is not null → gives length
    // If null → returns null (no crash)
    println("Using safe call (?.): Length = ${name?.length}")

    // 2. Using Elvis operator with safe call
    // If name is null → default value -1 is used
    val length1 = name?.length ?: -1
    println("Using Elvis (?:): Length = $length1")

    // Now make name null
    name = null

    println("\nAfter setting name = null")

    // Safe call again (won't crash)
    println("Using safe call (?.): Length = ${name?.length}")

    // Elvis operator gives fallback value
    val length2 = name?.length ?: -1
    println("Using Elvis (?:): Length = $length2")
}