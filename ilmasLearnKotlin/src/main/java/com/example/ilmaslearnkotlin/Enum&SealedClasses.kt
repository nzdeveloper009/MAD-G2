package com.example.ilmaslearnkotlin

fun main(){
    val day= day.Sunday// just one object in enum class
    day.printday()

    // sealed class
    val tile: Tile= Red("Mashroom", 25)
    val points=when(tile){ // no else needed
        is Blue -> tile.points*2
        is Red -> tile.points*4
    }
    println(points)



}
enum class day(val number:Int) {// only a set of values can be assinged not a random value so we use enum class
    Sunday(1),
    Monday(2),
    Tuesday(3),
    wednesday(4),
    Thursday(5),
    Friday(6),
    Saturday(7);// semmi-colon at last value to define fun
    fun printday(){
        println(" Day is $this")
    }
}
// Sealed class is used to restrict class hierarchy and allow only a fixed set of subclasses, making code safer and more predictable.
sealed class Tile
class  Red (val type: String, val points:Int): Tile()// Types of sealed class
class Blue( val type:String , val points: Int): Tile()