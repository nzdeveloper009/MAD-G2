package com.example.amanlearnkotlin

fun main() {
    //1. Object Declaration (Singleton) Test
    GlobalTracker.addScore(10)
    GlobalTracker.addScore(5)
    GlobalTracker.showFinalScore()

 //2. Object Expression (Anonymous) Test

    // Interface ka temporary object
    val myClicker = object : TaskListener {
        override fun onTaskComplete() {
            println("Task finished successfully!")
        }
    }
    myClicker.onTaskComplete()

    // Class ka temporary object (Override on the fly)
    val specialGuest = object : BaseGuest("Aman") {
        override fun greet() {
            println("Special welcome to $name!")
        }
    }
    specialGuest.greet()
}
// Object Declaration (Singleton Pattern)

object GlobalTracker {
    private var totalScore = 0

    fun addScore(points: Int) {
        totalScore += points
    }

    fun showFinalScore() {
        println("Final Application Score: $totalScore")
    }
}

// Object Expression (Anonymous Classes)

interface TaskListener {
    fun onTaskComplete()
}

open class BaseGuest(val name: String) {
    open fun greet() {
        println("Hello $name")
    }
}