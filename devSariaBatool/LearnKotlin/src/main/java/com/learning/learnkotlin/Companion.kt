package com.learning.learnkotlin

import kotlin.jvm.JvmStatic


class subject {


    object MyObject {
        fun f() {
            println("Function called from MyObject")
        }
    }

    object AnotherObject {
        fun g() {
            println("Function called from AnotherObject")
        }
    }

    companion object {
        fun f() {
            println("Function called directly via MyClass (Companion)")
        }

        @JvmStatic
        fun staticFunction() {
            println("This behaves like a true static method in Java")
        }
    }
}


class Users private constructor(val name: String) {
    companion object {
        fun create(name: String): User {
            return User(name)
        }
    }
}

fun main() {
    subject.MyObject.f()
    subject.AnotherObject.g()


    subject.f()

    val user = Users.create("CheezyCode")
    println("User created: ${user.name}")


    subject.staticFunction()
}

