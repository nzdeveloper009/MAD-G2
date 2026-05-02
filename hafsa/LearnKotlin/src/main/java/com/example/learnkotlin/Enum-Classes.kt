package com.example.learnkotlin

enum class Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

sealed class Status {
    class SUCCESS(val data: String) : Status()
    class ERROR(val message: String) : Status()
    class LOADING : Status()
}

fun handleStatus(status: Status) {
    when (status) {
        is Status.SUCCESS -> println("Data: ${status.data}")
        is Status.ERROR -> println("Error: ${status.message}")
        is Status.LOADING -> println("Loading...")
    }
}
fun main() {
    val today = Day.FRIDAY

    if (today == Day.FRIDAY) {
        println("its Friday.. Jummah hai")
    }
//    println(Status.SUCCESS.code)
    val r: Status = Status.SUCCESS("Data loaded")
    handleStatus(r)

}
