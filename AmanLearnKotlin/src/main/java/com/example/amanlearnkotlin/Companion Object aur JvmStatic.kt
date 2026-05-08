package com.example.amanlearnkotlin

fun main() {
    // Companion object ke methods ko direct class ke naam se call karte hain
    MyUtility.showToast("Success")

    // Non-companion object ko unke naam ke sath call karna padta hai
    MyUtility.InternalObj.helper()
}

class MyUtility {

    // Class mein sirf EK hi companion object ho sakta hai
    companion object {
        @JvmStatic
        fun showToast(msg: String) {
            println("Toast: $msg")
        }

        fun log(msg: String) {
            println("Log: $msg")
        }
    }

    // Normal object class ke andar ho sakta hai par iska naam lazmi hai
    object InternalObj {
        fun helper() {
            println("I am a helper method")
        }
    }
}