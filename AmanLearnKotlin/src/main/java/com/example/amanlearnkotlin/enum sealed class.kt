package com.example.amanlearnkotlin

fun main() {
    // 1. Enum Test
    val today = DayType.SUNDAY
    println("Enum: ${today.name} is day number ${today.number}")

    // 2. Sealed Class Test
    val myTile: GameTile = RedTile("Fire", 30)

    val score = when (myTile) {
        is RedTile -> myTile.points * 2
        is BlueTile -> myTile.points * 5
    }
    println("Sealed Class Score: $score")
}

// ENUM CLASS SECTION
enum class DayType(val number: Int) {
    SUNDAY(1), MONDAY(2), TUESDAY(3),
    WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7)
}

//  SEALED CLASS SECTION
sealed class GameTile

class RedTile(val type: String, val points: Int) : GameTile()
class BlueTile(val points: Int) : GameTile()
