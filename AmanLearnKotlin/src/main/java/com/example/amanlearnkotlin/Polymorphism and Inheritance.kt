package com.example.amanlearnkotlin

fun main() {
    val transport: BaseVehicle = BaseVehicle()
    val myBike: Motorbike = Motorbike()

    processVehicle(transport)
    processVehicle(myBike)

    val track = RacingTrack(100.0)
    println(track.toString())
}

fun processVehicle(v: BaseVehicle) {
    v.startEngine()
}

open class BaseVehicle {
    open fun startEngine() {
        println("Vehicle engine started")
    }

    override fun toString(): String {
        return "General Vehicle Type"
    }
}

class Motorbike : BaseVehicle() {
    override fun startEngine() {
        println("Motorbike engine roaring")
    }
}

class RacingTrack(val length: Double) : BaseVehicle() {
    override fun startEngine() {
        println("Track cleared for racing")
    }

    override fun toString(): String {
        return "Racing Track of $length meters"
    }
}