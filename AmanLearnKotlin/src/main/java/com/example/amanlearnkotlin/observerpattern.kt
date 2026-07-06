package com.example.amanlearnkotlin
import kotlin.properties.Delegates

// THE MODERN CLEAN APPROACH: Using Delegates.observable()
// Instead of a giant manager class tracking a mutable list of observers,
// we delegate the observation mechanics directly to the property itself.
class SmartStockMarket {

    // This built-in property delegate accepts an initial value and a lambda block.
    // The lambda provides three parameters: the property itself, the old value, and the new value.
    var currentPrice: Double by Delegates.observable(0.0) { property, oldValue, newValue ->

        // This block runs automatically whenever anyone assigns a new value to currentPrice.
        // It acts as our central notification dispatch center.
        println("Property Change Detected: ${property.name} changed from $$oldValue to $$newValue")

        // You can trigger your UI changes, Viewmodel updates, or background syncs straight from here
        broadcastToUi(newValue)
    }

    private fun broadcastToUi(price: Double) {
        println("Reactive Dispatcher: Pushing fresh data view update -> $$price")
    }
}


// A concrete UI observer component that handles display formatting
class SimpleDashboard {
    fun renderNewPrice(price: Double) {
        println("Dashboard Render: Redrawing chart with value $$price")
    }
}


// Running our property-delegated observation system
fun main() {
    // Initializing our clean reactive data carrier object
    val marketTicker = SmartStockMarket()
    val userScreen = SimpleDashboard()

    println("System Ready: Modifying the property value directly now...")

    // Watch how changing the value instantly executes our observer logic behind the scenes.
    // No manual registerObserver() or notifyObservers() calls are required!
    marketTicker.currentPrice = 250.75

    // We can update it again, and it triggers tracking effortlessly
    marketTicker.currentPrice = 255.00
}