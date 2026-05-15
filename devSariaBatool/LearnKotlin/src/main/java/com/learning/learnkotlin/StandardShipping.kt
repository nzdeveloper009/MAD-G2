package com.learning.learnkotlin;

// to create scalable, maintainable software solid,dry(do not repeat yourself),
// SOC(ik cheez ik jaga pr rhy)
// Encapsulation what varies(jo cheez change ho rhi usy alag kr do q k future mai
//b changings aty rhy gy)
//cohesion(limited cheezo ko aik module mai dal do)
//coupling(2 module aps mai kis tara couple hai tightly or lose)

//principles: set of rules follow to create a good design
//pattern: context specific(ak problem ka liya solutions,repeatable solutions )
//solid principles(SRP,OCP,LSP,ISP,DIP)

open class StandardShipping(
        protected  val destination:String,
        protected val weight:Double
){
    open fun calculateCost(): Double {
    return weight * 15
}

    open fun getDetails(): String {
        return "Standard Shipping to $destination for weight ${weight}kg"
    }
}

class ShipmentServices {
    // mutableListOf<StandardShipping>() Java ki ArrayList ki tarah kaam karta hai
    private val shipments = mutableListOf<StandardShipping>()

    fun addShipment(shipment: StandardShipping) {
        shipments.add(shipment)
    }

    fun displayAllShipments() {
        for (shipment in shipments) {
            println(shipment.getDetails())
        }
    }

    fun calculateShippingCost(): Double {
        var totalCost = 0.0
        for (shipment in shipments) {
            totalCost += shipment.calculateCost()
        }
        return totalCost

        // Pro-tip: Aap is poore loop ki jagah Kotlin ka built-in function bhi use kar sakte hain:
        // return shipments.sumOf { it.calculateCost() }
    }
}

fun main(args: Array<String>) {
    val s1 = StandardShipping("Gujrat", 21.0)
    val s2 = StandardShipping("karachi", 50.0)
    val s3 = StandardShipping("lahore", 31.0)
    val s4 = StandardShipping("Isl", 40.0)

    val services = ShipmentServices()
    services.addShipment(s1)
    services.addShipment(s2)
    services.addShipment(s3)
    services.addShipment(s4)

    services.displayAllShipments()
    println(services.calculateShippingCost())
}



