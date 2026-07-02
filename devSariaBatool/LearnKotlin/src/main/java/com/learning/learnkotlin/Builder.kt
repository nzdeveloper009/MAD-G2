package com.learning.learnkotlin
enum class ChassisType {
    HATCHBACK, SEDAN, SUV, PICKUP
}

class Wheelbase(val size: Int)
class Engine(val power: String)

// 2. Chassis class aur uska Builder
class Chassis private constructor(val type: ChassisType, val seatCount: Int) {

    // Builder class for Chassis
    class Builder {
        private var type: ChassisType = ChassisType.SEDAN
        private var seatCount: Int = 4

        fun setType(type: ChassisType) = apply { this.type = type }
        fun setSeatCount(count: Int) = apply { this.seatCount = count }

        fun build(): Chassis {
            return Chassis(type, seatCount)
        }
    }
}

// 3. Main Vehicle class jisko hum Builder pattern ke zariye banayenge
class Vehicle private constructor(
    val wheelbase: Wheelbase?,
    val chassis: Chassis?,
    val engine: Engine?
) {
    // Builder class for Vehicle
    class Builder {
        private var wheelbase: Wheelbase? = null
        private var chassis: Chassis? = null
        private var engine: Engine? = null

        fun setWheelbase(wheelbase: Wheelbase) = apply { this.wheelbase = wheelbase }
        fun setChassis(chassis: Chassis) = apply { this.chassis = chassis }
        fun setEngine(engine: Engine) = apply { this.engine = engine }

        fun build(): Vehicle {
            return Vehicle(wheelbase, chassis, engine)
        }
    }

    fun showDetails() {
        println("Vehicle configuration built successfully!")
        println("Chassis Type: ${chassis?.type}, Seats: ${chassis?.seatCount}")
        println("Wheelbase Size: ${wheelbase?.size}")
        println("Engine: ${engine?.power}")
    }
}

// 4. Main function jahan video wala logic aur Builder pattern ka use dikhaya gaya hai
fun main() {
    // Vehicle Builder ka object initialize karte hain
    val vehicleBuilder = Vehicle.Builder()

    // --- Video ke mutabiq Console Input Logic ---
    println("Enter chassis type (h for Hatchback, s for Sedan, v for SUV, p for Pickup):")
    // Demo ke liye hum input simulate kar rahe hain (Misaal ke tor par 'v' for SUV)
    val input = "v"

    val selectedType = when (input.lowercase()) {
        "h" -> ChassisType.HATCHBACK
        "s" -> ChassisType.SEDAN
        "v" -> ChassisType.SUV
        "p" -> ChassisType.PICKUP
        else -> ChassisType.SEDAN
    }

    println("Enter number of seats:")
    val seatsInput = 5 // Simulating input

    // Chassis ka apna builder use karke chassis object banate hain
    val chassis = Chassis.Builder()
        .setType(selectedType)
        .setSeatCount(seatsInput)
        .build()

    // Baki parts create karte hain
    val wheelbase = Wheelbase(17)
    val engine = Engine("V8")

    // --- Builder Pattern ka Faida ---
    // Video mai bataya gaya ke main function mai temporary variables rakhne ke bajaye
    // hum step-by-step direct builder mai values set kar sakte hain:
    val myVehicle = vehicleBuilder
        .setChassis(chassis)
        .setWheelbase(wheelbase)
        .setEngine(engine)
        .build() // Final object ready ho gaya

    // Details print karte hain
    myVehicle.showDetails()
}