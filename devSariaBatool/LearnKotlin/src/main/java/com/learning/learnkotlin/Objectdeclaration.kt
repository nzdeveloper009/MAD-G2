package com.learning.learnkotlin

class Myclass {

    object MyObject {
        fun f() {
            println("I am called from MyObject inside MyClass")
        }
    }


    object AnotherObject {
        fun g() {
            println("I am called from AnotherObject")
        }
    }

    companion object {


        @JvmStatic
        fun f1() {
            println("I am called directly from MyClass via Companion Object")
        }
    }
}

fun main() {

    Myclass.MyObject.f()

    Myclass.AnotherObject.g()

    Myclass.f1()
}

