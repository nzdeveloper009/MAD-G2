package com.example.amanlearnkotlin


fun main() {
    // Square ka object banaya
    val square = Square()

    // Overridden property aur method ko call kiya
    println(square.name) // Output: Square
    square.display()    // Output: Shape is displayed (super call) aur phir "Square is displayed"


    // toString() override ka demo
    println(square.toString())
}

// Parent class
open class Shape {
    // Property ko override karne ke liye 'open' likhna zaroori hai
    open var name: String = "Shape"

    // Method ko override karne ke liye 'open' likhna zaroori hai
    open fun display() {
        println("Shape is displayed")
    }
}

// Child class
class Square : Shape() {
    // Property override ki gayi
    override var name: String = "Square"

    // Method override kiya gaya
    override fun display() {
        // super.display() se parent ka method call hota hai
        super.display()
        println("Square is displayed")
    }

    // Any class ka toString method override kiya (Video ka aakhri hissa)
    override fun toString(): String {
        return "I am a Square Shape"
    }
}