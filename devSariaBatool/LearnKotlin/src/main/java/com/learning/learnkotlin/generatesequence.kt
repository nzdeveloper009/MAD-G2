package com.learning.learnkotlin

// 1. Vehicle ke Types ka Enum
enum class VehicleType {
    HATCHBACK, SEDAN, SUV, PICKUP_TRUCK
}

// 2. Seat Model aur uski Factory
class Seat
object SeatFactory {
    fun createSeat(): Seat {
        return Seat()
    }
}

// 3. Wheel Model aur uski Factory
class Wheel
object WheelFactory {
    fun createWheel(): Wheel {
        return Wheel()
    }
}

// 4. Chassis Class (Jo gari ke type ke hisab se seats generate karti hai)
class Chassis(val type: VehicleType) {

    // VehicleType ke mutabik seats ki tadad tay karna [00:00:46]
    val numSeats: Int = when (type) {
        VehicleType.HATCHBACK -> 4
        VehicleType.SEDAN -> 5
        VehicleType.SUV -> 8
        VehicleType.PICKUP_TRUCK -> 6
    }

    // Sequence generator ka use kar ke seats ki list banana [00:01:19]
    val seats: List<Seat> = generateSequence {
        SeatFactory.createSeat()
    }.take(numSeats).toList()
}

// 5. Wheelbase Class (Jo spare wheel check kar ke wheels generate karti hai)
class Wheelbase(val spareWheel: Boolean = false) {

    // Agar spare wheel true ho toh 4 + 1 = 5 wheels, warna 4 wheels [00:03:53]
    val numWheels: Int = 4 + (if (spareWheel) 1 else 0)

    // Sequence generator ka use kar ke wheels ki list banana [00:02:16]
    val wheels: List<Wheel> = generateSequence {
        WheelFactory.createWheel()
    }.take(numWheels).toList()
}

// 6. Main Vehicle Class
class Vehicle(val type: VehicleType, val wheelbase: Wheelbase, val chassis: Chassis)

// 7. Testing ke liye Main Function
fun main() {
    // Bina spare wheel ke Honda City (Default false) [00:03:18]
    val hondaCityChassis = Chassis(VehicleType.SEDAN)
    val hondaCityWheelbase = Wheelbase(spareWheel = false)
    val hondaCity = Vehicle(VehicleType.SEDAN, hondaCityWheelbase, hondaCityChassis)

    println("Honda City seats: ${hondaCity.chassis.numSeats}")
    println("Honda City wheels: ${hondaCity.wheelbase.numWheels}")

    println("---------------------------------------------")

    // Spare wheel ke sath EcoSport (SUV) [00:03:24]
    val ecoSportChassis = Chassis(VehicleType.SUV)
    val ecoSportWheelbase = Wheelbase(spareWheel = true)
    val ecoSport = Vehicle(VehicleType.SUV, ecoSportWheelbase, ecoSportChassis)

    // EcoSport ke total wheels print karna [00:04:28]
    println("EcoSport seats: ${ecoSport.chassis.numSeats}")
    println("EcoSport wheels = ${ecoSport.wheelbase.numWheels}")
}