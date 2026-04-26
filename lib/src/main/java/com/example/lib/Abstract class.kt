package com.example.lib

import kotlin.math.PI

fun main() {
    val cir = Circle(3.0)
    println("Area: ${cir.area()}")
    cir.display()

    fun dragobj(obj: Array<dragable>){// now it is based on interface
        for (ob in obj){
            ob.drag()
        }
    }
    dragobj(arrayOf(Circle(4.6), square(7.9), player()))
 // Type checking and smart casting
    val arr1: Array<Any> =arrayOf(player(), test())// use any class bcz test is not from dragable interface
    val arr: Array<dragable> = arrayOf(Circle(3.5), player())
    for (obj in arr){
        if (obj is Circle){// Type checking
            println(obj.area())// smart casting

        }
        else{
            (obj as player).sayMyName()
        }
    }
}



interface dragable{
    fun drag()
}
abstract class Shape : dragable{
    abstract fun area(): Double
    abstract fun display()
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return PI * radius * radius
    }

    override fun display() {
        println("Circle is Displayed")
    }

    override fun drag() {
        println("circle is draging")
    }
}
class square(val side: Double): Shape(){
    override fun area(): Double {
        return side*side
    }

    override fun display() {
        println("square is displayed")
    }

    override fun drag() {
        println("square is draging")
    }


}
   class player : dragable{
       override fun drag() {
           println("player is draging")
       }
       fun sayMyName(){
           println(" My name is Sanila")
       }

   }
class test{
    fun  make_test(){
        println(" test is being to start")
    }
}