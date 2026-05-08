package com.example.amanlearnkotlin

import kotlin.math.PI

fun main() {
    // Polymorphism: Parent (Shape) ka reference Child (Circle, Square) ke objects hold kar raha hai
    val circle: Shape = Circle(4.0)
    val square: Shape = Square(4.0)
    val triangle: Shape = Triangle(4.0, 3.0)

    // Objects ko ek array mein daal kar loop chalaya
    val shapes = arrayOf(circle, square, triangle)
    calculateAreas(shapes)
}

fun calculateAreas(shapes: Array<Shape>) {
    for (shape in shapes) {
        // Run-time par pata chalta hai ke kaunsa area method call karna hai
        println("Area: ${shape.area()}")
    }
}

// Parent Class
open class Shape {
    open fun area(): Double = 0.0
}

// Child Class 1
class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
}

// Child Class 2
class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
}

// Child Class 3 (Video ke end mein add ki gayi)
class Triangle(val base: Double, val height: Double) : Shape() {
    override fun area(): Double = 0.5 * base * height
}