package com.learning.learnkotlin

data class person(val id: Int, val name: String)

fun main() {
    // 1. Creating objects
    val p1 = person(1, "John")
    val p2 = person(1, "John")
    val p3 = person(2, "Jane")


    println("p1 equals p2: ${p1 == p2}")
    println("p1 equals p3: ${p1 == p3}")


    println("Object p1: $p1")

    val p4 = p1.copy(id = 3)
    println("Copied Object p4: $p4")


    val (myId, myName) = p1
    println("Destructured - ID: $myId, Name: $myName")


    val comp1 = p1.component1()
    val comp2 = p1.component2()
    println("Component 1: $comp1, Component 2: $comp2")
}

