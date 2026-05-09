package com.learning.learnkotlin

fun main() {
    dragObjects(objects = arrayOf(Player("Smiley")))
}
fun dragObjects(objects:Array<Draggable>){
    for(obj in objects){
        obj.drag()
    }
}

interface Draggable{
    fun drag()
}
abstract class Shape: Draggable{
 abstract fun area():Double

}
abstract class Circle(val radius:Double):Shape(){
  override fun area():Double{
    return Math.PI*radius
}

    fun darg() {
        println("Circle is dragging")
    }
}
 abstract class Square(val side:Double):Shape(){
  override fun area():Double{
    return side * side
}
     fun darg() {
        println("Square is dragging")
    }
}

abstract class triangle(val base:Double,val height:Double):Shape(){
  override fun area(): Double {
    return 0.5*base * height
}
    fun darg() {
        println("Triangle is dragging")
    }
}
class Player(val name:String): Draggable{
    override fun drag()= println("$name is dragging")
}