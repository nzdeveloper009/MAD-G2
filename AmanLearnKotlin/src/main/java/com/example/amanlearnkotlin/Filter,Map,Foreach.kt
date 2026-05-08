package com.example.amanlearnkotlin

fun main() {
    val nums = listOf(1, 2, 3, 4, 5)

    // 1. FILTER: Condition ke mutabiq elements ko select karna
    // Isse humein sirf odd numbers milenge
    val filteredList = nums.filter { it % 2 != 0 }
    println("Filtered (Odd): $filteredList")

    // 2. MAP: Har element ko transform (change) karna
    // Isse har number ka square (it * it) ban jayega
    val mappedList = nums.map { it * it }
    println("Mapped (Squares): $mappedList")

    // 3. FOREACH: Har element par koi action perform karna
    // Ye loop ki tarah kaam karta hai par zyada saaf dikhta hai
    nums.forEach { println("Number: $it") }

    // Real-world example with Objects
    val users = listOf(
        User(1, "Aman"),
        User(2, "Ali"),
        User(3, "Sara")
    )

    // Example: Un users ke naam nikalna jinki ID 1 se badi ho
    val userNames = users
        .filter { it.id > 1 }
        .map { it.name }

    println("Filtered Names: $userNames")
}

data class User(val id: Int, val name: String)