package com.example.ilmaslearnkotlin

fun main(){
    println("Type checking and Type casting")
    // type checking is used to verify the object type on runtime  but kotlin is the powerful language that check the type on compile time
    // **** type-casting
    // type casting is used to convert the object from one type to another type to use its specific methods or properties
    val circle=Circles(4.0)
    val Triangle=Triangles(2.0,5.0)
    val player=Player("Ali")
    val arr: Array<Draggable> =arrayOf(circle,player)
    for(obj in arr) {
        if (obj is Circles) {
            println(obj.area())  // type checking
        }
        else if(obj is Triangles){
            println(obj.area())
        }
        else{
            (obj as Player).myName() // type casting
        }

    }
    println("----------------------------------------------")

    println("***Interface****")

dragObjects(arrayOf(Circles(3.0),Triangles(7.0,5.0),Player("smilley")))
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
    fun myName()=println("My name is $name")
}
