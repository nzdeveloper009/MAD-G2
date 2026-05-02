package com.example.ayeshalearnkotlin
fun main() {
  //polymorphism
    val guitar: instrument = Guitar()
    val piano: instrument= Piano()
    //we can also see polymorphism here , as interface is behaving like a parent class here and its holding referances of child classes like guitar and piano.
    val football: Playable= football()
    guitar.play()
    guitar.makesasound()
    piano.play()
    piano.makesasound()
    football.play()
}
//we have created an interface playable here , which behaves like an abstract class but unlike abstract class many classes can be driven by it like  instrumrnt and football class.
interface Playable {
    fun play()
}
//multiple interfaces can also be implemented by using "," as a separater
abstract class instrument: Playable {
    abstract fun makesasound()
}

class Guitar : instrument() {
    override fun play() {
        println("Strumming the guitar ")
    }

    override fun makesasound() {
        println("Guitar makes a twang sound ")
    }
}

class Piano : instrument() {
    override fun play() {
        println("Playing the piano ")
    }

    override fun makesasound() {
        println("Piano makes a melodious sound ")
    }
}

class football : Playable {
    override fun play() {
        println("We can play football ")
    }
}