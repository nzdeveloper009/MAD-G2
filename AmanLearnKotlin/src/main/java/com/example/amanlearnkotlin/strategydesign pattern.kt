package com.example.amanlearnkotlin.com.example.amanlearnkotlin

// THE FUNCTIONAL CONTEXT CLASS
// Notice that we don't declare an interface anymore!
// Instead, our context expects a function type: (Double) -> Double
// This signature says: "Pass me any function that takes a Double (price) and returns a Double (discounted price)."
class DiscountApplier(private var discountStrategy: (Double) -> Double) {

    // We can swap the active strategy function anytime at runtime
    fun updateStrategy(newStrategy: (Double) -> Double) {
        this.discountStrategy = newStrategy
    }

    fun calculateFinalPrice(originalPrice: Double): Double {
        // We execute the strategy function just like a regular method call
        return discountStrategy(originalPrice)
    }
}


// Running our functional strategy setup
fun main() {
    val totalBill = 100.0

    // Strategy 1: Regular customer gets no discount. We pass an inline lambda that returns the value as-is.
    val regularStrategy = { price: Double -> price }
    val checkout = DiscountApplier(regularStrategy)
    println("Regular total: $${checkout.calculateFinalPrice(totalBill)}")

    // Strategy 2: Student gets 10% off. We update the strategy using an inline lambda block.
    checkout.updateStrategy { price -> price * 0.90 }
    println("Student total: $${checkout.calculateFinalPrice(totalBill)}")

    // Strategy 3: Eid Special gets a flat $20 off.
    // Because it's a standard function signature, we can pass any matching algorithm on the fly.
    checkout.updateStrategy { price -> price - 20.0 }
    println("Eid Special total: $${checkout.calculateFinalPrice(totalBill)}")
}