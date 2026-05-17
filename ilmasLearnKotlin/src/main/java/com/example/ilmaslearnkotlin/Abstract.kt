package com.example.ilmaslearnkotlin

// ****abstract property
// a property whose value can not be initialized
// ****** abstract method
// whose body can not be defined
//****abstract method or abstract property must be in abstract class
// abstract-class can hold abstract and non-abstract properties and methods
//abstract class can't be instantiated


abstract class Animal {

    abstract fun sound()   // no - body

    fun sleep() {          // normal function
        println("Animal is sleeping")
    }
}

class Dog : Animal() {
    override fun sound() {
        println("Dog barks")
    }
}

fun main() {
    val d = Dog()
    d.sound()
    d.sleep()
}
// why we need
// when we need a base class but its exact implementation depend on child class
//animal->lion,cat,dog
//each animal has sound but sound depend on the type(child) not animal . just simple animal class cant describe the sound.