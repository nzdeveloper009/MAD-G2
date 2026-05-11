package com.example.lib
// interface Segregation principle
// NO client or sub class cant be force to give body of method if it implment a interface and it does not have that functionality

interface paymentprocess{
    fun processpayment(amount: Double)
    fun refendpayment(amount: Double)
    fun applydiscount(amount: Double)
}
class ceritcard: paymentprocess{
    override fun applydiscount(amount: Double) {
       throw IllegalArgumentException("NO DISCOUNT")
    }

    override fun processpayment(amount: Double) {
        println("process payment")
    }

    override fun refendpayment(amount: Double) {
        println("refund payment")
    }

}
class banktransfer: paymentprocess{
    override fun applydiscount(amount: Double) {
        throw IllegalArgumentException("NO DISCOUNT")
    }

    override fun processpayment(amount: Double) {
        println("process payment")
    }

    override fun refendpayment(amount: Double) {
        throw IllegalArgumentException("no refund in bank")
    }
}
//  solution
interface processPayment{
    fun processpayment(amount: Double)
}
interface refendpayment{
    fun refendpayment(amount: Double)

}
class ceritCard: processPayment{


    override fun processpayment(amount: Double) {
        println("process payment")
    }



}
class paypal: refendpayment{


    override fun refendpayment(amount: Double) {
        println("you can make refend")
    }
}