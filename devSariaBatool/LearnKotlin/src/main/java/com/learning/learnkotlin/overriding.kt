package com.learning.learnkotlin

fun main() {
     val oneplus = OnePlus("Smartphone")
    oneplus.display()
    val generalMobile= Mobile("General")
    generalMobile.display()
    println(oneplus.toString())
}
//any is super class
open class Mobile( val type:String){
     open val name:String=""
     open val size:Int=5
    fun makecall() = println("Calling from mobile")
    fun poweroff() = println("Shutting down")
    open fun display() = println("Simple Mobile Displays")
}

class OnePlus(typeParam:String):Mobile(typeParam){
    override val name: String="One Plus"
    override val size: Int =6
    override fun display(){
        super.display()
        println("One plus Display")
    }

    override fun toString(): String {
        return "OnePlus(name='$name', size=$size)"
    }

}