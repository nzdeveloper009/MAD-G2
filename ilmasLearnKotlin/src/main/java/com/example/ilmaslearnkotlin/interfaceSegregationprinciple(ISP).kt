package com.example.ilmaslearnkotlin
//Clients should not be forced to depend on interfaces they do not use.


// without Interface segregation principle we have to implement all function that we need or not
// bad approach
//interface SmartDevice {
//    fun turnOn()
//    fun playMusic()
//    fun makeCall()
//}
//class Smartphone : SmartDevice {
//    override fun turnOn() {
//        println("Phone turning on")
//    }
//
//    override fun playMusic() {
//        println("Playing music")
//    }
//
//    override fun makeCall() {
//        println("Making a call")
//    }
//}
//
//class SmartSpeaker : SmartDevice {
//    override fun turnOn() {
//        println("Speaker turning on")
//    }
//
//    override fun playMusic() {
//        println("Speaker playing music")
//    }
//
//    override fun makeCall() {
//        //  Not supported
//        throw UnsupportedOperationException("Cannot make calls")
//    }
//}



// with the help of interface segregation principle
interface Powerable {
    fun turnOn()
}

interface MusicPlayer {
    fun playMusic()
}

interface Callable {
    fun makeCall()
}
class Smartphone : Powerable, MusicPlayer, Callable {
    override fun turnOn() {
        println("Phone turning on")
    }

    override fun playMusic() {
        println("Playing music")
    }

    override fun makeCall() {
        println("Making a call")
    }
}

class SmartSpeaker : Powerable, MusicPlayer {
    override fun turnOn() {
        println("Speaker turning on")
    }

    override fun playMusic() {
        println("Speaker playing music")
    }
}
fun startDevice(device: Powerable) {
    device.turnOn()
}

fun play(device: MusicPlayer) {
    device.playMusic()
}

fun call(device: Callable) {
    device.makeCall()
}
fun main() {
    val phone = Smartphone()
    val speaker = SmartSpeaker()

    startDevice(phone)
    startDevice(speaker)

    play(phone)
    play(speaker)

    call(phone)
    // call(speaker)  Compile-time safety (correct design)
}