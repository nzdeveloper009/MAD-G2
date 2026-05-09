package com.learning.learnkotlin

//
fun main(){
    val circle = Circle(4.0)
    println(circle.area())
    circle.display()
}

abstract class A{
    fun method(){
        println("i am method")
    }
}
abstract class Shape {
    var name:String =""
    abstract fun area(): Double
    abstract  fun display()

}
class Circle(val radius:Double):Shape(){
    override fun area():Double = Math.PI*radius*radius
    override fun display() {
        println("Circle is getting display")
    }
}
