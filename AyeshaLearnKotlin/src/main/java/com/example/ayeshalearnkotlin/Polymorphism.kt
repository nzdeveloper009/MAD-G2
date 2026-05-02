package com.example.ayeshalearnkotlin

fun main (){
    //Polymorphism is working here, parent "Shape" is holding referances to the child class , which means it can call the methods of child classes , after analization at the run time.
    //overloading and overriding is also a part of polymorphism , we have discussed them before .
val shapes: Array<Shape> = arrayOf(Circle(3.0),Square(4.0),Triangle(4.0,7.0))
    claculatesAreas(shapes)
    // an array of Shape data type(class)is holding the referances od child classes and it called the methods of circle , square , triagnle class
}
fun claculatesAreas(shapes: Array<Shape>){
    for(shape: Shape in shapes){
        println(shape.area())
    }
}
open class Shape {
    open fun area(): Double {
        return 0.0
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

class Square(val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(val base: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return 0.5 * base * height
    }
}
