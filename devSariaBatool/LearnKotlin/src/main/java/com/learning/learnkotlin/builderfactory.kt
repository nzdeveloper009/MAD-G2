package com.learning.learnkotlin

enum class EngineType { V8, V6, INLINE4 }
enum class Transmission { AUTOMATIC, MANUAL }
enum class ChassisType { HATCHBACK, SEDAN, SUV }
enum class Upholstery { LEATHER, FABRIC }
enum class Size { SMALL, MEDIUM, LARGE }

data class Wheel(val size: Size)
data class Seat(val upholstery: Upholstery)

// --- Components and Builders ---

// Engine Component
class Engine private constructor(val engineType: EngineType, val transmission: Transmission) {
    class Builder {
        private lateinit var engineType: EngineType
        private lateinit var transmission: Transmission

        fun setEngineType(engineType: EngineType): Builder {
            this.engineType = engineType
            return this
        }

        fun setTransmission(transmission: Transmission): Builder {
            this.transmission = transmission
            return this
        }

        fun build(): Engine {
            return Engine(this.engineType, this.transmission)
        }
    }
}

// Wheel Factory (Creates multiple wheels as a list)
class WheelFactory(private val size: Size) {
    fun createWheels(number: Int): List<Wheel> {
        return generateSequence { Wheel(size) }.take(number).toList()
    }
}

// WheelBase Component
class WheelBase private constructor(val size: Size, val chassisType: ChassisType, val wheels: List<Wheel>) {
    class Builder {
        private lateinit var size: Size
        private lateinit var chassisType: ChassisType
        private lateinit var wheelFactory: WheelFactory
        private var spareWheel: Boolean = false

        fun setSize(size: Size): Builder {
            this.size = size
            return this
        }

        fun setChassisType(chassisType: ChassisType): Builder {
            this.chassisType = chassisType
            return this
        }

        fun setWheelFactory(wheelFactory: WheelFactory): Builder {
            this.wheelFactory = wheelFactory
            return this
        }

        fun setSpareWheel(spareWheel: Boolean): Builder {
            this.spareWheel = spareWheel
            return this
        }

        fun build(): WheelBase {
            val numWheels = if (spareWheel) 5 else 4 // 4 regular wheels + 1 optional spare wheel
            val generatedWheels = wheelFactory.createWheels(numWheels)
            return WheelBase(this.size, this.chassisType, generatedWheels)
        }
    }
}

// Seat Factory (Creates multiple seats as a list)
class SeatFactory(private val upholstery: Upholstery) {
    fun createSeats(numSeats: Int): List<Seat> {
        return generateSequence { Seat(upholstery) }.take(numSeats).toList()
    }
}

// Chassis Component
class Chassis private constructor(val chassisType: ChassisType, val seats: List<Seat>) {
    class Builder {
        private lateinit var chassisType: ChassisType
        private lateinit var seatFactory: SeatFactory

        fun setChassisType(chassisType: ChassisType): Builder {
            this.chassisType = chassisType
            return this
        }

        fun setSeatFactory(seatFactory: SeatFactory): Builder {
            this.seatFactory = seatFactory
            return this
        }

        fun build(): Chassis {
            val numSeats = when (chassisType) {
                ChassisType.HATCHBACK -> 4
                ChassisType.SEDAN -> 5
                ChassisType.SUV -> 7
            }
            val generatedSeats = seatFactory.createSeats(numSeats)
            return Chassis(this.chassisType, generatedSeats)
        }
    }
}

// --- Main Execution (CLI Implementation Example) ---
fun main() {
    // 1. Engine Builder Example
    val engine = Engine.Builder()
        .setEngineType(EngineType.V8)
        .setTransmission(Transmission.AUTOMATIC)
        .build()

    // 2. Chassis Builder with Seat Factory Example
    val seatFactory = SeatFactory(Upholstery.LEATHER)
    val chassis = Chassis.Builder()
        .setChassisType(ChassisType.SEDAN)
        .setSeatFactory(seatFactory)
        .build()

    // 3. WheelBase Builder with Wheel Factory Example
    val wheelFactory = WheelFactory(Size.MEDIUM)
    val wheelBase = WheelBase.Builder()
        .setSize(Size.MEDIUM)
        .setChassisType(ChassisType.SEDAN)
        .setWheelFactory(wheelFactory)
        .setSpareWheel(true)
        .build()

    // Verification Output
    println("Engine Configured: ${engine.engineType} with ${engine.transmission} transmission.")
    println("Chassis Created: ${chassis.chassisType} with ${chassis.seats.size} seats.")
    println("WheelBase Setup: Size ${wheelBase.size}, Total Wheels manufactured: ${wheelBase.wheels.size}")
}