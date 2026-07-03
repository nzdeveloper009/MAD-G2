package com.example.amanlearnkotlin.com.example.amanlearnkotlin

abstract class ShippingMethod(
    val destination: String,
    val weight: Double
) {
    abstract fun calculateCost(): Double
    abstract fun getDetails(): String
}

// Standard shipping: Normal delivery speed, baseline pricing.
class StandardShipping(destination: String, weight: Double) : ShippingMethod(destination, weight) {
    override fun calculateCost(): Double {
        return weight * 15.0 // Flat rate of $15 per kg
    }

    override fun getDetails(): String {
        return "Standard Delivery to $destination (${weight}kg)"
    }
}

// Express shipping: Faster turnaround, premium price point.
class ExpressShipping(destination: String, weight: Double) : ShippingMethod(destination, weight) {
    override fun calculateCost(): Double {
        return weight * 40.0 // Premium rate of $40 per kg
    }

    override fun getDetails(): String {
        return "Express 24-48h Delivery to $destination (${weight}kg)"
    }
}

// Click and Collect / Store Pickup: Customer handles the last mile, so no shipping fee.
class StorePickUp(destination: String, weight: Double) : ShippingMethod(destination, weight) {
    override fun calculateCost(): Double {
        return 0.0 // Free since they are picking it up themselves
    }

    override fun getDetails(): String {
        return "Self-Pickup from $destination branch"
    }
}

// This manager class handles orders polymorphically.
// It doesn't care what kind of shipping is used; it just processes them uniformly.
class ShipmentService {
    // Using a mutable list so we can dynamically add items as orders roll in
    private val shipments = mutableListOf<ShippingMethod>()

    fun addShipment(shippingMethod: ShippingMethod) {
        shipments.add(shippingMethod)
    }

    fun displayAllShipments() {
        if (shipments.isEmpty()) {
            println("No active shipments to display.")
            return
        }

        for (shipment in shipments) {
            // Polymorphism does the heavy lifting here.
            // Kotlin automatically resolves the correct child methods at runtime.
            println("${shipment.getDetails()} -> Fee: $${shipment.calculateCost()}")
        }
    }

    fun calculateTotalShippingCost(): Double {
        // Simple idiomatic way to loop through and sum up the costs
        return shipments.sumOf { it.calculateCost() }
    }
}

// Testing the setup
fun main() {
    val manager = ShipmentService()

    // Simulating a shopping cart checkout with mixed delivery choices
    manager.addShipment(StandardShipping("New York", 5.2))
    manager.addShipment(ExpressShipping("London", 2.0))
    manager.addShipment(StorePickUp("Downtown LA", 1.5))

    // Print out the manifest
    println("=== Processing Today's Shipments ===")
    manager.displayAllShipments()

    // Calculate total logistics cost
    val totalCost = manager.calculateTotalShippingCost()
    println("\nGrand Total Shipping Cost: $totalCost")
}