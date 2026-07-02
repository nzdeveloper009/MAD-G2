package com.learning.learnkotlin

class Chassis constructor(
    val chassisType: String,
    val cChassisFactory: String
) {
    // Companion object ke andar Builder interface/class ya factory methods hote hain
    companion object {
        fun builder(): ChassisBuilder {
            return ChassisBuilder()
        }
    }

    override fun toString(): String {
        return "Chassis(chassisType='$chassisType', cChassisFactory='$cChassisFactory')"
    }
}

// 2. ChassisBuilder class jo object construct karne mein madad karti hai
class ChassisBuilder {
    private var chassisType: String = "Default Type"
    private var cChassisFactory: String = "Default Factory"

    // Method chaining ke liye 'this' (current builder object) return kiya jata hai
    fun setChassisType(type: String): ChassisBuilder {
        this.chassisType = type
        return this
    }

    fun setCChassisFactory(factory: String): ChassisBuilder {
        this.cChassisFactory = factory
        return this
    }

    // Final build function jo original Chassis ka object return karta hai
    fun build(): Chassis {
        // Yahan par custom rules ya internal constructor call ho sakti hai
        return Chassis(chassisType, cChassisFactory)
    }


}

// 3. Main function jahan code run hoga
fun main() {
    // Builder pattern ka use karke object creation aur method chaining
    val myChassis = Chassis.builder()
        .setChassisType("SUV Premium")
        .setCChassisFactory("Factory-XYZ")
        .build()

    println(myChassis)
}