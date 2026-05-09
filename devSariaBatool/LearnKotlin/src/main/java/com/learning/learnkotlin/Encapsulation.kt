package com.learning.learnkotlin


fun topLevelFunction() {
    println("Main public function hoon")
}


internal class B


private class C

open class Base {
    var p = 10           // Public: Har jagah accessible
    private var q = 20   // Private: Sirf Base class ke andar
    internal var r = 30  // Internal: Isi module mein accessible
    protected var s = 40 // Protected: Sirf Base aur subclasses mein accessible
}

class Derived : Base() {
    fun test() {
        println(p) // OK (Public)
        println(r)
        println(s) // OK (Protected: Kyunke Derived subclass hai)
    }
}

class Student{
    private var age: Int = 0

    fun setAge(newAge: Int) {
        if (newAge > 0) {
            age = newAge
        } else {
            println("Age cant be negative!")
        }
    }

    fun getAge(): Int {
        return age
    }
}



fun main() {
    // Base class ka object
    val obj = Base()
    println("Public Property: ${obj.p}")
    println("Internal Property: ${obj.r}")
    // println(obj.q) // ERROR: Private hai
    // println(obj.s) // ERROR: Protected hai (main subclass nahi hai)

    val student = Student()
    student.setAge(21)
    println("Student Age: ${student.getAge()}")
}