// 1. Common Interface for Parts
interface Part {
    val selfPrice: Int
    val totalCost: Int
}

// 2. Seats Component (Added as per video logic)
class Seat : Parts {
    override val selfPrice: Int get() = 5000 // Placeholder price for a seat
    override val totalCost: Int get() = selfPrice
}

// 3. Wheel Component (Added as per video logic)
class Wheel : Parts {
    override val selfPrice: Int get() = 4000 // Placeholder price for a wheel
    override val totalCost: Int get() = selfPrice
}

// 4. Transmission Component
class Transmissions(val type: Type) : Parts {
    enum class Type {
        FORWARD_WHEEL_DRIVE, REAR_WHEEL_DRIVE, ALL_WHEEL_DRIVE
    }

    override val selfPrice: Int
        get() = when (type) {
            Type.FORWARD_WHEEL_DRIVE -> 75000
            Type.REAR_WHEEL_DRIVE -> 90000
            Type.ALL_WHEEL_DRIVE -> 110000
        }

    override val totalCost: Int get() = selfPrice
}

// 5. Engine Component (Includes Transmission)
class Engines(val type: Type, val transmission: Transmission) : Parts {
    enum class Type {
        PETROL, DIESEL, HYBRID, ELECTRIC
    }

    override val selfPrice: Int
        get() = when (type) {
            Type.PETROL -> 100000
            Type.DIESEL -> 200000
            Type.ELECTRIC -> 400000
            Type.HYBRID -> 500000
        }

    // Engine total cost = self price + transmission cost
    override val totalCost: Int
        get() = selfPrice + transmission.totalCost
}

// 6. Chassis Component (Includes Seats)
class chassis(val type: Type) : Parts {
    enum class Type {
        HATCHBACK, SEDAN, SUV, PICKUP
    }

    // Dummy seats list inside Chassis for calculation as mentioned in video
    val seats = listOf(Seat(), Seat(), Seat(), Seat(), Seat()) // 5 Seats

    override val selfPrice: Int
        get() = when (type) {
            Type.HATCHBACK -> 150000
            Type.SEDAN -> 200000
            Type.SUV -> 250000
            Type.PICKUP -> 300000
        }

    // Chassis total cost = self price + sum of all seats total cost
    override val totalCost: Int
        get() = selfPrice + seats.sumOf { it.totalCost }
}

// 7. Wheelbase Component (Includes Chassis and Wheels)
class Wheelbases(val size: Size, val chassis: Chassis) : Parts {
    enum class Size {
        SMALL, MEDIUM, BIG
    }

    // Dummy wheels list inside Wheelbase for calculation
    val wheels = listOf(Wheel(), Wheel(), Wheel(), Wheel()) // 4 Wheels

    override val selfPrice: Int
        get() = when (size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.BIG -> 175000
        }

    // Wheelbase total cost = self price + chassis cost + sum of all wheels total cost
    override val totalCost: Int
        get() = selfPrice + chassis.totalCost + wheels.sumOf { it.totalCost }
}

// 8. Vehicle Class (Main Composition Wrapper)
class Vehicle(val wheelbase: Wheelbase, val engine: Engine) {
    // Vehicle price = wheelbase total cost + engine total cost
    val price: Int
        get() = wheelbase.totalCost + engine.totalCost
}

// 9. Main Function - Testing Both Vehicles From The Video
fun main() {
    // --- 1. Honda City Configuration ---
    // Medium Wheelbase, Sedan Chassis, Diesel Engine, All-Wheel Drive
    val hondaCitychassis = Chassis(Chassis.Type.SEDAN)
    val hondaCityWheelbases = Wheelbase(Wheelbase.Size.MEDIUM)
    val hondaCityTransmissions = Transmission(Transmission.Type.ALL_WHEEL_DRIVE)
    val hondaCityEngine = Engine(Engine.Type.DIESEL, hondaCityTransmissions)

    val hondaCity = Vehicle(hondaCityWheelbases, hondaCityEngine)
    println("Honda City cost: ${hondaCity.price}")

    // --- 2. EcoSport Configuration ---
    // Small Wheelbase, SUV Chassis, Petrol Engine, Forward-Wheel Drive
    val ecoSportchassis = Chassis(Chassis.Type.SUV)
    val ecoSportWheelbases = Wheelbase(Wheelbase.Size.SMALL)
    val ecoSportTransmissions = Transmission(Transmission.Type.FORWARD_WHEEL_DRIVE)
    val ecoSportEngine = Engine(Engine.Type.PETROL, ecoSportTransmissions)

    val ecoSport = Vehicle(ecoSportWheelbases, ecoSportEngine)
    println("EcoSport cost: ${ecoSport.price}")
}