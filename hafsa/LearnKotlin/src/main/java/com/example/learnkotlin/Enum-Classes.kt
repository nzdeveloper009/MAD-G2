package com.example.learnkotlin

enum class Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum class Status(val code: Int) {
    SUCCESS(200),
    ERROR(500),
    LOADING(100)
}


fun main() {
    val today = Day.FRIDAY

    if (today == Day.FRIDAY) {
        println("its Friday.. Jummah hai")
    }
    println(Status.SUCCESS.code)

}
