package com.learning.learnkotlin

//No client should be forced to depend on methods it does not use.
import java.lang.UnsupportedOperationException

interface PaymentProcessor {
    fun processPayment(amount: Double)
    fun refundPayment(amount: Double)
    fun applyDiscount() // Har payment type discount support nahi karta
}

class CreditCardPayment : PaymentProcessor {
    override fun processPayment(amount: Double) {
        println("Processing Credit Card payment of $amount")
    }

    override fun refundPayment(amount: Double) {
        println("Refunding Credit Card payment of $amount")
    }

    override fun applyDiscount() {
        // Credit card doesn't support direct discount here
        throw UnsupportedOperationException("Discount not supported for Credit Card")
    }
}
interface BasicPayment {
    fun processPayment(amount: Double)
    fun refundPayment(amount: Double)
}

// Separate interface for discounts
interface Discountable {
    fun applyDiscount(couponCode: String)
}

// Ab CreditCard sirf wahi implement karega jo use chahiye
class RefactoredCreditCard : BasicPayment {
    override fun processPayment(amount: Double) {
        println("Refactored: Processing Credit Card payment of $amount")
    }

    override fun refundPayment(amount: Double) {
        println("Refactored: Refunding Credit Card payment of $amount")
    }
}

// Agar koi payment method discount support karta hai, toh wo dono use karega
class GiftCardPayment : BasicPayment, Discountable {
    override fun processPayment(amount: Double) {
        println("Processing Gift Card payment")
    }

    override fun refundPayment(amount: Double) {
        println("Refunding Gift Card payment")
    }

    override fun applyDiscount(couponCode: String) {
        println("Applied discount using coupon: $couponCode")
    }
}

fun main() {
    val card = RefactoredCreditCard()
    card.processPayment(500.0)

    val giftCard = GiftCardPayment()
    giftCard.applyDiscount("SAVE10")
}