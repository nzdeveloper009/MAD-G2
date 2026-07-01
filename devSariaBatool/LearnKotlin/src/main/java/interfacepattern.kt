
interface Parts {
    val selfPrice: Int
    val totalCost: Int
}

// 2. Wheelbase Component
class Wheelbase(val size: Size) : Parts {
    enum class Size {
        SMALL, MEDIUM, BIG
    }

    override val selfPrice: Int
        get() = when (size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.BIG -> 175000
        }

    override val totalCost: Int
        get() = selfPrice
}

// 3. Chassis Component
class Chassis(val type: Type) : Parts {
    enum class Type {
        HATCHBACK, SEDAN, SUV, PICKUP
    }

    override val selfPrice: Int
        get() = when (type) {
            Type.HATCHBACK -> 150000
            Type.SEDAN -> 200000
            Type.SUV -> 250000
            Type.PICKUP -> 300000
        }

    override val totalCost: Int
        get() = selfPrice
}

// 4. Transmission Component
class Transmission(val type: Type) : Parts {
    enum class Type {
        FORWARD_WHEEL_DRIVE, REAR_WHEEL_DRIVE, ALL_WHEEL_DRIVE, FOUR_BY_FOUR
    }

    override val selfPrice: Int
        get() = when (type) {
            Type.FORWARD_WHEEL_DRIVE -> 75000
            Type.REAR_WHEEL_DRIVE -> 90000
            Type.ALL_WHEEL_DRIVE -> 110000
            Type.FOUR_BY_FOUR -> 130000 // default placeholder for 4x4
        }

    override val totalCost: Int
        get() = selfPrice
}

// 5. Engine Component (Injected with Transmission)
class Engine(val type: Type, val transmission: Transmission) : Parts {
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

    // Engine total cost includes its own price + the transmission it uses
    override val totalCost: Int
        get() = selfPrice + transmission.totalCost
}

// 6. Basic implementation for testing (Main Function)
fun main() {
    // Example: Configuring a sedan car with a diesel engine and all-wheel drive
    val myChassis = Chassis(Chassis.Type.SEDAN)
    val myWheelbase = Wheelbase(Wheelbase.Size.MEDIUM)
    val myTransmission = Transmission(Transmission.Type.ALL_WHEEL_DRIVE)
    val myEngine = Engine(Engine.Type.DIESEL, myTransmission)

    println("Chassis Price: ${myChassis.selfPrice}")
    println("Wheelbase Price: ${myWheelbase.selfPrice}")
    println("Engine Base Price: ${myEngine.selfPrice}")
    println("Transmission Price: ${myTransmission.selfPrice}")
    println("Engine Total Cost (with Transmission): ${myEngine.totalCost}")
}