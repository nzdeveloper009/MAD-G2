package com.example.ilmaslearnkotlin

fun main(){
        val childobj=Child()  //Parent class constructor is called before the child constructor called
         childobj.method()   // through the child object we can call the parent functions and use properties
         childobj.method2()

}
// characteristics or behaviors that inherit from parent class
// code reusability
// open keyword must be with parent class
// cannot inherit child from multiple classes

open class Parent{
    val name: String=""
    init{
        println("Parent's constructor called ")
    }
    fun method(){
        println("Parent function called")
    }

}
class Child:Parent(){
    val name2: String=""
    init{
        println("Child's constructor called ")
    }
    fun method2(){
        println(" Child function called")
    }

}