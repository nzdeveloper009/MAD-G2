package com.example.ayeshalearnkotlin

fun main() {
    //Object expression : when an object is initialized to a variable , its called object expression. We dont have to give a name to an object while making it an expression
    //object expression can be used to makr inner classes
    var obj1= object: Duration{
        override fun duration() {
            println("keep going")
        }
    }
    println(C.numm)
    D.test()
    obj1.duration()
    //for normal object in a class we have to call by the obj and the class
    My.ff.f()
    //for companion obj in a class , we dont have to reach it through obj , we can access directly .
    My.g()
}

interface Duration{
    fun duration()
}


/*Object declaration: it means declaring an object as a class , only one object can be made
of one type. for the classes where only one object is required we can make directly an object
using "Object" keyword instead of making a class*/
/*Singleton Pattern means restricting a class to make only one object. In kotlin, behind
 object declaration singleton pattern is working by default   */
    object C{
        val numm: Int = 10
    }
        object D{
            val p: Int = 20
            fun test(){
                println("I am Object B")
            }
        }
class My{
    //objects can be made inside a class , in this case that object is associated with the class
    object ff{
        fun f(){
            println("Object of f class")
        }
    }
    //companion objects are made to access the properties and method of the companion object to be accessed directly . one class can have only one companion.
    companion object gg{
        fun g(){
            println("object of companion class")
        }
    }
}