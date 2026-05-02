package com.example.learnkotlin

open class Employee {
    fun work() {
        println("Employee working")
    }
}

class Developer : Employee() {
    fun code() {
        println("Writing code")
    }
}



open class Vehicle {
    open fun start() {
        println("Vehicle starts")
    }
}

class Car : Vehicle() {
    override fun start() {
        println("Car starts with key")
    }

    fun openTrunk() {
        println("Trunk opened")
    }
}

class Bike : Vehicle() {
    override fun start() {
        println("Bike starts with kick")
    }

    fun wheelie() {
        println("Doing wheelie")
    }
}


fun main() {
    val emp: Employee = Developer()

    if (emp is Developer) {
        emp.code()   // smart casting
    }

    val vehicles: Array<Vehicle> = arrayOf(Car(), Bike())

    for (v in vehicles) {
        v.start()

        if (v is Car) {
            v.openTrunk()
        }
        else if (v is Bike) {
            v.wheelie()
        }
    }
}