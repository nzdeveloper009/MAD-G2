package com.learning.learnkotlin

fun main() {
    val objBasicPhone= BasicPhone()
    objBasicPhone.mkeCall()
    objBasicPhone.getScreenInfo()
}
open class Phone{

    init {
        println("Parent constructor is called")
    }
    val name: String ="Nokia"
    val type:String="Basic 1100"
    val volume :Int = 10

    fun mkeCall(){
        println("Attend Call")
    }
    fun display(){}
    fun powerof(){}
    fun getDeviceInfo() {}
}


class BasicPhone: Phone(){
    init {
        println("Child constructor is called")
    }
    fun getScreenInfo(){
        println("Screen Info")
    }
}

class SmartPhone:Phone(){
    fun playMovie(){}
    fun takePicture(){
        println("Play Movie")
    }
    fun getlocation(){}
}