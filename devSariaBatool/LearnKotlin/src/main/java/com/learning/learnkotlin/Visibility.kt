package com.learning.learnkotlin
object SharingWidget {
    private var twitterLikes = 0
    private var fbLikes = 0

    fun incrementTwitterLikes() {
        twitterLikes++
    }

    fun incrementFbLikes() {
        fbLikes++
    }

    fun display() {
        println("--- Sharing Widget Stats ---")
        println("Twitter Likes: $twitterLikes")
        println("Facebook Likes: $fbLikes")
        println("----------------------------")
    }
}

/**
 * 2. INTERFACE for Object Expression
 */
interface Cloneable {
    fun clone()
}

/**
 * 3. OPEN CLASS for Object Expression
 */
open class User(val name: String) {
    open fun fullName() {
        println("Full Name from Class: $name")
    }
}

fun main() {

    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementFbLikes()
    SharingWidget.display()


    val anonymousClone = object : Cloneable {
        override fun clone() {
            println("Status: Object Expression - I am an anonymous clone!")
        }
    }
    anonymousClone.clone()

    val anonymousPerson = object : User("Cheezy Code") {
        override fun fullName() {
            super.fullName()
            println("Status: Object Expression - Custom override for $name")
        }
    }
    anonymousPerson.fullName()


    val simpleObj = object {
        val x = 10
        val y = 20
        fun add() = x + y
    }
    println("Simple Anonymous Object Sum: ${simpleObj.add()}")
}