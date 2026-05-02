package com.example.learnkotlin

fun main() {

    val nums = listOf(1, 2, 3, 4, 5, 6)

    val even = nums.filter { it % 2 == 0 }
    // val even = nums.filter { x: Int -> x % 2 == 0 }

    println(even)


    val doubled = nums.map { it * 2 }
    // val doubled = nums.map { x: Int -> x * 2 }

    println(doubled)

    val users = listOf(
        NormalUser("Hafsa", "afafwe"),
        NormalUser("Ayesha", "afafa"),
        NormalUser("Gull", "adhaah")
    )

    //convert user to paid users
    val paidUsers = users.map {
        PaidUser(it.name, it.email, "Premium")
    }

    println(paidUsers)
    //for each
    users.forEach { println(it)}
}

data class NormalUser(val name: String, val email: String)

data class PaidUser(val name: String, val email: String, val plan: String)