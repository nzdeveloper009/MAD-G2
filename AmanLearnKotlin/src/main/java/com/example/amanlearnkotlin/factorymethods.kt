package com.example.amanlearnkotlin.com.example.amanlearnkotlin

// THE STRATEGY INTERFACE
// This defines the common contract that every single concrete strategy must follow.
interface PaymentStrategy {
    fun processPayment(amount: Double)
}


// THE CONCRETE STRATEGIES
// Each class handles one specific algorithm or logic path completely independently.

// Strategy 1: Handling standard credit card transactions
class CreditCardPayment : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Bank Gateway: Processing credit card transaction for $$amount")
    }
}

// Strategy 2: Handling modern digital wallet transactions
class PayPalPayment : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("PayPal Engine: Checking digital wallet balance and capturing $$amount")
    }
}

// Strategy 3: Handling crypto transactions (Added cleanly without breaking anything)
class CryptoPayment : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Blockchain Node: Initiating decentralized transfer block for $$amount")
    }
}


// THE CONTEXT CLASS
// This is our main checkout system. Notice how it doesn't hardcode any payment method.
// It just accepts a generic PaymentStrategy contract and executes it.
class CheckoutCart {

    // We can hold a reference to any strategy and change it dynamically at runtime
    private var activePaymentStrategy: PaymentStrategy? = null

    fun setPaymentMethod(strategy: PaymentStrategy) {
        this.activePaymentStrategy = strategy
    }

    fun completeCheckout(totalCost: Double) {
        // If no strategy is chosen, we handle the safety fallback cleanly
        val selectedStrategy = activePaymentStrategy
        if (selectedStrategy == null) {
            println("Checkout Warning: Please select a valid payment method first.")
            return
        }

        println("Checkout Engine: Preparing order items for processing...")
        selectedStrategy.processPayment(totalCost)
    }
}


// Running our interchangeable strategy runtime environment
fun main() {
    // Instantiating our main container context
    val cart = CheckoutCart()
    val cartTotal = 299.95

    // User selects Credit Card at runtime
    println("User Event: Selecting Credit Card option at checkout.")
    cart.setPaymentMethod(CreditCardPayment())
    cart.completeCheckout(cartTotal)

    // User changes mind and switches to PayPal instantly before checking out again
    println("User Event: Switching payment preference to PayPal.")
    cart.setPaymentMethod(PayPalPayment())
    cart.completeCheckout(cartTotal)
}