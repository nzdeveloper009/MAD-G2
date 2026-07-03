package com.example.learnkotlin

//after DIP

interface InputDevice {

    fun type()
}

class Keyboard : InputDevice {

    override fun type() {
        println("Typing using Keyboard")
    }
}

class WirelessKeyboard : InputDevice {

    override fun type() {
        println("Typing using Wireless Keyboard")
    }
}

class Computer(private val inputDevice: InputDevice) {

    fun start() {
        inputDevice.type()
    }
}

fun main() {

    val keyboard: InputDevice = Keyboard()
    val computer = Computer(keyboard)
    computer.start()

    val wireless: InputDevice = WirelessKeyboard()
    val laptop = Computer(wireless)
    laptop.start()
}