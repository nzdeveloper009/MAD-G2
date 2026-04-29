package com.example.lib
fun main(){
val day= day.Sunday// jsut one object in enum class
    day.printday()

    // sealed class
    val tile: Tile= Red("Mashrom", 25)
    val points=when(tile){
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
    Saturday(7);// semi colon at last value to define fun
    fun printday(){
        println(" Day is $this")
    }
}
// for multiple objects we consider type in sealed class
sealed class Tile
class  Red (val type: String, val points:Int): Tile()// Types of sealed class
class Blue(val points: Int): Tile()
