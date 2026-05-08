package com.example.amanlearnkotlin


fun main() {
    val myCircle = SmartCircle(4.0)
    val myPlayer = Player("Aman")

    // Array of Any (kyunki Circle aur Player alag classes hain)
    val collection = arrayOf(myCircle, myPlayer)

    for (item in collection) {
        // 1. Type Checking using 'is'
        if (item is SmartCircle) {
            // 2. Smart Casting: Kotlin ko pata chal gaya ke ye Circle hai
            // Isliye item.calculateArea() bina kisi cast ke chal raha hai
            println("Area of Circle: ${item.calculateArea()}")
        }
        else if (item is Player) {
            // Manually casting using 'as' (agar smart cast na ho raha ho)
            val p = item as Player
            p.sayHello()
        }
    }
}

interface Draggable {
    fun drag()
}

class SmartCircle(val radius: Double) : Draggable {
    override fun drag() = println("Circle is dragging")
    fun calculateArea() = 3.14 * radius * radius
}

class Player(val name: String) : Draggable {
    override fun drag() = println("Player is dragging")
    fun sayHello() = println("Hello, I am $name")
}