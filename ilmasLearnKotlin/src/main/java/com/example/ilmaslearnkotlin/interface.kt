package com.example.ilmaslearnkotlin

fun main(){
dragObjects(arrayOf(Circles(4.0),Triangles(2.0,5.0),Player("smilley")))
}
fun dragObjects(objects: Array<Draggable>){
    for(obj in objects){
        obj.drag()
    }
}
//Interface
// when we want a common behavior or property but there is no inheritance relationship between classes
// it behaves like abstract class but we don't need to write keyword abstract
//it allow to group classes by their common behaviors
interface Draggable{
    fun drag()
}

abstract class Shapes():Draggable{
    abstract fun area(): Double
}
 class Circles(val radius:Double):Shapes(){
    override  fun area(): Double{
        return Math.PI*radius*radius
    }
    override fun drag(){
        println("Circle is dragging")
    }
}
class Triangles(val base:Double,val height:Double):Shapes(){
    override  fun area(): Double{
        return 0.5*base*height
    }
    override fun drag(){
        println("Triangle is dragging")
    }
}
class Player(val name:String):Draggable{
    override fun drag(){
        println("$name player is dragging")
    }
}
