package com.example.ayeshalearnkotlin
// smart cast automatically identifies the type of obj based on the present scenario
//obj is declared of type "Any" which means inherited by Any class

fun main() {
    printLength("Hello")  // String length is 5
    printLength(123) // Not a string
    val obA = A()
    val obB = B()
    obB.test()
}

fun printLength(obj: Any) {
    //type checking by using is operator
    if (obj is String) {
        // Smart cast: obj is automatically treated as String here
        println("String length is ${obj.length}")
    } else {
        println("Not a string")
    }
}
//visibility modifiers
open class A{
    //if we do not write any modifier then by default its public , can be accessed everywhere

    public var p= 10
    //private:can only be accessed within the class
    //the "m" variable can't be accessed anywherer else except the class in which its declared.
    private var m = 20
    fun printm(){
        println(m)
    }
    //Internal:can be accessed anywhere within a module
    internal var r = 30
    //Protected: can only accessed in the same class and the classes driven from it
    protected var s=40}
    class B: A(){

        fun test(){
            println (p)
            println (r)
            println(s)
        }
    }

