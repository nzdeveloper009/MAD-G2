package com.example.amanlearnkotlin.com.example.amanlearnkotlin

// THE BASE CONTRACT
// This is the common interface that both the core object and all decorators must implement.
interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

// THE CONCRETE CORE OBJECT
// This is the simple baseline implementation that we want to add extra features to.
class SimpleCoffee : Coffee {
    override fun getCost(): Double = 2.0
    override fun getDescription(): String = "Plain Coffee"
}


// THE MODERN KOTLIN DECORATOR: Using Class Delegation
// Instead of manually forwarding every single method call to a wrapped object,
// Kotlin's 'by' keyword tells the compiler to automatically delegate all interface
// calls to the inner delegate object. We only override what we want to modify!

// Decorator 1: Adding a Milk upgrade
class MilkDecorator(private val innerCoffee: Coffee) : Coffee by innerCoffee {
    // We override getCost to add the price of milk to whatever coffee is underneath
    override fun getCost(): Double {
        return innerCoffee.getCost() + 0.5
    }

    // We append our description to the base coffee description
    override fun getDescription(): String {
        return innerCoffee.getDescription() + ", with Milk"
    }
}

// Decorator 2: Adding a Sugar upgrade
class SugarDecorator(private val innerCoffee: Coffee) : Coffee by innerCoffee {
    override fun getCost(): Double {
        return innerCoffee.getCost() + 0.2
    }

    override fun getDescription(): String {
        return innerCoffee.getDescription() + ", with Sugar"
    }
}


// Running our wrapped, decorated runtime environment
fun main() {
    // We start with a basic plain coffee instance
    val baseOrder: Coffee = SimpleCoffee()
    println("${baseOrder.getDescription()} costs $${baseOrder.getCost()}")

    // We wrap our plain coffee inside the Milk decorator seamlessly
    val milkOrder: Coffee = MilkDecorator(baseOrder)
    println("${milkOrder.getDescription()} costs $${milkOrder.getCost()}")

    // We take our milk coffee and wrap it AGAIN inside a Sugar decorator.
    // This forms a chain of behaviors running sequentially behind the scenes!
    val fullyLoadedOrder: Coffee = SugarDecorator(milkOrder)
    println("${fullyLoadedOrder.getDescription()} costs $${fullyLoadedOrder.getCost()}")
}