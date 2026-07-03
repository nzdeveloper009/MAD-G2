package com.example.learnkotlin


/*open class Bird {

    open fun fly() {
        println("Bird is flying")
    }
}

class Penguin : Bird() {

    override fun fly() {
        throw Exception("Penguins can't fly")
    }
}

fun makeBirdFly(bird: Bird) {
    bird.fly()
}

fun main() {

    val penguin = Penguin()
    makeBirdFly(penguin)
}*/

//subclass parent ka proper substitute nahi ban sakti

//after LSP

open class Bird

interface Flyable {
    fun fly()
}

class Sparrow : Bird(), Flyable {

    override fun fly() {
        println("Sparrow is flying")
    }
}

class Penguin : Bird() {

    fun swim() {
        println("Penguin is swimming")
    }
}

fun makeBirdFly(bird: Flyable) {
    bird.fly()
}

fun main() {

    val sparrow = Sparrow()
    makeBirdFly(sparrow)

    val penguin = Penguin()
    penguin.swim()
}

// sirf jo birds fly kar sakte hain (Flyable) unhi ko fly() diya gaya.
// penguin ab bhi Bird hai lekin us par fly() force nahi kiya gaya