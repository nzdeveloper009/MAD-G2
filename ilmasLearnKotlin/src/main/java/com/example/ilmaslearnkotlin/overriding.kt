package com.example.ilmaslearnkotlin

fun main(){
    val oneplus= OnePlus("smart Phones")
    oneplus.display()
    println(oneplus.toString())


}
open class Mobile( val type: String){
    open val name:String=""
    open val size= 5
    fun makeCall(){
        println("Calling from Mobile")
    }
    fun powerOff(){
        println("shutting Down")
    }
    open fun display(){
        println("Simple Mobile display")
    }
}

class OnePlus( typeParam: String):Mobile(typeParam){
     override val name:String="one Plus"
     override val size= 6

    override fun display(){
        super.display()    //super keyword is used when we want to access the parent property or method
        println("One plus  display")
    }

    // any class
    //every kotlin class has any super class
    //any class hai many open methods that we can override
    //over-ride the methods from any class
    override fun toString():String {
      return "Name: $name - size: $size"
    }
}