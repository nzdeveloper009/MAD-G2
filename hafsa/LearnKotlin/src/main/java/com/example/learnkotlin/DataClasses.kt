package com.example.learnkotlin

data class Product(val id: Int, val name: String, val price: Double)

fun main() {
    val p1 = Product(101, "Shoes", 2500.0)
    val p2 = Product(101, "Shoes", 2500.0)

    println(p1)              // toString()
    println(p1 == p2)        // equals()

    val p3 = p1.copy(price = 2000.0)  // copy()

    val (id, name, price) = p3  // destructuring

    println("Name: $name, Price: $price")
}