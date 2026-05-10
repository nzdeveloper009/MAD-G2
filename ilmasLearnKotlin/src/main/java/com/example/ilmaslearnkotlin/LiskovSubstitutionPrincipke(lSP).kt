package com.example.ilmaslearnkotlin

//Objects of a superclass should be replaceable with objects of
// its subclasses without breaking the program.


// without LSP
//open class PaymentMethod {
//    open fun pay(amount: Double) {
//        println("Paid $amount")
//    }
//
//    open fun refund(amount: Double) {
//        println("Refunded $amount")
//    }
//}
//
//class CreditCard : PaymentMethod() {
//    override fun pay(amount: Double) {
//        println("Paid $amount using Credit Card")
//    }
//
//    override fun refund(amount: Double) {
//        println("Refunded $amount to Credit Card")
//    }
//}
//
//class GiftCard : PaymentMethod() {
//    override fun pay(amount: Double) {
//        println("Paid $amount using Gift Card")
//    }
//
//    override fun refund(amount: Double) {
//        throw UnsupportedOperationException("Gift cards are non-refundable")
//    }
//}
//
//fun processRefund(payment: PaymentMethod, amount: Double) {
//    payment.refund(amount)
//}


open class PaymentMethod {
    open fun pay(amount: Double) {
        println("Paid $amount")
    }
}

interface Refundable {
    fun refund(amount: Double)
}

class CreditCard : PaymentMethod(), Refundable {
    override fun pay(amount: Double) {
        println("Paid $amount using Credit Card")
    }

    override fun refund(amount: Double) {
        println("Refunded $amount to Credit Card")
    }
}

class GiftCard : PaymentMethod() {
    override fun pay(amount: Double) {
        println("Paid $amount using Gift Card")
    }
}

fun processRefund(payment: Refundable, amount: Double) {
    payment.refund(amount)
}
fun main() {
    // without LSP
   // val giftCard = GiftCard()
    //processRefund(giftCard, 50.0) //  Crash!

    val creditCard = CreditCard()
    processRefund(creditCard, 50.0) //  Works

    val giftCard = GiftCard()
     //processRefund(giftCard, 50.0)// Compile-time error (good!)
}
