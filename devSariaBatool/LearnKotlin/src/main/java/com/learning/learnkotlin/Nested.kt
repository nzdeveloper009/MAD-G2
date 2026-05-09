package com.learning.learnkotlin

class Outer {
    var i = 0
    class Nested {
        fun test() {
            println("I am in Nested Class")
            // println(i)
        }
    }


    inner class Inner {
        fun test() {
            println("I am in Inner Class and I can access i: $i")
        }
    }
}

fun main() {

    val nestedObj = Outer.Nested()
    nestedObj.test()

    val outerObj = Outer()
    outerObj.i = 10


    val innerObj = outerObj.Inner()
    innerObj.test()
}