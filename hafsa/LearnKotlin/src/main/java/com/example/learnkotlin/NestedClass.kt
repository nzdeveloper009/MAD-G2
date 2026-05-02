package com.example.learnkotlin

fun main() {
    var obj=Outer.Nested()
    obj.display()

    // outer constructor call first
    var obj1 = Outer().Inner()
    obj1.display2()
}

class Outer{

    class Nested{
        fun display(){
            println("i'm in nested class")
        }
    }
    inner class Inner{
        fun display2(){
            print("i'm in inner class")
        }
    }
}