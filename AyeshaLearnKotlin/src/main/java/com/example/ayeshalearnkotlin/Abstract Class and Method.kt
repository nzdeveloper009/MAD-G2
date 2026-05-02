package com.example.ayeshalearnkotlin

fun main(){
    val circle= Circle(4.0)
    println(circle.area())
}
//Abstract means you want that class to be defined by the child classes.
//A method or a class can be abstract by using “abstract” keyword.

abstract class shape {
    //A abstract method cannot have body , and an abstract function cannot exist without an abstract class .
    abstract fun area(): Double
}
    class circle(val radius:Double) : Shape(){
        //Abstract methods can be accessed in child classes by the keyword” override”
        override fun area(): Double {
            return Math.PI * radius * radius}
         }
