package com.example.learnkotlin

// no client should be forced to depend on methods it does not use

/*interface PaymentProcessor {

    fun processPayment(amount: Double)

    fun refundPayment(amount: Double)

    fun applyDiscount(discount: Double)
}

class BankTransfer : PaymentProcessor {

    override fun processPayment(amount: Double) {
        println("Bank Transfer Payment: Rs. $amount")
    }

    override fun refundPayment(amount: Double) {
        println("Refund through Bank Transfer")
    }

    override fun applyDiscount(discount: Double) {
        println("Bank Transfer does not support discounts")
    }
}

class CreditCard : PaymentProcessor {

    override fun processPayment(amount: Double) {
        println("Credit Card Payment: Rs. $amount")
    }

    override fun refundPayment(amount: Double) {
        println("Refund through Credit Card")
    }

    override fun applyDiscount(discount: Double) {
        println("Credit Card does not support discounts")
    }
}*/

// ISP violated


//after ISP

interface PaymentProcessor {

    fun processPayment(amount: Double)

    fun refundPayment(amount: Double)
}

interface DiscountApplicable {

    fun applyDiscount(discount: Double)
}

class BankTransfer : PaymentProcessor {

    override fun processPayment(amount: Double) {
        println("Bank Transfer Payment: Rs. $amount")
    }

    override fun refundPayment(amount: Double) {
        println("Refund through Bank Transfer")
    }
}

class CreditCard : PaymentProcessor {

    override fun processPayment(amount: Double) {
        println("Credit Card Payment: Rs. $amount")
    }

    override fun refundPayment(amount: Double) {
        println("Refund through Credit Card")
    }
}

class PayPal : PaymentProcessor, DiscountApplicable {

    override fun processPayment(amount: Double) {
        println("PayPal Payment: Rs. $amount")
    }

    override fun refundPayment(amount: Double) {
        println("Refund through PayPal")
    }

    override fun applyDiscount(discount: Double) {
        println("Discount Applied: $discount%")
    }
}

fun main() {

    val payment: PaymentProcessor = PayPal()
    payment.processPayment(5000.0)
    payment.refundPayment(1000.0)

    val discount: DiscountApplicable = PayPal()
    discount.applyDiscount(10.0)
}