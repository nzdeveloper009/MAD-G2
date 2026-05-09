package com.learning.learnkotlin

enum class Day(val number: Int) {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    fun printFormattedDay() {

        println("Day is $this")
    }
}


sealed class Tile

class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()

fun main() {
    // --- Enum Usage ---
    println("--- Enum Class Demo ---")
    val today = Day.SUNDAY
    println("Today's number: ${today.number}")
    today.printFormattedDay()


    for (day in Day.values()) {
        println("Day in loop: $day")
    }


    val tile1: Tile = Red("Mushroom", 25)
    val tile2: Tile = Red("Fire", 30)
    val tile3: Tile = Blue(50)

    val points = when (tile1) {
        is Red -> tile1.points * 2
        is Blue -> tile1.points * 5

    }

    println("Calculated Points for tile1: $points")
}