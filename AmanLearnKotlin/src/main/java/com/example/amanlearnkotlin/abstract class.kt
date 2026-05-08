package com.example.amanlearnkotlin

fun main() {
    // Abstract class ka object nahi ban sakta, isliye Child ka banayenge
    val myCircle = AbstractCircle(5.0)
    myCircle.display()
    println("Area: ${myCircle.calculateArea()}")
}

// 1. Abstract Class (Incomplete Class)
abstract class AbstractShape {
    // Abstract Method (Body nahi hoti, Child isse lazmi define karega)
    abstract fun calculateArea(): Double
    abstract fun display()

    // Non-abstract Method (Body ho sakti hai)
    fun showMessage() {
        println("This is a shape message")
    }
}

// 2. Child Class (Jo abstract methods ko complete karegi)
class AbstractCircle(val radius: Double) : AbstractShape() {

    override fun calculateArea(): Double {
        return 3.14 * radius * radius
    }

    override fun display() {
        println("Displaying Circle Shape")
    }
}

// 3. Ek aur example jahan koi abstract method nahi par class abstract hai
abstract class BaseTemplate {
    fun start() {
        println("Template started")
    }
    // Is class ka object nahi ban sakega jab tak koi inherit na kare
}