package com.example.amanlearnkotlin.com.example.amanlearnkotlin

// THE SUBJECT IMPLEMENTATION
// Instead of keeping a list of interface objects, this class stores a list of functions!
class LambdaStockMarket {

    // We store the listeners as function signatures that take a Double and return nothing (Unit)
    private val listeners = mutableListOf<(Double) -> Unit>()

    var currentPrice: Double = 0.0
        set(value) {
            field = value
            // Whenever the price changes, we broadcast the new value to all lambdas
            notifyAllListeners(value)
        }

    // Anyone can register by simply passing a lambda block
    fun observePriceChanges(listener: (Double) -> Unit) {
        listeners.add(listener)
    }

    private fun notifyAllListeners(price: Double) {
        // We iterate through our list of functions and execute each one with the new price
        for (listener in listeners) {
            listener(price)
        }
    }
}


// Running our lambda-based reactive tracking environment
fun main() {
    val marketEngine = LambdaStockMarket()

    // Observer 1: Registering a quick console logger inline using lambda syntax
    marketEngine.observePriceChanges { freshPrice ->
        println("Console Logger: Received fresh market feed tracking value -> $$freshPrice")
    }

    // Observer 2: Registering a separate UI display update logic inline
    marketEngine.observePriceChanges { freshPrice ->
        println("Mobile Screen Display: Redrawing currency graph widget instantly for $$freshPrice")
    }

    println("System Ready: Triggering a price shift on our data provider...")

    // Updating the property automatically alerts both separate lambda blocks down below
    marketEngine.currentPrice = 599.99

    marketEngine.currentPrice = 612.50
}