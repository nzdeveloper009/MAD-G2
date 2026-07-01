interface Part {
    val selfPrice: Int
    val totalCost: Int
}

// 2. Wheel Component with Inner Factory Pattern
class Wheel private constructor(val type: Type) : Parts {
    enum class Type {
        STEEL, ALLOY, CARBON_FIBER
    }

    override val selfPrice: Int
        get() = when (type) {
            Type.STEEL -> 10000
            Type.ALLOY -> 12000
            Type.CARBON_FIBER -> 20000
        }

    override val totalCost: Int get() = selfPrice

    // Factory class inside Wheel to safely create instances
    class Factory(val wheelType: Type) {
        fun createWheel(): Wheel {
            return Wheel(wheelType)
        }
    }
}

// 3. Seat Component with Inner Factory Pattern
class Seat private constructor(val upholstery: Upholstery) : Parts {
    enum class Upholstery {
        CLOTH, REXINE, LEATHER
    }

    override val selfPrice: Int
        get() = when (upholstery) {
            Upholstery.CLOTH -> 10000
            Upholstery.REXINE -> 15000
            Upholstery.LEATHER -> 20000
        }

    override val totalCost: Int get() = selfPrice

    // Factory class inside Seat to safely create instances
    class Factory(val upholsteryType: Upholstery) {
        fun createSeat(): Seat {
            return Seat(upholsteryType)
        }
    }
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

    override val totalCost: Int
        get() = selfPrice + transmission.totalCost
}

// 6. Chassis Component (Injected with Seat.Factory)
class chassis(val type: Type, val seatFactory: Seat.Factory) : Parts {
    enum class Type {
        HATCHBACK, SEDAN, SUV, PICKUP
    }

    // Creating 5 seats using the injected factory
    val seats = listOf(
        seatFactory.createSeat(),
        seatFactory.createSeat(),
        seatFactory.createSeat(),
        seatFactory.createSeat(),
        seatFactory.createSeat()
    )

    override val selfPrice: Int
        get() = when (type) {
            Type.HATCHBACK -> 150000
            Type.SEDAN -> 200000
            Type.SUV -> 250000
            Type.PICKUP -> 300000
        }

    override val totalCost: Int
        get() = selfPrice + seats.sumOf { it.totalCost }
}

// 7. Wheelbase Component (Injected with Wheel.Factory and Chassis)
class Wheelbases(val size: Size, val chassis: Chassis, val wheelFactory: Wheel.Factory) : Parts {
    enum class Size {
        SMALL, MEDIUM, BIG
    }

    // Creating 4 wheels using the injected factory
    val wheels = listOf(
        wheelFactory.createWheel(),
        wheelFactory.createWheel(),
        wheelFactory.createWheel(),
        wheelFactory.createWheel()
    )

    override val selfPrice: Int
        get() = when (size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.BIG -> 175000
        }

    override val totalCost: Int
        get() = selfPrice + chassis.totalCost + wheels.sumOf { it.totalCost }
}

// 8. Vehicle Class
class Vehicle(val wheelbase: Wheelbase, val engine: Engine) {
    val price: Int
        get() = wheelbase.totalCost + engine.totalCost
}

// 9. Main Function - Creating Vehicles with Factory Configuration
fun main() {
    // --- 1. Honda City (Sedan, Leather Seats, Steel Wheels, Diesel, All-Wheel Drive) ---
    val hondaCitySeatFactory = Seat.Factory(Seat.Upholstery.LEATHER)
    val hondaCityWheelFactory = Wheel.Factory(Wheel.Type.STEEL)

    val hondaCityChassis = Chassis(Chassis.Type.SEDAN)
    val hondaCityWheelbase = Wheelbase(Wheelbase.Size.MEDIUM)
    val hondaCityTransmission = Transmission(Transmission.Type.ALL_WHEEL_DRIVE)
    val hondaCityEngine = Engine(Engine.Type.DIESEL, hondaCityTransmission)

    val hondaCity = Vehicle(hondaCityWheelbase, hondaCityEngine)
    println("Honda City cost: ${hondaCity.price}")

    // --- 2. EcoSport (SUV, Rexine Seats, Alloy Wheels, Petrol, Forward-Wheel Drive) ---
    val ecoSportSeatFactory = Seat.Factory(Seat.Upholstery.REXINE)
    val ecoSportWheelFactory = Wheel.Factory(Wheel.Type.ALLOY)

    val ecoSportChassis = Chassis(Chassis.Type.SUV)
    val ecoSportWheelbase = Wheelbase(Wheelbase.Size.SMALL)
    val ecoSportTransmission = Transmission(Transmission.Type.FORWARD_WHEEL_DRIVE)
    val ecoSportEngine = Engine(Engine.Type.PETROL, ecoSportTransmission)

    val ecoSport = Vehicle(ecoSportWheelbase, ecoSportEngine)
    println("EcoSport cost: ${ecoSport.price}")
}