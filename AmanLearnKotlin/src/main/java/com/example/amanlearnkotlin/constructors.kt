package com.example.amanlearnkotlin

fun main() {

    // Automobile object
    var car = Automobile(name = "car", types = 4, maxSeating = 5)
    car.drive()
    car.applyBrakes()

    // Person objects
    var person1 = PersonConstructor(namePram = "saria", agePraam = 21)
    println(person1.name)
    println(person1.age)

    var person2 = PersonConstructor(namePram = "aman", agePraam = 20)
    println(person2.name)
    println(person2.age)
}

// Automobile class - constructor ke sath
class Automobile(val name: String, val types: Int, val maxSeating: Int) {
    fun drive() {
        println("$name is driving")
    }

    fun applyBrakes() {
        println("$name applied brakes")
    }
}

// Empty class example
class Empty()

// Person class - constructor practice
class PersonConstructor(namePram: String, agePraam: Int) {
    val name: String = namePram
    var age: Int = agePraam
}