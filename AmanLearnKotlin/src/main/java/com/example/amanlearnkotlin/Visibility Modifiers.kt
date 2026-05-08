package com.example.amanlearnkotlin

fun main() {
    val obj = B()
    obj.test()
}

open class A {
    public val a = 1      // Kahin se bhi access ho sakta hai
    private val b = 2     // Sirf isi class ke andar access hoga
    internal val c = 3    // Sirf isi module ke andar access hoga
    protected val d = 4   // Sirf isi class ya iski subclasses mein access hoga

    fun checkVisibility() {
        println(a)
        println(b)
        println(c)
        println(d)
    }
}

class B : A() {
    fun test() {
        println(a)
        // println(b) // Error: Kyunki b private hai
        println(c)
        println(d)    // Access ho jayega kyunki B, A ki subclass hai
    }
}

class C {
    fun test() {
        val objA = A()
        println(objA.a)
        // println(objA.b) // Error
        println(objA.c)
        // println(objA.d) // Error: Kyunki C, A ki subclass nahi hai
    }
}