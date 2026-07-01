package com.learning.learnkotlin


interface Part {
    val price: Int
}

class Transmission : Part {
    override val price: Int = 90000
}

class Engine : Part {
    override val price: Int = 150000
    val transmission = Transmission()
}

class Seat : Part {
    override val price: Int = 15000
}

class Chassis : Part {
    override val price: Int = 200000
    val seats: List<Seat> = listOf(Seat(), Seat(), Seat(), Seat()) // 4 Seats
}

class Wheel : Part {
    override val price: Int = 12000
}

class Wheelbase : Part {
    override val price: Int = 250000
    val chassis = Chassis()
    val wheels: List<Wheel> = listOf(Wheel(), Wheel(), Wheel(), Wheel()) // 4 Wheels
}


class Vehicle {
    val wheelbase = Wheelbase()
    val engine = Engine()

    fun getPrice(): Int {
        var costs = 0

        costs += wheelbase.price
        costs += wheelbase.chassis.price
        costs += engine.transmission.price
        costs += engine.price

        // Android/Modern Kotlin ke mutabiq sumOf use kiya hai
        costs += wheelbase.wheels.sumOf { it.price }
        costs += wheelbase.chassis.seats.sumOf { it.price }

        return costs
    }
}


fun main() {
    val v = Vehicle()
    println("My car's price is: ${v.getPrice()}")
}