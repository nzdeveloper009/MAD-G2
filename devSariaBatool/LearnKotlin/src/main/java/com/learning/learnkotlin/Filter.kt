package com.learning.learnkotlin

data class user(val id: Int, val name: String)
data class PaidUser(val id: Int, val name: String, val type: String)

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)


    val oddNumbers = numbers.filter { it % 2 != 0 }
    println("Odd Numbers: $oddNumbers")


    val users = listOf(
        user(1, "A"),
        user(2, "B"),
        user(3, "C")
    )
    val filteredUsers = users.filter { it.id == 2 }
    println("Filtered User (ID 2): $filteredUsers")


    val squares = numbers.map { it * it }
    println("Squares: $squares")


    val paidUsers = users.map {
        PaidUser(it.id, it.name, "Paid")
    }
    println("Transformed Paid Users: $paidUsers")



    println("Iterating using forEach:")
    numbers.forEach {
        println("Number: $it")
    }
}