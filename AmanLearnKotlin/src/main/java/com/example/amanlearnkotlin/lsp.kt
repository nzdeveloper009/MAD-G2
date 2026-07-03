package com.example.amanlearnkotlin.com.example.amanlearnkotlin

import java.lang.UnsupportedOperationException

// VIOLATION EXAMPLE: Breaking LSP with incorrect inheritance
// Let's look at the classic example of birds. We create a generic Bird class that can fly.

open class BadBird {
    open fun fly() {
        println("Flying high in the sky!")
    }
}

class BadEagle : BadBird() {
    override fun fly() {
        println("Eagle is soaring through the clouds.")
    }
}

// Here is the violation. A Penguin is a bird, but it cannot fly!
// Overriding a method just to throw an exception or leave it empty breaks LSP.
// If you pass this BadPenguin into a system expecting any BadBird, the app will crash.
class BadPenguin : BadBird() {
    override fun fly() {
        throw UnsupportedOperationException("Help! Penguins cannot fly!")
    }
}


// CLEAN SOLUTION: Adhering to the Liskov Substitution Principle (LSP)
// To fix this, we break down our inheritance tree into smaller, accurate behaviors.
// We make sure the parent class only contains properties and actions that EVERY child can truly do.

open class Bird {
    open fun eat() {
        println("Eating bird food...")
    }
}

// We extract flying behavior into an interface or a specific subclass branch
interface FlyingBird {
    fun fly()
}

// Eagle can inherit from Bird and implement FlyingBird because it actually flies
class Eagle : Bird(), FlyingBird {
    override fun fly() {
        println("Eagle is flying gracefully.")
    }

    override fun eat() {
        println("Eagle is eating fish.")
    }
}

// Penguin only inherits from Bird. It doesn't implement FlyingBird.
// Now, a Penguin can safely substitute a Bird anywhere without causing hidden crashes.
class Penguin : Bird() {
    override fun eat() {
        println("Penguin is eating krill.")
    }
}


// Testing the system to see how substitution works safely now
fun main() {
    // This handler can accept ANY valid bird safely because the base Bird class
    // only forces behaviors that every single bird can actually do (like eating).
    fun feedTheBird(bird: Bird) {
        bird.eat()
    }

    val myEagle = Eagle()
    val myPenguin = Penguin()

    // Both substitutions work perfectly without breaking runtime stability
    feedTheBird(myEagle)
    feedTheBird(myPenguin)

    // Separate handling for things that actually fly
    fun letItFly(flyingBird: FlyingBird) {
        flyingBird.fly()
    }

    letItFly(myEagle) // Works fine, and we can't accidentally pass myPenguin here anymore!
}