package com.example.amanlearnkotlin

fun main() {
    // Smartphone ka object banaya
    val myPhone = Smartphone()

    // Parent class (Phone) ke methods call ho rahe hain
    myPhone.makeCall()
    println("Phone volume is: ${myPhone.volume}")

    // Smartphone ke apne methods
    myPhone.playMovie()

    println("-------------------")

    // Child class (Child) ka object banaya
    val objChild = Child()
    objChild.myMethod()   // Parent ka method
    objChild.myMethod2()  // Child ka apna method
}

// 1. Phone Example Hierarchy
open class Phone {
    val name: String = ""
    val type: String = ""
    val volume: Int = 10 // Volume ko String ki bajaye Int rakha hai

    fun makeCall() { println("Making a call...") }
    fun display() { println("Displaying screen...") }
    fun powerOff() { println("Powering off...") }
    fun getDeviceInfo() { println("Getting info...") }
}

class Smartphone : Phone() {
    fun playMovie() { println("Playing movie...") }
    fun takePicture() { println("Taking picture...") }
    fun getLocation() { println("Getting location...") }
}

class BasicPhone : Phone() {
    fun getScreenInfo() { println("Screen info...") }
}

// 2. Parent-Child Example Hierarchy
open class Parent {
    val name: String = "Parent"

    init {
        println("Parent Constructor is called")
    }

    fun myMethod() {
        println("I am Parent")
    }
}

class Child : Parent() {
    val name2: String = "Child"

    init {
        println("Child Constructor is called")
    }

    fun myMethod2() {
        println("I am Child")
    }
}
