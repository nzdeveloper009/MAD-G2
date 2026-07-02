package com.example.ayeshalearnkotlin
//before ocp
/*public class paymentmethod{
    fun payment(paymenttype: String){
     if(paymenttype=="card"){
         println("payment is through card")
     }
        else if(paymenttype=="cash"){
        println("payment is through cash")
     }
        else{
        println("invalid payment method")
     }
}*/
//after ocp
interface paymentmethod{
    fun pay(paymenttype: String)
}
class card: paymentmethod{
    override fun pay(paymenttype: String) {
        println("payment through card")
    }
}
class cash: paymentmethod {
    override fun pay(paymenttype: String) {
        println("payment through cash")
    }
}
    class onlinetransfer: paymentmethod {
        override fun pay(paymenttype: String) {
            println("payment is being online transfered")
        }
    }
fun main() {
    val payment:paymentmethod=cash()
    payment.pay("cash")
}