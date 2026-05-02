package com.example.ayeshalearnkotlin
//data keyword is used with class
data class Employee(val id: Int, val name: String)
fun main() {
    val emp1 = Employee(101, "Alice")
    val emp2 = Employee(101, "Alice")
    val emp3 = Employee(102, "Bob")
    println(emp1 == emp2)                   // true → equals() compares property values
    println(emp1 == emp3)                   // false
    println(emp1.hashCode())                // Same for emp1 and emp2
    println(emp2.hashCode())                // because their properties are equal
    println(emp3.hashCode())                // different because properties differ
    //--------Enum---------
    val signal = TrafficLight.RED
    println(signal)  // RED
}
//Enum keyword is used with class
enum class TrafficLight {
    RED, YELLOW, GREEN
}
