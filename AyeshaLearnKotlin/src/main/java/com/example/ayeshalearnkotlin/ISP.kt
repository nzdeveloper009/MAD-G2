package com.example.ayeshalearnkotlin

//before ISP
interface Vehicle {
    fun drive()
    fun fly()
}

//After ISP
interface Drivable {
    fun drive()
}
interface Flyable {
    fun fly()
}
class Car : Drivable {
    override fun drive() {
        println("Car is driving")
    }
}
class Airplane : Drivable, Flyable {
    override fun drive() {
        println("Airplane is taxiing")
    }
    override fun fly() {
        println("Airplane is flying")
    }
}
