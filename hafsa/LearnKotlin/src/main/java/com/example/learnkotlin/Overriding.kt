package com.example.learnkotlin

fun main() {
    var obj = Dog()
    obj.Sound()


    var obj2 = circle(5.0)
    obj2.area()
}


open class Animal{
    open fun Sound()= println("Animal makes sound")
}
class Dog: Animal(){
    override fun Sound() {

        super.Sound()
        println("Dog is barking")
    }
}

open class shape{
    open fun area()=println("Area is calculating")
}
class circle(var r: Double) : shape(){
    override fun area(){
        println(Math.PI*r*r)
    }
}
class rectangle(var l:Double,var w:Double):shape(){
    override fun area(){
        println(l*w)
    }
}